package LNPaymentOntology;

//Class implementation following JavaBeans, to create a bean ontology

public class PaymentProposal extends PaymentValue {

    private String payId;

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getAsStringForLogging() {
        return "Payment id: "+getPayId()+
                ", value: "+ getCurrencyValue() +" "+getCurrency()+
                ", satoshis: "+getSatsValue();
    }

}
