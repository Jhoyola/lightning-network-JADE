package LNTxOntology;

//Class implementation following JavaBeans, to create a bean ontology

public class PaymentProposal extends TxValue {

    private String prodid;

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public String getAsStringForLogging() {
        return "Product id: "+getProdid()+
                ", value: "+ getCurrencyvalue() +" "+getCurrency()+
                ", satoshis: "+getSatsvalue();
    }

}
