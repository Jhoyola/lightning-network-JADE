package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

public class TransactionSenderTesterAgent extends TransactionSenderAgent{

    protected void setup() {
        super.setup();

        enableDebugLogging();

        //simnet
        setLNHost("192.168.1.83", 10001, "src/main/resources/tls_simnet.cert", "src/main/resources/simnet_a_admin.macaroon");

        //mainnet
        //setLNHost("192.168.1.83", 10004, "src/main/resources/tls.cert", "src/main/resources/mainnet_b_admin.macaroon");

        addBehaviour(new LoopTransactSendBehaviour(this));
    }

    //Find receivers and start protocol as sender
    private class LoopTransactSendBehaviour extends OneShotBehaviour {

        Agent a;

        //TESTING VALUES FOR THE PROTOCOL
        String currency = "eur"; //base currency
        double valCurr = 0.05; //value in base currency
        String prodID = "prod_1"; //product id for the receiver

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

            //Wait to be sure that the other agent is created
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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
