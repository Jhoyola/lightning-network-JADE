package LNTxOntology;

import jade.content.AgentAction;

public class ReceivedPaymentQuery implements AgentAction {

    private LNInvoice lnInvoice;

    public void setLnInvoice(LNInvoice lnInvoice) {
        this.lnInvoice = lnInvoice;
    }

    public LNInvoice getLnInvoice() {
        return lnInvoice;
    }
}