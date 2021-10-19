package agents;

import jade.content.Predicate;
import jade.content.abs.AbsPredicate;
import jade.content.lang.sl.SL1Vocabulary;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.UUID;

import LNPaymentOntology.*;
import util.*;


//The payment sender agent initiates the conversation
public class PaymentSenderAgent extends Agent {

    private enum State {
        INITIAL,    // 1
        PROPOSED,   // 2
        PAID,       // 3
        SUCCESS,    // 4
        FAILURE
    };

    private Logger myLogger = Logger.getJADELogger(getClass().getName());

    private PriceAPIWrapper priceApi;

    private LNgrpcClient lnClient;

    //Maximum fees in sats for a single payment
    private int feeLimitSat = 50;

    protected ArrayList<CompletePayment> completePaymentsList;

    protected void setup() {

        completePaymentsList = new ArrayList<CompletePayment>();

        // Register the codec for the SL0 language
        getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL1);
        // Register the ontology used by this application
        getContentManager().registerOntology(LNPaymentOntology.getInstance());

    }

    protected void setPriceApi(PriceAPI priceApiImplementation) {
        priceApi = new PriceAPIWrapper(priceApiImplementation);
    }

    protected void setLNHost(String host, int port, String certPath, String macaroonPath) {
        try {
            lnClient = new LNgrpcClient(host, port, certPath, macaroonPath);
        } catch (LightningNetworkException e) {
            myLogger.log(Logger.SEVERE, "Sender Agent: " + e.getMessage());
        }
    }

    //set fee limit in satoshis
    protected void setFeeLimit(int feeLimit) {
        feeLimitSat = feeLimit;
    }

    protected void enableDebugLogging() {
        //fine logging does not seem to work unless JADE logger manager is activated
        myLogger.setLevel(Logger.FINE);
    }

    //this can be overwritten to invoke desired action after the payment completes
    protected void paymentComplete(CompletePayment payment) {
        if (payment.isSuccess()) {
            myLogger.log(Logger.INFO, "Sender Agent: Payment success.");
        } else {
            myLogger.log(Logger.SEVERE, "Sender Agent: Payment failed.");
            myLogger.log(Logger.SEVERE, payment.getFailureReason());
        }
    }

    protected class PaymentSendBehaviour extends Behaviour {

        //The counterparty agent
        private AID receiverAgent;
        //State of the protocol. Internal to this agent, does not correspond to the state of the counterparty.
        private State state;
        //conversation id
        private UUID convId;

        //maximum amount of propositions to do
        private int maxRetries;
        //retries used
        private int retries = 0;

        private PaymentProposal paymentProposal;

        private String rHashHex;

        //to time the execution time
        private TransactionTimer timer;

        private long feePaidSats;

        //template for replies, updated on every state
        private MessageTemplate replyTemplate;

        Ontology ontology;

        private String failureReason = "";


        protected PaymentSendBehaviour(Agent a, AID receiverAgent, String currency, double valCurr, String payId) {

            super(a);

            myLogger.log(Logger.FINE, "Starting PaymentSendBehaviour");

            timer = new TransactionTimer();
            timer.setStartTime();

            this.receiverAgent = receiverAgent;
            this.state = State.INITIAL;

            paymentProposal = new PaymentProposal();
            paymentProposal.setCurrency(currency);
            paymentProposal.setPayId(payId);
            paymentProposal.setCurrencyValue(valCurr);

            this.convId = UUID.randomUUID(); //set the conversation id

            this.maxRetries = 3;

            this.ontology = getContentManager().lookupOntology(LNPaymentOntology.ONTOLOGY_NAME);
        }

        public void action() {

            ACLMessage msgIn = null;
            if (state != State.INITIAL) {
                msgIn = myAgent.receive(replyTemplate);
            }

            switch (state) {
                case INITIAL:

                    try {

                        double currVal = paymentProposal.getCurrencyValue();
                        String currency = paymentProposal.getCurrency();

                        if (currVal < 0) {
                            throw new RuntimeException("Currency value cannot be negative.");
                        } else if (currency.isEmpty()) {
                            throw new RuntimeException("Currency unit missing.");
                        }

                        //check that priceApi exists
                        if(priceApi == null) {
                            throw new RuntimeException("PriceApi not defined");
                        }

                        //Get the value converted to satoshis from the API. Cast to int, so satoshis are int value.
                        paymentProposal.setSatsValue(priceApi.getSatsValue(currVal,currency));

                        //check that can connect to the LN client
                        if(!lnClient.canConnect()) {
                            throw new RuntimeException("Cannot connect to LND");
                        }

                        //check that has enough balance to send on the ln node
                        if (lnClient.getSendableBalance() < paymentProposal.getSatsValue()) {
                            throw new RuntimeException("Not enough outgoing balance.");
                        }

                        myLogger.log(Logger.FINE, "Payment proposal created: "+paymentProposal.getAsStringForLogging());

                        //SEND THE INITIATION
                        ACLMessage propose = createInitMessage();

                        //Construct agent action and add as content
                        AcceptPaymentProposalAndCreateLNInvoice acceptPaymentProposal = new AcceptPaymentProposalAndCreateLNInvoice();
                        acceptPaymentProposal.setPaymentProposal(paymentProposal);
                        Action acceptPaymentProposalAction = new Action();
                        acceptPaymentProposalAction.setAction(acceptPaymentProposal);
                        acceptPaymentProposalAction.setActor(receiverAgent);

                        myAgent.getContentManager().fillContent(propose, acceptPaymentProposalAction);
                        myAgent.send(propose);

                        //set template for reply
                        setMessageTemplate(new int[]{ACLMessage.ACCEPT_PROPOSAL, ACLMessage.REJECT_PROPOSAL}, propose.getReplyWith());

                        state = State.PROPOSED;

                    } catch (Exception e) {
                        myLogger.log(Logger.WARNING, "Sender Agent: "+e.getMessage());
                        //e.printStackTrace();

                        //add to retries if sending initiation fails
                        retries += 1;
                        failureReason = e.getMessage();
                        state = State.INITIAL;
                    }

                    break;
                case PROPOSED:
                    //Receive the accepted message including the invoice
                    if(msgIn != null){
                        try {
                            PaymentProposalAccepted proposalReply = (PaymentProposalAccepted) myAgent.getContentManager().extractContent(msgIn);

                            if (proposalReply.isAccepted()) {
                                //receiver accepted the payment proposal

                                //Get the lightning network encoded invoice
                                String invoiceStr = proposalReply.getLnInvoice().getInvoicestr();
                                //check that the ln invoice amount and memo corresponds to the payment proposal
                                boolean invoiceOk = lnClient.checkInvoiceStrCorresponds(
                                        invoiceStr,
                                        paymentProposal.getSatsValue(),
                                        convId.toString(),
                                        paymentProposal.getPayId(),
                                        paymentProposal.getCurrencyValue(),
                                        paymentProposal.getCurrency());

                                if(!invoiceOk) {
                                    throw new RuntimeException("The invoice is not what was proposed.");
                                }

                                //timing for the actual payment
                                timer.setPaymentStartTime();
                                //save the payment hash of the paid invoice
                                rHashHex = lnClient.sendPayment(invoiceStr, feeLimitSat);
                                timer.setPaymentEndTime();

                                if(rHashHex.isEmpty()) {
                                    throw new RuntimeException("Paying the invoice failed.");
                                }

                                //no errors thrown: invoice ok and paid

                                feePaidSats = lnClient.getFeesPaid(rHashHex);

                                //create reply
                                ACLMessage receivedPaymentQueryMsg = msgIn.createReply();
                                receivedPaymentQueryMsg.setPerformative(ACLMessage.QUERY_IF);

                                ReceivedPayment receivedPayment = new ReceivedPayment();
                                receivedPayment.setPaymentHash(rHashHex);

                                myAgent.getContentManager().fillContent(receivedPaymentQueryMsg, receivedPayment);
                                myAgent.send(receivedPaymentQueryMsg);

                                state = State.PAID;
                                setMessageTemplate(new int[]{ACLMessage.INFORM}, receivedPaymentQueryMsg.getReplyWith());

                            } else {

                                myLogger.log(Logger.WARNING, "Sender Agent: Proposal rejected because of: "+proposalReply.getReasonForRejection()+" Retrying if retry attempts remaining.");

                                //proposal rejected, naively retry
                                state = State.INITIAL;
                                retries += 1;

                                //possible improvement: react to different rejections differently
                            }
                        } catch (Exception e) {
                            failureReason = e.getMessage();
                            myLogger.log(Logger.SEVERE, "Sender Agent: "+failureReason);

                            ACLMessage failureMsg = msgIn.createReply();
                            failureMsg.setPerformative(ACLMessage.FAILURE);
                            myAgent.send(failureMsg);
                            state = State.FAILURE;
                        }
                    }else{
                        block();
                    }
                    break;
                case PAID:
                    //receive the final inform message to conclude the payment
                    if (msgIn != null) {
                        try {

                            //Check if receiver informed true or false
                            Predicate pred = (Predicate)myAgent.getContentManager().extractContent(msgIn);

                            if (pred.getClass().equals(ReceivedPayment.class)) {
                                state = State.SUCCESS;
                                timer.setEndTime();
                            } else if (((AbsPredicate)pred).getTypeName().equals(SL1Vocabulary.NOT)) {
                                throw new RuntimeException("Received inform message, that the receiver did not receive the payment.");
                            } else {
                                throw new RuntimeException("Received a message with a predicate that was not understood.");
                            }
                        } catch (Exception e) {
                            state = State.FAILURE;
                            failureReason = e.getMessage();
                        }
                    }
                    break;
            }
        }

        public boolean done() {

            //retried too many times
            if(retries >= maxRetries) {
                state = State.FAILURE;
            }

            //end
            if (state == State.FAILURE) {
                CompletePayment p = new CompletePayment(CompletePayment.Role.SENDER, false, paymentProposal, rHashHex, convId, receiverAgent, feePaidSats, timer);
                p.setFailureReason(failureReason);
                completePaymentsList.add(p);
                paymentComplete(p);
                return true;
            }
            if (state == State.SUCCESS) {
                CompletePayment p = new CompletePayment(CompletePayment.Role.SENDER, true, paymentProposal, rHashHex, convId, receiverAgent, feePaidSats, timer);
                completePaymentsList.add(p);
                paymentComplete(p);
                return true;
            }

            //continue
            return false;
        }

        private ACLMessage createInitMessage() {

            //Create a new ACLMessage and init with common values
            ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
            msg.addReceiver(receiverAgent);
            msg.setProtocol(LNPaymentProtocol.getProtocolName());
            msg.setOntology(LNPaymentOntology.ONTOLOGY_NAME);
            msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL1);
            msg.setConversationId(convId.toString());
            msg.setReplyWith("Init_ln_tx_protocol_"+System.currentTimeMillis()); // Unique value

            return msg;
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