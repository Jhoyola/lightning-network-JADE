package agents;

import LNTxOntology.*;
import jade.content.AgentAction;
import jade.content.ContentElement;
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
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.MessageTemplate;
import jade.tools.DummyAgent.DummyAgent;
import jade.util.Logger;

import java.util.UUID;
import util.LNPaymentProtocol;
import util.PriceAPICoinGecko;
import util.PriceAPICoindesk;
import util.PriceAPIWrapper;

public class TransactionReceiverAgent extends Agent{

    private enum State {
        INITIAL,            // 1
        PROPOSAL_REJECTED,
        PROPOSAL_ACCEPTED,  // 2
        SUCCESS,            // 3
        FAILURE
    };

    private Logger myLogger = Logger.getMyLogger(getClass().getName());

    private PriceAPIWrapper priceApi;

    //TODO: Get price tolerance dynamically from agent arguments
    //Price tolerance: accepted relative deviation in bitcoin price (0-1)
    private double priceTolerance = 0.01; // 1 %

    protected void setup() {

        // Register the codec for the SL0 language
        getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
        // Register the ontology used by this application
        getContentManager().registerOntology(LNTxOntology.getInstance());

        //Use different price api than the sender to simulate realistic situation
        priceApi = new PriceAPIWrapper(new PriceAPICoindesk());

        // Registration with the DF for the initiation
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("receive-ln-tx");
        sd.setName("TransactionReceiverAgentService");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
            addBehaviour(new TransactReceiveBehaviour(this));
        } catch (FIPAException e) {
            myLogger.log(Logger.SEVERE, "Agent "+getLocalName()+" - Cannot register with DF", e);
            doDelete();
        }
    }

    private class TransactReceiveBehaviour extends Behaviour {

        private AID senderAgent; //sender

        private String currency; //base currency
        private double valCurr; //value in base currency
        private int valSats; //value in satoshis
        private String prodID; //product id of the transaction

        //State of the protocol. Internal to this agent, does not correspond to the state of the counterparty.
        private State state = State.INITIAL;

        private UUID convId;

        //template for replies, updated on every state
        private MessageTemplate replyTemplate;

        //template with convId and protocol
        private MessageTemplate convBaseTemplate;

        public TransactReceiveBehaviour(Agent a) {
            super(a);

            //first template: performative and protocol
            this.replyTemplate = MessageTemplate.and(
                    MessageTemplate.MatchPerformative(ACLMessage.PROPOSE),
                    MessageTemplate.MatchProtocol(LNPaymentProtocol.getProtocolName()));

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

                                state = State.PROPOSAL_REJECTED;
                            }

                            Action contentAction = (Action)myAgent.getContentManager().extractContent(msgIn);
                            AcceptPaymentProposalAndCreateLNInvoice acceptPaymentProposalAndCreateLNInvoice = (AcceptPaymentProposalAndCreateLNInvoice) contentAction.getAction();

                            if(!(acceptPaymentProposalAndCreateLNInvoice instanceof AcceptPaymentProposalAndCreateLNInvoice)) {
                                myLogger.log(Logger.WARNING, "Receiver Agent: Initiation message doesn't have valid content!");
                                acceptProposal = false;
                                //TODO: PALAUTA SYY MIKSI REJECT
                            }

                            PaymentProposal paymentProposal = acceptPaymentProposalAndCreateLNInvoice.getPaymentProposal();

                            //TODO: Validate:
                            //-currency
                            //-product
                            //-currency value

                            //validate that the satoshis price matches to the proposed value in traditional currency
                            int fetchedSatsValue = priceApi.getSatsValue(paymentProposal.getCurrencyvalue(),paymentProposal.getCurrency());
                            int proposedSatsValue = paymentProposal.getSatsvalue();
                            double satsValueDeviation = Math.abs(((double)fetchedSatsValue)-((double)proposedSatsValue))/((double)fetchedSatsValue);

                            if(satsValueDeviation > priceTolerance) {
                                System.out.println("REJECT, TOO BIG VALUE DEVIATION:"); //POISTA TÄMÄ
                                System.out.println("Deviation: "+satsValueDeviation); //POISTA TÄMÄ
                                acceptProposal = false;
                                //TODO: PALAUTA SYY MIKSI REJECT (too bit value deviation)
                            }




                            convId = UUID.fromString(msgIn.getConversationId());
                            senderAgent = msgIn.getSender();
                            convBaseTemplate = MessageTemplate.and(
                                    MessageTemplate.MatchProtocol(LNPaymentProtocol.getProtocolName()),
                                    MessageTemplate.MatchConversationId(convId.toString()));

                            if (acceptProposal) {



                                ACLMessage accept = initMessage(ACLMessage.ACCEPT_PROPOSAL, msgIn);

                                //Construct agent action and add as content
                                LNInvoice invoice = new LNInvoice();
                                invoice.setInvoicestr("test_invoice_string"); //TODO: ADD CORRECT CREATED INVOICE
                                PaymentProposalAccepted paymentProposalAccepted = new PaymentProposalAccepted();
                                paymentProposalAccepted.setAccepted(true);
                                paymentProposalAccepted.setLnInvoice(invoice);
                                paymentProposalAccepted.setPaymentProposal(paymentProposal);

                                myAgent.getContentManager().fillContent(accept, paymentProposalAccepted);

                                myAgent.send(accept);

                                replyTemplate =  MessageTemplate.and(convBaseTemplate,
                                        MessageTemplate.and(
                                                MessageTemplate.MatchPerformative(ACLMessage.QUERY_IF),
                                                MessageTemplate.MatchInReplyTo(accept.getReplyWith())));

                                state = State.PROPOSAL_ACCEPTED;
                            } else {
                                //Reject the proposal
                                //TODO: respond with a formal rejection: why was rejected

                                ACLMessage reject = initMessage(ACLMessage.REJECT_PROPOSAL, msgIn);
                                PaymentProposalAccepted paymentProposalRejected = new PaymentProposalAccepted();
                                paymentProposalRejected.setAccepted(false);
                                paymentProposalRejected.setPaymentProposal(paymentProposal);
                                //add empty invoice
                                LNInvoice invoice = new LNInvoice();
                                invoice.setInvoicestr("");
                                paymentProposalRejected.setLnInvoice(invoice);

                                myAgent.getContentManager().fillContent(reject, paymentProposalRejected);
                                myAgent.send(reject);
                                state = State.PROPOSAL_REJECTED;
                            }


                        }
                        catch (Exception e){
                            //TODO: ERI VIRHEITÄ ERI EXCEPTIONEIDEN MUKAAN
                            myLogger.log(Logger.WARNING, "Receiver Agent: Error in state 0;");
                            e.printStackTrace();
                        }


                    } else {
                        block();
                    }

                    break;
                case PROPOSAL_REJECTED:
                    //REJECTED GO BACK TO INITIAL ??
                    state = State.INITIAL;

                    break;
                case PROPOSAL_ACCEPTED:
                    //proposal accepted. should receive query-if: is payment received
                    if (msgIn != null) {
                        try {

                            //TODO: CHECK THAT PAYMENT IS RECEIVED

                            boolean paymentReceived = true;
                            if (paymentReceived) {
                                Predicate responseTrue = new AbsPredicate(SL0Vocabulary.TRUE_PROPOSITION);
                                ACLMessage informTrue = initMessage(ACLMessage.INFORM, msgIn);
                                myAgent.getContentManager().fillContent(informTrue, responseTrue);

                                myAgent.send(informTrue);
                                state = State.SUCCESS;

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

            //end
            if (state == State.FAILURE) {
                myLogger.log(Logger.WARNING, "Transaction failed.");
                return true;
            }
            if (state == State.SUCCESS) {
                myLogger.log(Logger.INFO, "Transaction receiver: Transaction completed successfully.");
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
                msg.addReceiver(senderAgent);
                msg.setProtocol(LNPaymentProtocol.getProtocolName());
                msg.setOntology(LNTxOntology.ONTOLOGY_NAME);
                msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
                msg.setConversationId(convId.toString());
                msg.setReplyWith("msg_"+System.currentTimeMillis()); // Unique value
            }

            return msg;
        }

    }
}