package LNPaymentOntology;

import jade.content.AgentAction;

public class AcceptPaymentProposalAndCreateLNInvoice implements AgentAction {

    private PaymentProposal paymentProposal;

    public void setPaymentProposal(PaymentProposal paymentProposal) {
        this.paymentProposal = paymentProposal;
    }

    public PaymentProposal getPaymentProposal() {
        return paymentProposal;
    }
}
