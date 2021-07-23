package agents;

import jade.core.*;
import jade.core.behaviours.*;
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
        // Registration with the DF
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

                        //validate the initiation message
                        if (msgIn.getConversationId().isEmpty()) {
                            myLogger.log(Logger.WARNING, "Receiver Agent: Initiation message doesn't have a conversation id!");
                            block();
                        }
                        //-currency
                        //-product
                        //-sats value
                        //-currency value

                        convId = UUID.fromString(msgIn.getConversationId());

                        senderAgent = msgIn.getSender();


                        String content = msgIn.getContent();
                        myLogger.log(Logger.INFO, "Agent " + getLocalName() + " - Received message: " + content);

                        //IF ACCEPT
                        boolean acceptProposal = true;
                        if (acceptProposal) {
                            ACLMessage accept = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                            accept.addReceiver(senderAgent);
                            accept.setProtocol(LNPaymentProtocol.getProtocolName());
                            accept.setConversationId(convId.toString());
                            if (!msgIn.getReplyWith().isEmpty()) {
                                accept.setInReplyTo(msgIn.getReplyWith());
                            }
                            accept.setReplyWith("accept" + System.currentTimeMillis()); // Unique value

                            accept.setContent("TEST ACCEPT");

                            myLogger.log(Logger.INFO, "MESSAGE: "+accept.toString());

                            myAgent.send(accept);

                            convBaseTemplate = MessageTemplate.and(
                                    MessageTemplate.MatchProtocol(LNPaymentProtocol.getProtocolName()),
                                    MessageTemplate.MatchConversationId(convId.toString()));

                            state = 1;
                        } else {
                            //reject

                            //....
                            myLogger.log(Logger.INFO, "reject");

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

    }
}