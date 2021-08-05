package agents;

import LNTxOntology.*;
import jade.content.Predicate;
import jade.content.abs.AbsPredicate;
import jade.content.lang.Codec;
import jade.content.lang.sl.SL0Vocabulary;
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

import util.*;

public class TransactionReceiverAgent extends Agent{

    private enum State {
        INITIAL,            // 1
        PROPOSAL_ACCEPTED,  // 2
        SUCCESS,            // 3
        FAILURE
    };

    private Logger myLogger = Logger.getJADELogger(getClass().getName());

    private PriceAPIWrapper priceApi;

    private LNgrpcClient lnClient;

    private ProductCatalog productCatalog;

    //Price tolerance: accepted relative deviation in bitcoin price (0-1)
    private double priceTolerance = 0.01; // 1 %

    protected void setup() {

        System.out.println(myLogger.getName());

        //set logging level
        boolean debug = true;
        if (debug) {
            //debug logging
            myLogger.setLevel(Logger.FINE);
        } else {
            //normal logging
            myLogger.setLevel(Logger.INFO);
        }

        // Register the codec for the SL0 language
        getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
        // Register the ontology used by this application
        getContentManager().registerOntology(LNTxOntology.getInstance());

        //Use different price api than the sender to simulate realistic situation
        //priceApi = new PriceAPIWrapper(new PriceAPICoindesk());
        priceApi = new PriceAPIWrapper(new PriceAPIMock()); //TODO: USE REAL API
        productCatalog = new ProductCatalog();

    }

    protected void setLNHost(String host, int port, String certPath, String macaroonPath) {
        lnClient = new LNgrpcClient(host, port, certPath, macaroonPath);
    }

    protected void addProductToCatalog(String prodId, ArrayList<ProductPrice> prices) {

        ListedProduct p = new ListedProduct(prodId);

        for (int i = 0; i < prices.size(); i++) {
            p.addPrice(prices.get(i).getPrice(), prices.get(i).getCurrency());
        }

        productCatalog.addProduct(p);
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
        myLogger.setLevel(Logger.FINE);
        //TODO: NOT WORKING UNLESS LOGGER MANAGER IS ACTIVATED
    }

    protected class TransactReceiveBehaviour extends Behaviour {

        //The counterparty agent
        private AID senderAgent;
        //State of the protocol. Internal to this agent, does not correspond to the state of the counterparty.
        private State state = State.INITIAL;
        //Conversation id
        private UUID convId;
        //template for replies, updated on every state
        private MessageTemplate replyTemplate;

        private PaymentProposal receivedPaymentProposal;

        //if false, stop after receiving one successful payment or failure
        private boolean perpetualOperation;

        protected TransactReceiveBehaviour(Agent a, boolean perpetual) {
            super(a);
            myLogger.log(Logger.FINE, "Starting TransactReceiveBehaviour");
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

                        //TODO: RAJOITA MONTAKO KERTAA RETRY SAMALTA AGENTILTA

                        try {

                            //validate the initiation message
                            if (msgIn.getConversationId().isEmpty()) {
                                myLogger.log(Logger.WARNING, "Receiver Agent: Initiation message doesn't have a conversation id!");
                                acceptProposal = false;
                                //TODO: PALAUTA SYY MIKSI REJECT
                            }

                            Action contentAction = (Action)myAgent.getContentManager().extractContent(msgIn);
                            AcceptPaymentProposalAndCreateLNInvoice acceptPaymentProposalAndCreateLNInvoice = (AcceptPaymentProposalAndCreateLNInvoice) contentAction.getAction();

                            if(!(acceptPaymentProposalAndCreateLNInvoice instanceof AcceptPaymentProposalAndCreateLNInvoice)) {
                                myLogger.log(Logger.WARNING, "Receiver Agent: Initiation message doesn't have valid content!");
                                acceptProposal = false;
                                //TODO: PALAUTA SYY MIKSI REJECT
                            }

                            PaymentProposal receivedPaymentProposal = acceptPaymentProposalAndCreateLNInvoice.getPaymentProposal();

                            //validate that the product is allowed
                            if (!productCatalog.hasProductWithPrice(receivedPaymentProposal.getProdid(),receivedPaymentProposal.getCurrencyvalue(),receivedPaymentProposal.getCurrency())) {
                                myLogger.log(Logger.WARNING, "Receiver Agent: Product or price not accepted!");
                                acceptProposal = false;
                                //TODO: PALAUTA SYY MIKSI REJECT
                            }

                            //validate that the satoshis price matches to the proposed value in traditional currency
                            int fetchedSatsValue = priceApi.getSatsValue(receivedPaymentProposal.getCurrencyvalue(),receivedPaymentProposal.getCurrency());
                            int proposedSatsValue = receivedPaymentProposal.getSatsvalue();
                            double satsValueDeviation = Math.abs(((double)fetchedSatsValue)-((double)proposedSatsValue))/((double)fetchedSatsValue);

                            myLogger.log(Logger.FINE,
                                    "Payment proposal: satoshis value: "+ proposedSatsValue +
                                            ", fetched satoshis value: "+ fetchedSatsValue +
                                            ", relative difference: "+ satsValueDeviation);

                            if(satsValueDeviation > priceTolerance) {
                                myLogger.log(Logger.WARNING, "Receiver Agent: Satoshi values don't match, deviation: "+satsValueDeviation);
                                acceptProposal = false;
                                //TODO: PALAUTA SYY MIKSI REJECT (too big value deviation)
                            }

                            if(lnClient.getReceivableBalance() < proposedSatsValue) {
                                //too little incoming ln balance
                                myLogger.log(Logger.WARNING, "Receiver Agent: too little incoming channel balance.)");
                                acceptProposal = false;
                                //TODO: PALAUTA SYY MIKSI REJECT (too little incoming channel balance)
                            }

                            if (acceptProposal) {

                                convId = UUID.fromString(msgIn.getConversationId());
                                senderAgent = msgIn.getSender();

                                //create reply
                                ACLMessage accept = msgIn.createReply();
                                accept.setPerformative(ACLMessage.ACCEPT_PROPOSAL);

                                //TODO: ERROR HANDLING
                                //create the invoice and add message to the invoice (conv id, payment proposal)
                                String invoiceStr = lnClient.createInvoice(
                                        proposedSatsValue,
                                        convId.toString(),
                                        receivedPaymentProposal.getProdid(),
                                        receivedPaymentProposal.getCurrencyvalue(),
                                        receivedPaymentProposal.getCurrency()
                                );

                                //Construct agent action and add as content
                                LNInvoice invoice = new LNInvoice();
                                invoice.setInvoicestr(invoiceStr);
                                PaymentProposalAccepted paymentProposalAccepted = new PaymentProposalAccepted();
                                paymentProposalAccepted.setAccepted(true);
                                paymentProposalAccepted.setLnInvoice(invoice);
                                paymentProposalAccepted.setPaymentProposal(receivedPaymentProposal);

                                myAgent.getContentManager().fillContent(accept, paymentProposalAccepted);

                                myAgent.send(accept);

                                setMessageTemplate(new int[]{ACLMessage.QUERY_IF, ACLMessage.FAILURE}, accept.getReplyWith());
                                state = State.PROPOSAL_ACCEPTED;
                            } else {
                                sendRejectionOfProposal(msgIn, "TODO TÄHÄN REJECT VIESTI");
                            }

                        }
                        catch (Exception e){
                            //TODO: ERI VIRHEITÄ ERI EXCEPTIONEIDEN MUKAAN
                            myLogger.log(Logger.WARNING, "Rejected proposal because of exception.");
                            sendRejectionOfProposal(msgIn, "TODO TÄHÄN REJECT VIESTI");
                            e.printStackTrace();
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
                                //TODO: FAILURE
                                state = State.FAILURE;
                                break; //quit the action
                            }

                            //TODO: CHECK THAT PAYMENT IS RECEIVED

                            boolean paymentReceived = true;
                            if (paymentReceived) {

                                //reply true
                                ACLMessage informTrue = msgIn.createReply();
                                informTrue.setPerformative(ACLMessage.INFORM);

                                Predicate responseTrue = new AbsPredicate(SL0Vocabulary.TRUE_PROPOSITION);
                                myAgent.getContentManager().fillContent(informTrue, responseTrue);

                                myAgent.send(informTrue);
                                state = State.SUCCESS;
                                myLogger.log(Logger.INFO, "SUCCESS, PAYMENT RECEIVED");

                            } else {
                                //TODO: FAILURE
                                state = State.FAILURE;
                            }

                        } catch (Codec.CodecException e) {
                            e.printStackTrace();
                        } catch (OntologyException e) {
                            e.printStackTrace();
                        }

                    }
                    break;

            }
        }

        public boolean done() {

            if (state == State.FAILURE) {
                myLogger.log(Logger.WARNING, "Transaction failed.");

                //quit behaviour if not perpetual
                if(!perpetualOperation) {
                    return true;
                }

                //if finish, then init the state
                initializeBehaviour();
            }

            if (state == State.SUCCESS) {

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
            //TODO: respond with a formal rejection: why was rejected

            ACLMessage reject = msgIn.createReply();
            reject.setPerformative(ACLMessage.REJECT_PROPOSAL);

            PaymentProposalAccepted paymentProposalRejected = new PaymentProposalAccepted();
            paymentProposalRejected.setAccepted(false);
            paymentProposalRejected.setPaymentProposal(receivedPaymentProposal);
            //add empty invoice
            LNInvoice invoice = new LNInvoice();
            invoice.setInvoicestr("");
            paymentProposalRejected.setLnInvoice(invoice);

            try {
                myAgent.getContentManager().fillContent(reject, paymentProposalRejected);
                myAgent.send(reject);
            } catch (Codec.CodecException e) {
                e.printStackTrace();
            } catch (OntologyException e) {
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