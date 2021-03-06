package agents;

import jade.content.Predicate;
import jade.content.abs.AbsPredicate;
import jade.content.lang.Codec;
import jade.content.lang.sl.SL1Vocabulary;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.*;
import jade.core.behaviours.*;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.UUID;

import LNPaymentOntology.*;
import util.*;

public class PaymentReceiverAgent extends Agent{

    private enum State {
        INITIAL,            // 1
        PROPOSAL_ACCEPTED,  // 2
        SUCCESS,            // 3
        FAILURE
    };

    private Logger myLogger = Logger.getJADELogger(getClass().getName());

    private PriceAPIWrapper priceApi;

    private LNgrpcClient lnClient;

    //Price tolerance: accepted relative deviation in bitcoin price (0-1)
    private double priceTolerance = 0.02; // 2 %

    protected ArrayList<CompletePayment> completePaymentsList;

    protected void setup() {

        completePaymentsList = new ArrayList<CompletePayment>();

        //set logging level
        boolean debug = true;
        if (debug) {
            //debug logging
            myLogger.setLevel(Logger.FINE);
        } else {
            //normal logging
            myLogger.setLevel(Logger.INFO);
        }

        // Register the codec for the SL1 language
        getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL1);
        // Register the ontology used by this application
        getContentManager().registerOntology(LNPaymentOntology.getInstance());

    }

    protected void setLNHost(String host, int port, String certPath, String macaroonPath) {
        try {
            lnClient = new LNgrpcClient(host, port, certPath, macaroonPath);
        } catch (LightningNetworkException e) {
            myLogger.log(Logger.SEVERE, "Receiver agent: " + e.getMessage());
        }
    }

    protected void setPriceTolerance(double tol) {
        if(tol < 0 || tol > 1) {
            throw new RuntimeException("Price tolerance out of bounds.");
        }
        priceTolerance = tol;
    }

    protected void setPriceApi(PriceAPI priceApiImplementation) {
        priceApi = new PriceAPIWrapper(priceApiImplementation);
    }

    protected void enableDebugLogging() {
        //fine logging does not seem to work unless JADE logger manager is activated
        myLogger.setLevel(Logger.FINE);
    }

    //this function can be overwritten to set rules for proposal acceptance
    protected boolean isProposalAccepted(PaymentProposal proposal) {
        myLogger.log(Logger.INFO, "Receiver Agent: Using default isProposalAccepted function. All proposals are accepted.");
        return true;
    }

    //this can be overwritten to invoke desired action after the payment completes
    protected void paymentComplete(CompletePayment payment) {
        if (payment.isSuccess()) {
            myLogger.log(Logger.INFO, "Receiver Agent: Payment success.");
        } else {
            myLogger.log(Logger.SEVERE, "Receiver Agent: Payment failed.");
            myLogger.log(Logger.SEVERE, payment.getFailureReason());
        }
    }

    protected class PaymentReceiveBehaviour extends Behaviour {

        //The counterparty agent
        private AID senderAgent;
        //State of the protocol. Internal to this agent, does not correspond to the state of the counterparty.
        private State state = State.INITIAL;
        //Conversation id
        private UUID convId;
        //template for replies, updated on every state
        private MessageTemplate replyTemplate;

        private PaymentProposal receivedPaymentProposal;

        private String rHashHex;

        //if false, stop after receiving one successful payment or failure
        private boolean perpetualOperation;

        private String failureReason = "";

        protected PaymentReceiveBehaviour(Agent a, boolean perpetual) {
            super(a);
            myLogger.log(Logger.FINE, "Starting PaymentReceiveBehaviour");
            perpetualOperation = perpetual;
            initializeBehaviour();
        }

        public void action() {
            ACLMessage msgIn = myAgent.receive(replyTemplate);

            switch (state) {
                case INITIAL:
                    if (msgIn != null) {

                        //By default accept the proposal
                        //Set to false if any validation fails
                        boolean acceptProposal = true;
                        String rejectionReason = "";

                        //Possible improvement: limit the amount of retries accepted from the same agent

                        try {

                            //validate the initiation message
                            if (msgIn.getConversationId().isEmpty()) {
                                rejectionReason += "\nInitiation message doesn't have a conversation id!";
                                acceptProposal = false;
                            }

                            Action contentAction = (Action)myAgent.getContentManager().extractContent(msgIn);
                            AcceptPaymentProposalAndCreateLNInvoice acceptPaymentProposalAndCreateLNInvoice = (AcceptPaymentProposalAndCreateLNInvoice) contentAction.getAction();

                            if(acceptPaymentProposalAndCreateLNInvoice == null) {
                                rejectionReason += "\nInitiation message doesn't have valid content!";
                                acceptProposal = false;
                            }

                            receivedPaymentProposal = acceptPaymentProposalAndCreateLNInvoice.getPaymentProposal();

                            //check if the payment id and price are accepted
                            //isProposalAccepted function can be overwritten to set the conditions in the child class
                            if(!isProposalAccepted(receivedPaymentProposal)) {
                                rejectionReason += "\nPayment id or price not accepted!";
                                acceptProposal = false;
                            }

                            //check that priceApi exists
                            if(priceApi == null) {
                                throw new RuntimeException("PriceApi not defined");
                            }

                            //validate that the satoshis price matches to the proposed value in traditional currency
                            int fetchedSatsValue = priceApi.getSatsValue(receivedPaymentProposal.getCurrencyValue(),receivedPaymentProposal.getCurrency());
                            int proposedSatsValue = receivedPaymentProposal.getSatsValue();
                            double satsValueDeviation = Math.abs(((double)fetchedSatsValue)-((double)proposedSatsValue))/((double)fetchedSatsValue);

                            myLogger.log(Logger.FINE,
                                    "Payment proposal: satoshis value: "+ proposedSatsValue +
                                            ", fetched satoshis value: "+ fetchedSatsValue +
                                            ", relative difference: "+ satsValueDeviation);

                            if(satsValueDeviation > priceTolerance) {
                                rejectionReason += "\nSatoshi values don't match, deviation: "+satsValueDeviation;
                                acceptProposal = false;
                            }

                            //check that can connect to the LN client
                            if(!lnClient.canConnect()) {
                                throw new RuntimeException("Cannot connect to LND");
                            }

                            if(lnClient.getReceivableBalance() < proposedSatsValue) {
                                //too little incoming ln balance
                                rejectionReason += "\nToo little incoming channel balance.";
                                acceptProposal = false;
                            }

                            if (acceptProposal) {

                                convId = UUID.fromString(msgIn.getConversationId());
                                senderAgent = msgIn.getSender();

                                //create reply
                                ACLMessage accept = msgIn.createReply();
                                accept.setPerformative(ACLMessage.ACCEPT_PROPOSAL);

                                //create the invoice and add message to the invoice (conv id, payment proposal)
                                String[] createdInvoiceTuple = lnClient.createInvoice(
                                        proposedSatsValue,
                                        convId.toString(),
                                        receivedPaymentProposal.getPayId(),
                                        receivedPaymentProposal.getCurrencyValue(),
                                        receivedPaymentProposal.getCurrency()
                                );

                                String invoiceStr = createdInvoiceTuple[0];
                                //save the rHash
                                rHashHex = createdInvoiceTuple[1];

                                //Construct agent action and add as content
                                LNInvoice invoice = new LNInvoice();
                                invoice.setInvoicestr(invoiceStr);
                                PaymentProposalAccepted paymentProposalAccepted = new PaymentProposalAccepted();
                                paymentProposalAccepted.setLnInvoice(invoice);
                                paymentProposalAccepted.setPaymentProposal(receivedPaymentProposal);
                                paymentProposalAccepted.setReasonForRejection("");

                                myAgent.getContentManager().fillContent(accept, paymentProposalAccepted);

                                myAgent.send(accept);

                                setMessageTemplate(new int[]{ACLMessage.QUERY_IF, ACLMessage.FAILURE}, accept.getReplyWith());
                                state = State.PROPOSAL_ACCEPTED;
                            } else {
                                myLogger.log(Logger.WARNING, "Receiver Agent: rejecting payment proposal:"+rejectionReason);
                                sendRejectionOfProposal(msgIn, rejectionReason);
                            }

                        }
                        catch (Exception e){
                            myLogger.log(Logger.WARNING, "Receiver Agent: rejecting payment proposal because of exception:\n"+e.getMessage());
                            sendRejectionOfProposal(msgIn, e.getMessage());
                            //e.printStackTrace();
                            initializeBehaviour();
                        }
                    } else {
                        block();
                    }

                    break;

                case PROPOSAL_ACCEPTED:
                    //proposal accepted. should receive query-if: is payment received
                    if (msgIn != null) {
                        try {

                            //Counterparty couldn't make the payment
                            if(msgIn.getPerformative() == ACLMessage.FAILURE) {
                                //failure: payment is not paid
                                throw new RuntimeException("The payment was not made");
                            }

                            Predicate pred = (Predicate)myAgent.getContentManager().extractContent(msgIn);
                            if (!(pred instanceof ReceivedPayment)) {
                                throw new RuntimeException("The predicate is of wrong type("+pred.getClass().toString()+"). Should be query-if.");
                            }
                            ReceivedPayment receivedPayment = (ReceivedPayment)pred;
                            String senderPaymentHash = receivedPayment.getPaymentHash();

                            //check that payment hashes (rHashes) correspond
                            if (!senderPaymentHash.equals(rHashHex)) {
                                throw new RuntimeException("The payment hash does not correspond to the invoice.");
                            }

                            long receivedAmount = lnClient.amountOfPaymentReceived(senderPaymentHash);
                            int proposedAmount = receivedPaymentProposal.getSatsValue();

                            //check if the amount received is bigger or smaller than the proposed amount
                            //the amounts should be exactly equal
                            if (receivedAmount < proposedAmount) {
                                throw new RuntimeException("Received amount is less than the expected amount.");
                            } else if (receivedAmount > proposedAmount) {
                                //received more than required
                                myLogger.log(Logger.INFO, "Received "+String.valueOf(receivedAmount)+", instead of "+String.valueOf(proposedAmount));
                            }

                            //reply true
                            ACLMessage informTrue = msgIn.createReply();
                            informTrue.setPerformative(ACLMessage.INFORM);
                            myAgent.getContentManager().fillContent(informTrue, receivedPayment);
                            myAgent.send(informTrue);
                            state = State.SUCCESS;

                        } catch (Exception e) {

                            myLogger.log(Logger.SEVERE, "Receiver agent: "+e.getMessage());
                            failureReason = e.getMessage();
                            state = State.FAILURE;

                            //respond that did not receive the payment
                            ACLMessage informFalse = msgIn.createReply();
                            informFalse.setPerformative(ACLMessage.INFORM);
                            ReceivedPayment receivedPayment = new ReceivedPayment();
                            receivedPayment.setPaymentHash(rHashHex);
                            AbsPredicate notReceivedPayment = new AbsPredicate(SL1Vocabulary.NOT);
                            try {
                                notReceivedPayment.set(SL1Vocabulary.NOT_WHAT, getContentManager().lookupOntology(LNPaymentOntology.ONTOLOGY_NAME).fromObject(receivedPayment));
                                myAgent.getContentManager().fillContent(informFalse, notReceivedPayment);
                                myAgent.send(informFalse);
                            } catch (Codec.CodecException ex) {
                                ex.printStackTrace();
                            } catch (OntologyException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    break;

            }
        }

        public boolean done() {

            if (state == State.FAILURE) {

                //set fees to null as the receiver does not know how much fees was paid
                CompletePayment p = new CompletePayment(CompletePayment.Role.RECEIVER, false, receivedPaymentProposal, rHashHex, convId, senderAgent, -1, null);
                p.setFailureReason(failureReason);
                completePaymentsList.add(p);
                paymentComplete(p);

                //quit behaviour if not perpetual
                if(!perpetualOperation) {
                    return true;
                }

                //if finish, then init the state
                initializeBehaviour();
            }

            if (state == State.SUCCESS) {

                //set fees to null as the receiver does not know how much fees was paid
                CompletePayment p = new CompletePayment(CompletePayment.Role.RECEIVER, true, receivedPaymentProposal, rHashHex, convId, senderAgent, -1, null);
                completePaymentsList.add(p);
                paymentComplete(p);

                //quit behaviour if not perpetual
                if(!perpetualOperation) {
                    return true;
                }

                //if finish, then init the state
                initializeBehaviour();
            }

            //continue
            return false;
        }

        private void sendRejectionOfProposal (ACLMessage msgIn, String reason) {
            //Reject the proposal

            //Possible improvement: respond with a structured rejection

            ACLMessage reject = msgIn.createReply();
            reject.setPerformative(ACLMessage.REJECT_PROPOSAL);

            PaymentProposalAccepted paymentProposalAccepted = new PaymentProposalAccepted();
            paymentProposalAccepted.setPaymentProposal(receivedPaymentProposal);
            paymentProposalAccepted.setReasonForRejection(reason);
            //add empty invoice
            LNInvoice invoice = new LNInvoice();
            invoice.setInvoicestr("");
            paymentProposalAccepted.setLnInvoice(invoice);

            try {
                //reject by setting NOT accepted
                AbsPredicate paymentProposalRejected = new AbsPredicate(SL1Vocabulary.NOT);
                paymentProposalRejected.set(SL1Vocabulary.NOT_WHAT, getContentManager().lookupOntology(LNPaymentOntology.ONTOLOGY_NAME).fromObject(paymentProposalAccepted));
                myAgent.getContentManager().fillContent(reject, paymentProposalRejected);
                myAgent.send(reject);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //state stays initial
        }

        private void initializeBehaviour () {
            convId = null;
            senderAgent = null;
            state = State.INITIAL;
            receivedPaymentProposal = null;
            setMessageTemplate(new int[]{ACLMessage.PROPOSE}, "");
        }

        private void setMessageTemplate(int[] acceptedPerformatives, String inReplyTo) {

            //always add protocol to the template
            MessageTemplate template = MessageTemplate.MatchProtocol(LNPaymentProtocol.getProtocolName());

            //add conversation id if exists
            if (this.convId != null && this.convId.toString() != "") {
                template = MessageTemplate.and(template, MessageTemplate.MatchConversationId(this.convId.toString()));
            }

            //add 'in reply to' if given
            if(!inReplyTo.isEmpty()) {
                template = MessageTemplate.and(template, MessageTemplate.MatchInReplyTo(inReplyTo));
            }

            //add performatives if any
            if (acceptedPerformatives.length > 0) {
                //add the first performative
                MessageTemplate performativesTemplate = MessageTemplate.MatchPerformative(acceptedPerformatives[0]);
                //add other performatives if exist
                for (int i = 1; i < acceptedPerformatives.length; i++) {
                    performativesTemplate = MessageTemplate.or(performativesTemplate, MessageTemplate.MatchPerformative(acceptedPerformatives[i]));
                }
                template = MessageTemplate.and(template, performativesTemplate);
            }

            this.replyTemplate = template;
        }

    }
}