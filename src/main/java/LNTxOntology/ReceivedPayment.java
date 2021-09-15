package LNTxOntology;

import jade.content.Predicate;

public class ReceivedPayment implements Predicate{

    private String paymentHash;

    public String getPaymentHash() {
        return paymentHash;
    }

    public void setPaymentHash(String paymentHash) {
        this.paymentHash = paymentHash;
    }
}
