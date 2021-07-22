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
import jade.util.Logger;

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

        Agent a; //this agent
        AID receiverAgent; //receiver

        String currency; //base currency
        double valCurr; //value in base currency
        int valSats; //value in satoshis
        String prodID; //product id for the receiver

        public TransactSendBehaviour(Agent a, AID receiverAgent, String currency, double valCurr, int valSats, String prodID) {
            super(a);
            this.a = a;
            this.receiverAgent = receiverAgent;
            this.currency = currency;
            this.valCurr = valCurr;
            this.valSats = valSats;
            this.prodID = prodID;
        }

        public void action() {

            /*ACLMessage msg = myAgent.receive();

            if(msg != null){
                String content = msg.getContent();
                myLogger.log(Logger.INFO, "Agent "+getLocalName()+" - Received message: "+content);
            }else{
                block();
            }*/

            //TEST SEND
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(this.receiverAgent);
            msg.setContent(this.prodID);
            //msg.setConversationId("book-trade");
            //msg.setReplyWith("cfp"+System.currentTimeMillis()); // Unique value
            myAgent.send(msg);
        }

        public boolean done() {

            //end
            return true;

            //continue
            //return false;
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
                Thread.sleep(2000);
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