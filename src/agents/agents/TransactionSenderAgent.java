package agents;

import LNTxOntology.*;
import jade.content.Predicate;
import jade.content.abs.AbsPredicate;
import jade.content.lang.Codec;
import jade.content.lang.sl.SL0Vocabulary;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.TrueProposition;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.UUID;

import util.*;


//The transaction sender agent initiates the conversation
public class TransactionSenderAgent extends Agent {

    private enum State {
        INITIAL,    // 1
        PROPOSED,   // 2
        PAID,       // 3
        SUCCESS,    // 4
        FAILURE
    };

    private Logger myLogger = Logger.getJADELogger(getClass().getName());

    private PriceAPIWrapper priceApi;

    protected void setup() {

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

        priceApi = new PriceAPIWrapper(new PriceAPICoinGecko());

    }

    protected void setPriceApi(PriceAPI priceApiImplementation) {
        priceApi = new PriceAPIWrapper(priceApiImplementation);
    }


    protected class TransactSendBehaviour extends Behaviour {

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

        //template for replies, updated on every state
        private MessageTemplate replyTemplate;

        Ontology ontology;


        protected TransactSendBehaviour(Agent a, AID receiverAgent, String currency, double valCurr, String prodID) {

            super(a);

            myLogger.log(Logger.FINE, "Starting TransactSendBehaviour");

            this.receiverAgent = receiverAgent;
            this.state = State.INITIAL;

            paymentProposal = new PaymentProposal();
            paymentProposal.setCurrency(currency);
            paymentProposal.setProdid(prodID);
            paymentProposal.setCurrencyvalue(valCurr);

            this.convId = UUID.randomUUID(); //set the conversation id

            this.maxRetries = 5;

            this.ontology = getContentManager().lookupOntology(LNTxOntology.ONTOLOGY_NAME);
        }

        public void action() {

            ACLMessage msgIn = null;
            if (state != State.INITIAL) {
                msgIn = myAgent.receive(replyTemplate);
            }

            switch (state) {
                case INITIAL:

                    try {

                        double currVal = paymentProposal.getCurrencyvalue();
                        String currency = paymentProposal.getCurrency();

                        if (currVal < 0) {
                            throw new RuntimeException("Currency value cannot be negative.");
                        } else if (currency.isEmpty()) {
                            throw new RuntimeException("Currency unit missing.");
                        }

                        //Get the value converted to satoshis from the API. Cast to int, so satoshis are int value.
                        paymentProposal.setSatsvalue(priceApi.getSatsValue(currVal,currency));

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
                        e.printStackTrace();

                        //add to retries if sending initiation fails
                        retries += 1;
                        state = State.INITIAL;
                    }

                    break;
                case PROPOSED:
                    //Receive the accepted message including the invoice
                    if(msgIn != null){
                        try {
                            PaymentProposalAccepted proposalReply = (PaymentProposalAccepted) myAgent.getContentManager().extractContent(msgIn);

                            boolean proposalAccepted = proposalReply.isAccepted();
                            LNInvoice invoice = proposalReply.getLnInvoice();

                            if (proposalAccepted) {

                                //by default not paid
                                boolean invoiceValidAndPaid = false;

                                //TODO: VALIDATE AND PAY THE INVOICE

                                //check that the sats value in invoice is the same as in initial proposal
                                //check that the invoice contains correct message
                                //paymentProposal.

                                invoiceValidAndPaid = true; //TODO: MOCK ARVO, SIIRRÄ MUUALLE

                                if (invoiceValidAndPaid) {

                                    //create reply
                                    ACLMessage receivedPaymentQueryMsg = msgIn.createReply();
                                    receivedPaymentQueryMsg.setPerformative(ACLMessage.QUERY_IF);

                                    ReceivedPaymentQuery invoiceQuery = new ReceivedPaymentQuery();
                                    invoiceQuery.setLnInvoice(invoice);

                                    Action respondIsPaymentReceivedAction = new Action();
                                    respondIsPaymentReceivedAction.setAction(invoiceQuery);
                                    respondIsPaymentReceivedAction.setActor(receiverAgent);

                                    myAgent.getContentManager().fillContent(receivedPaymentQueryMsg, respondIsPaymentReceivedAction);

                                    myAgent.send(receivedPaymentQueryMsg);

                                    state = State.PAID;
                                    setMessageTemplate(new int[]{ACLMessage.INFORM}, receivedPaymentQueryMsg.getReplyWith());

                                } else {
                                    //reply failure
                                    state = State.FAILURE;
                                    ACLMessage failureMsg = msgIn.createReply();
                                    failureMsg.setPerformative(ACLMessage.FAILURE);
                                    myAgent.send(failureMsg);
                                }

                            } else {
                                //proposal rejected, naively retry
                                state = State.INITIAL;
                                retries += 1;
                            }
                        }catch (Exception e) {
                            myLogger.log(Logger.WARNING, "Sender Agent: Error in receiving response to proposal.");
                            e.printStackTrace();
                            state = State.FAILURE; //FAILED
                        }

                    }else{
                        block();
                    }
                    break;
                case PAID:
                    //receive the final inform message to conclude the transaction
                    if (msgIn != null) {
                        try {

                            //Prepositions are compared using class
                            Class informClass = myAgent.getContentManager().extractContent(msgIn).getClass();
                            Class trueClass = (new TrueProposition()).getClass();

                            if(informClass.equals(trueClass)) {
                                state = State.SUCCESS;
                                myLogger.log(Logger.INFO, "SUCCESS, PAYMENT SENT");
                            } else {
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

            //retried too many times
            if(retries >= maxRetries) {
                state = State.FAILURE;
            }

            //end
            if (state == State.FAILURE) {
                myLogger.log(Logger.WARNING, "Transaction failed.");
                return true;
            }
            if (state == State.SUCCESS) {
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
            msg.setOntology(LNTxOntology.ONTOLOGY_NAME);
            msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
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