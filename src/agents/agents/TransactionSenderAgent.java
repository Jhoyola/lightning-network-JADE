package agents;

import LNTxOntology.*;
import jade.content.ContentElement;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.basic.Action;
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


//The transaction sender agent initiates the conversation
public class TransactionSenderAgent extends Agent {

    private Logger myLogger = Logger.getMyLogger(getClass().getName());

    protected void setup() {

        // Register the codec for the SL0 language
        getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
        // Register the ontology used by this application
        getContentManager().registerOntology(LNTxOntology.getInstance());

        //FOR TESTING, INITIATE THE PROTOCOL HERE
        //-----------------------------------------------
        addBehaviour(new StartTransactSendBehaviour(this));
        //-----------------------------------------------
    }


    private class TransactSendBehaviour extends Behaviour {

        private AID receiverAgent; //receiver

        private PaymentProposal paymentProposal;

        //State of the protocol. Internal to this agent, does not correspond to the state of the counterparty.
        //0 = Not initiated
        //1 = Waiting for response to proposal
        //2 = Invoice paid
        //3 = Successfully finished
        //4 = Failure
        private int state;

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

            this.state = 0;
            this.convId = UUID.randomUUID(); //set the conversation id
            this.convBaseTemplate = MessageTemplate.and(
                    MessageTemplate.MatchProtocol(LNPaymentProtocol.getProtocolName()),
                    MessageTemplate.MatchConversationId(convId.toString()));

            this.ontology = getContentManager().lookupOntology(LNTxOntology.ONTOLOGY_NAME);
        }

        public void action() {

            ACLMessage msgIn = myAgent.receive(replyTemplate);

            switch (state) {
                case 0:

                    //TODO: RAJOITA KUINKA MONTA YRITYSTÄ JOS REJECT

                    //TODO: GET THE CORRECT SATS VALUE
                    paymentProposal.setSatsvalue(1000); //MOCK VALUE!

                    //SEND THE INITIATION
                    ACLMessage propose = initMessage(ACLMessage.PROPOSE, null);

                    //Construct agent action and add as content
                    AcceptPaymentProposalAndCreateLNInvoice acceptPaymentProposal = new AcceptPaymentProposalAndCreateLNInvoice();
                    acceptPaymentProposal.setPaymentProposal(paymentProposal);
                    Action a = new Action();
                    a.setAction(acceptPaymentProposal);
                    a.setActor(receiverAgent);

                    try {
                        myAgent.getContentManager().fillContent(propose, a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    myAgent.send(propose);

                    //template: convId and (accept_proposal or reject_proposal) and replywith
                    replyTemplate =  MessageTemplate.and(convBaseTemplate,
                            MessageTemplate.and(
                                MessageTemplate.or(MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL), MessageTemplate.MatchPerformative(ACLMessage.REJECT_PROPOSAL)),
                                MessageTemplate.MatchInReplyTo(propose.getReplyWith())));

                    state = 1;
                    break;
                case 1:
                    if(msgIn != null){


                        try {
                            PaymentProposalAccepted proposalReply = (PaymentProposalAccepted) myAgent.getContentManager().extractContent(msgIn);

                            boolean proposalAccepted = proposalReply.isAccepted();




                            //TODO: validate the incoming message



                            if (proposalAccepted) {

                                //by default not paid
                                boolean invoiceValidAndPaid = false;

                                //TODO: VALIDATE AND PAY THE INVOICE

                                invoiceValidAndPaid = true; //TODO: MOCK ARVO, SIIRRÄ MUUALLE

                                if (invoiceValidAndPaid) {
                                    //OK

                                    myLogger.log(Logger.INFO, "### INVOICE PAID NOW SEND QUERY-IF ###");

                                    state = 2;
                                    //TODO: set new replytemplate
                                } else {
                                    state = 4; //FAILED
                                }

                            } else {
                                //proposal rejected, naively retry
                                state = 0;
                            }
                        }catch (Exception e) {
                            myLogger.log(Logger.WARNING, "Sender Agent: Error in receiving response to proposal.");
                            e.printStackTrace();
                            state = 4; //FAILED
                        }

                    }else{
                        block();
                    }
                    break;
                case 2:
                    //myLogger.log(Logger.INFO, "Sender state 2");
                    break;
                case 3:
                    //myLogger.log(Logger.INFO, "Sender state 3");
                    break;
                case 4:
                    //myLogger.log(Logger.INFO, "Sender state 4");
                    //TODO:SEND FAILURE
                    break;

            }

        }

        public boolean done() {

            //end
            if (state == 4) {
                myLogger.log(Logger.WARNING, "Transaction failed.");
                return true;
            }
            if (state == 3) {
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
                msg.addReceiver(receiverAgent);
                msg.setProtocol(LNPaymentProtocol.getProtocolName());
                msg.setOntology(LNTxOntology.ONTOLOGY_NAME);
                msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
                msg.setConversationId(convId.toString());
                msg.setReplyWith("msg_"+System.currentTimeMillis()); // Unique value
            }

            return msg;
        }

    }

    //Find receivers and start protocol as sender
    private class StartTransactSendBehaviour extends OneShotBehaviour {

        Agent a;

        //TESTING VALUES FOR THE PROTOCOL
        String currency = "EUR"; //base currency
        double valCurr = 2.0; //value in base currency
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