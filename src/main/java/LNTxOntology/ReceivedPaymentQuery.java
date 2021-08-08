package LNTxOntology;

import jade.content.AgentAction;

public class ReceivedPaymentQuery implements AgentAction {

    private String paymentHash;

    public String getPaymentHash() {
        return paymentHash;
    }

    public void setPaymentHash(String paymentHash) {
        this.paymentHash = paymentHash;
    }
}