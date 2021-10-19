package LNPaymentOntology;

import jade.content.Concept;


//Class implementation following JavaBeans, to create a bean ontology

public class PaymentValue implements Concept {

    private String currency;
    private double currencyValue;
    private int satsValue;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    public int getSatsValue() {
        return satsValue;
    }

    public void setSatsValue(int satsValue) {
        this.satsValue = satsValue;
    }

}
