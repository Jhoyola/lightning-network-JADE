package agents;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.util.Logger;

public class TransactAgent extends Agent{

    private Logger myLogger = Logger.getMyLogger(getClass().getName());

    private class IdleBehaviour extends CyclicBehaviour {

        public IdleBehaviour(Agent a) {
            super(a);
        }

        public void action() {
            ACLMessage  msg = myAgent.receive();

            if(msg != null){
                String content = msg.getContent();
                myLogger.log(Logger.INFO, "Agent "+getLocalName()+" - Received message: "+content);
            }else{
                block();
            }

        }
    }


    protected void setup() {
        // Registration with the DF
        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("TransactAgent");
        sd.setName(getName());
        sd.setOwnership("MY_OWNER");
        dfd.setName(getAID());
        dfd.addServices(sd);
        try {
            DFService.register(this,dfd);
            IdleBehaviour IdleBehaviour = new IdleBehaviour(this);
            addBehaviour(IdleBehaviour);
        } catch (FIPAException e) {
            myLogger.log(Logger.SEVERE, "Agent "+getLocalName()+" - Cannot register with DF", e);
            doDelete();
        }
    }
}