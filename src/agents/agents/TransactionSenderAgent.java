package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.util.Logger;

import java.util.UUID;
import util.LNPaymentProtocol;

//The transaction sender agent initiates the conversation
public class TransactionSenderAgent extends Agent {

    private Logger myLogger = Logger.getMyLogger(getClass().getName());

    protected void setup() {

        //FOR TESTING, INITIATE THE PROTOCOL HERE
        //-----------------------------------------------
        addBehaviour(new StartTransactSendBehaviour(this));
        //-----------------------------------------------
    }


    private class TransactSendBehaviour extends Behaviour {

        private AID receiverAgent; //receiver

        private String currency; //base currency
        private double valCurr; //value in base currency
        private int valSats; //value in satoshis
        private String prodID; //product id for the receiver

        //State of the protocol. Internal to this agent, does not correspond to the state of the counterparty.
        //0 = Not initiated
        //1 = Waiting for response to proposal
        //2 = Proposal rejected
        //3 = Proposal accepted
        //4 = Successfully finished
        //5 = Failure
        private int state;

        private UUID convId;

        //template for replies, updated on every state
        private MessageTemplate replyTemplate;

        private MessageTemplate convBaseTemplate;


        public TransactSendBehaviour(Agent a, AID receiverAgent, String currency, double valCurr, int valSats, String prodID) {
            super(a);
            this.receiverAgent = receiverAgent;
            this.currency = currency;
            this.valCurr = valCurr;
            this.valSats = valSats;
            this.prodID = prodID;

            this.state = 0;
            this.convId = UUID.randomUUID(); //set the conversation id
            this.convBaseTemplate = MessageTemplate.and(
                    MessageTemplate.MatchProtocol(LNPaymentProtocol.getProtocolName()),
                    MessageTemplate.MatchConversationId(convId.toString()));
        }

        public void action() {

            ACLMessage msgIn = myAgent.receive(replyTemplate);

            switch (state) {
                case 0:
                    ACLMessage propose = new ACLMessage(ACLMessage.PROPOSE);
                    propose.addReceiver(this.receiverAgent);

                    propose.setContent(this.prodID); //MUUTA OIKEA DATA

                    propose.setConversationId(convId.toString());
                    propose.setProtocol(LNPaymentProtocol.getProtocolName());
                    propose.setReplyWith("propose"+System.currentTimeMillis()); // Unique value
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
                        String content = msgIn.getContent();
                        myLogger.log(Logger.INFO, "Agent "+getLocalName()+" - Received ACCEPT / REJECT");
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
                    break;
                case 5:
                    //myLogger.log(Logger.INFO, "Sender state 4");
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

    }

    //Find receivers and start protocol as sender
    private class StartTransactSendBehaviour extends OneShotBehaviour {

        Agent a;

        //TESTING VALUES FOR THE PROTOCOL
        String currency = "EUR"; //base currency
        double valCurr = 5.0; //value in base currency
        int valSats = 10000; //value in satoshis
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
                    addBehaviour(new TransactSendBehaviour(a, receiver, currency, valCurr, valSats, prodID));
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