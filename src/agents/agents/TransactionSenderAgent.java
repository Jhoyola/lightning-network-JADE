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
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.util.Logger;

import java.util.UUID;
import util.LNPaymentProtocol;
import util.PriceAPICoinGecko;
import util.PriceAPICoindesk;
import util.PriceAPIWrapper;


//The transaction sender agent initiates the conversation
public class TransactionSenderAgent extends Agent {

    private enum State {
        INITIAL,    // 1
        PROPOSED,   // 2
        PAID,       // 3
        SUCCESS,    // 4
        FAILURE
    };

    private Logger myLogger = Logger.getMyLogger(getClass().getName());

    private PriceAPIWrapper priceApi;

    protected void setup() {

        // Register the codec for the SL0 language
        getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
        // Register the ontology used by this application
        getContentManager().registerOntology(LNTxOntology.getInstance());

        priceApi = new PriceAPIWrapper(new PriceAPICoinGecko());

        //FOR TESTING, INITIATE THE PROTOCOL HERE
        //-----------------------------------------------
        addBehaviour(new StartTransactSendBehaviour(this));
        //-----------------------------------------------
    }


    private class TransactSendBehaviour extends Behaviour {

        private AID receiverAgent; //receiver

        private PaymentProposal paymentProposal;

        //State of the protocol. Internal to this agent, does not correspond to the state of the counterparty.
        private State state = State.INITIAL;

        private UUID convId;

        //template for replies, updated on every state
        private MessageTemplate replyTemplate;

        private MessageTemplate convBaseTemplate;

        Ontology ontology;


        public TransactSendBehaviour(Agent a, AID receiverAgent, String currency, double valCurr, String prodID) {
            super(a);
            this.receiverAgent = receiverAgent;

            paymentProposal = new PaymentProposal();
            paymentProposal.setCurrency(currency);
            paymentProposal.setProdid(prodID);
            paymentProposal.setCurrencyvalue(valCurr);

            this.convId = UUID.randomUUID(); //set the conversation id
            this.convBaseTemplate = MessageTemplate.and(
                    MessageTemplate.MatchProtocol(LNPaymentProtocol.getProtocolName()),
                    MessageTemplate.MatchConversationId(convId.toString()));

            this.ontology = getContentManager().lookupOntology(LNTxOntology.ONTOLOGY_NAME);
        }

        public void action() {

            ACLMessage msgIn = myAgent.receive(replyTemplate);

            switch (state) {
                case INITIAL:

                    //TODO: RAJOITA KUINKA MONTA YRITYSTÄ JOS REJECT

                    double currVal = paymentProposal.getCurrencyvalue();
                    String currency = paymentProposal.getCurrency();

                    //Get the value converted to satoshis from the API. Cast to int, so satoshis are int value.
                    paymentProposal.setSatsvalue(priceApi.getSatsValue(currVal,currency));

                    //SEND THE INITIATION
                    ACLMessage propose = initMessage(ACLMessage.PROPOSE, null);

                    //Construct agent action and add as content
                    AcceptPaymentProposalAndCreateLNInvoice acceptPaymentProposal = new AcceptPaymentProposalAndCreateLNInvoice();
                    acceptPaymentProposal.setPaymentProposal(paymentProposal);
                    Action acceptPaymentProposalAction = new Action();
                    acceptPaymentProposalAction.setAction(acceptPaymentProposal);
                    acceptPaymentProposalAction.setActor(receiverAgent);

                    try {
                        myAgent.getContentManager().fillContent(propose, acceptPaymentProposalAction);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    myAgent.send(propose);

                    //template: convId and (accept_proposal or reject_proposal) and replywith
                    replyTemplate =  MessageTemplate.and(convBaseTemplate,
                            MessageTemplate.and(
                                MessageTemplate.or(MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL), MessageTemplate.MatchPerformative(ACLMessage.REJECT_PROPOSAL)),
                                MessageTemplate.MatchInReplyTo(propose.getReplyWith())));

                    state = State.PROPOSED;
                    break;
                case PROPOSED:
                    if(msgIn != null){


                        try {
                            PaymentProposalAccepted proposalReply = (PaymentProposalAccepted) myAgent.getContentManager().extractContent(msgIn);

                            boolean proposalAccepted = proposalReply.isAccepted();
                            LNInvoice invoice = proposalReply.getLnInvoice();




                            //TODO: validate the incoming message



                            if (proposalAccepted) {

                                //by default not paid
                                boolean invoiceValidAndPaid = false;

                                //TODO: VALIDATE AND PAY THE INVOICE

                                invoiceValidAndPaid = true; //TODO: MOCK ARVO, SIIRRÄ MUUALLE

                                if (invoiceValidAndPaid) {
                                    //OK

                                    ACLMessage receivedPaymentQueryMsg = initMessage(ACLMessage.QUERY_IF, msgIn);

                                    ReceivedPaymentQuery invoiceQuery = new ReceivedPaymentQuery();
                                    invoiceQuery.setLnInvoice(invoice);

                                    Action respondIsPaymentReceivedAction = new Action();
                                    respondIsPaymentReceivedAction.setAction(invoiceQuery);
                                    respondIsPaymentReceivedAction.setActor(receiverAgent);

                                    myAgent.getContentManager().fillContent(receivedPaymentQueryMsg, respondIsPaymentReceivedAction);

                                    myAgent.send(receivedPaymentQueryMsg);

                                    state = State.PAID;

                                    //TODO: TÄSTÄ FUNKTIO??
                                    replyTemplate =  MessageTemplate.and(convBaseTemplate,
                                            MessageTemplate.and(
                                                    MessageTemplate.MatchPerformative(ACLMessage.INFORM),
                                                    MessageTemplate.MatchInReplyTo(receivedPaymentQueryMsg.getReplyWith())));

                                } else {
                                    state = State.FAILURE; //FAILED
                                }

                            } else {
                                //proposal rejected, naively retry
                                state = State.INITIAL;
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
                    if (msgIn != null) {

                        try {
                            //TEST

                            //Prepositions are compared using class
                            Class informClass = myAgent.getContentManager().extractContent(msgIn).getClass();
                            Class trueClass = (new TrueProposition()).getClass();

                            /*
                            System.out.println("test, msg in:");
                            System.out.println(inform.getClass());
                            System.out.println(inform.toString());
                            System.out.println("true pred:");
                            System.out.println(trueProposition.getClass());
                            System.out.println(trueProposition.toString());
                            */


                            if(informClass.equals(trueClass)) {
                                //TODO:HANDLE
                                myLogger.log(Logger.INFO, "RECEIVED INFORM TRUE");
                                state = State.SUCCESS;
                            } else {
                                //TODO:HANDLE
                                myLogger.log(Logger.WARNING, "RECEIVED INFORM FALSE");
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

            //end
            if (state == State.FAILURE) {
                myLogger.log(Logger.WARNING, "Transaction failed.");
                return true;
            }
            if (state == State.SUCCESS) {
                myLogger.log(Logger.INFO, "Transaction sender: Transaction completed successfully.");
                return true;
            }

            //continue
            return false;
        }

        private ACLMessage initMessage(int performative, ACLMessage replyTo) {
            //TODO: LISÄÄ ENCODING!? MYÖS TOISEEN AGENTTIIN!

            //Create a new ACLMessage and init with common values
            ACLMessage msg;
            if(replyTo != null) {
                //Is reply: replyTo method creates all boilerplate
                msg = replyTo.createReply();
                msg.setPerformative(performative);
            } else {
                msg = new ACLMessage(performative);
                msg.addReceiver(receiverAgent);
                msg.setProtocol(LNPaymentProtocol.getProtocolName());
                msg.setOntology(LNTxOntology.ONTOLOGY_NAME);
                msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
                msg.setConversationId(convId.toString());
                msg.setReplyWith("Init_ln_tx_protocol_"+System.currentTimeMillis()); // Unique value
            }

            return msg;
        }

    }

    //Find receivers and start protocol as sender
    private class StartTransactSendBehaviour extends OneShotBehaviour {

        Agent a;

        //TESTING VALUES FOR THE PROTOCOL
        String currency = "eur"; //base currency
        double valCurr = 0.1; //value in base currency
        String prodID = "TEST_PROD"; //product id for the receiver

        public StartTransactSendBehaviour(Agent a) {
            this.a = a;
        }

        public void action() {

            //SLEEP TO MAKE SURE THAT THE RECEIVER AGENT IS CREATED
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

            myLogger.log(Logger.INFO, "Start finding receivers");

            //Find receivers
            DFAgentDescription template = new DFAgentDescription();
            ServiceDescription sd = new ServiceDescription();
            sd.setType("receive-ln-tx");
            template.addServices(sd);

            try {
                DFAgentDescription[] result = DFService.search(myAgent, template);

                if(result.length > 0) {
                    myLogger.log(Logger.INFO, "Found a receiver, starting TransactSendBehaviour");
                    AID receiver = result[0].getName();
                    addBehaviour(new TransactSendBehaviour(a, receiver, currency, valCurr, prodID));
                } else {
                    myLogger.log(Logger.INFO, "Didn't find a receiver");
                }
            }
            catch (FIPAException fe) {
                fe.printStackTrace();
            }
        }
    }
}