package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.util.Logger;

public class TransactionSenderTesterAgent extends TransactionSenderAgent{

    protected void setup() {
        super.setup();

        enableDebugLogging();

        addBehaviour(new LoopTransactSendBehaviour(this));
    }

    //Find receivers and start protocol as sender
    private class LoopTransactSendBehaviour extends OneShotBehaviour {

        Agent a;

        //TESTING VALUES FOR THE PROTOCOL
        String currency = "eur"; //base currency
        double valCurr = 0.7; //value in base currency
        String prodID = "prod_2"; //product id for the receiver

        public LoopTransactSendBehaviour(Agent a) {
            this.a = a;
        }

        public void action() {

            //just one payment
            findReceiverAndSend();

            /*
            //ticker behaviour to make multiple payments
            addBehaviour(new TickerBehaviour(a, 10000) {
                protected void onTick() {
                    findReceiverAndSend();
                }
            } );
            */

        }

        void findReceiverAndSend() {
            //Find receivers
            DFAgentDescription template = new DFAgentDescription();
            ServiceDescription sd = new ServiceDescription();
            sd.setType("receive-ln-tx");
            template.addServices(sd);

            try {
                DFAgentDescription[] result = DFService.search(myAgent, template);

                if(result.length > 0) {
                    AID receiver = result[0].getName();
                    addBehaviour(new TransactSendBehaviour(a, receiver, currency, valCurr, prodID));
                } else {
                    System.out.println("Didn't find a receiver");
                }
            }
            catch (FIPAException fe) {
                fe.printStackTrace();
            }
        }
    }

}
