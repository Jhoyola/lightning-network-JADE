package agents;

import LNTxOntology.*;
import jade.content.AgentAction;
import jade.content.ContentElement;
import jade.content.Predicate;
import jade.content.lang.sl.SLCodec;
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
import jade.util.Logger;

import java.util.UUID;
import util.LNPaymentProtocol;

public class TransactionReceiverAgent extends Agent{

    private Logger myLogger = Logger.getMyLogger(getClass().getName());

    protected void setup() {

        // Register the codec for the SL0 language
        getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
        // Register the ontology used by this application
        getContentManager().registerOntology(LNTxOntology.getInstance());

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
        //0 = Not initiated
        //1 = Proposal rejected
        //2 = Proposal accepted
        //3 = Invoice should be paid
        //4 = Successfully finished
        //5 = Failure
        private int state;

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

            this.state = 0;
        }

        public void action() {
            ACLMessage msgIn = myAgent.receive(replyTemplate);

            switch (state) {
                case 0:
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

                                //state stays as 0
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
                            //-sats value (hae API:sta)
                            //-currency value


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

                                state = 1;
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
                                //state stays 0
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
                case 1:
                    //myLogger.log(Logger.INFO, "Receiver state 1");
                    break;
                case 2:
                    //myLogger.log(Logger.INFO, "Receiver state 2");
                    break;
                case 3:
                    //myLogger.log(Logger.INFO, "Receiver state 3");
                    break;
                case 4:
                    //myLogger.log(Logger.INFO, "Receiver state 4");
                    break;


            }
        }

        public boolean done() {

            //end
            if (state == 5) {
                myLogger.log(Logger.WARNING, "Transaction failed.");
                return true;
            }
            if (state == 4) {
                myLogger.log(Logger.WARNING, "Transaction completed successfully.");
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