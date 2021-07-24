package LNTxOntology;

import jade.content.Concept;


//Class implementation following JavaBeans, to create a bean ontology

public class TxValue implements Concept {

    private String currency;
    private double currencyvalue;
    private int satsvalue;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCurrencyvalue() {
        return currencyvalue;
    }

    public void setCurrencyvalue(double currencyvalue) {
        this.currencyvalue = currencyvalue;
    }

    public double getSatsvalue() {
        return satsvalue;
    }

    public void setSatsvalue(int satsvalue) {
        this.satsvalue = satsvalue;
    }

}
