package LNTxOntology;

import jade.content.AgentAction;
import jade.content.Predicate;

public class AcceptPaymentProposalAndCreateLNInvoice implements AgentAction {

    private PaymentProposal paymentProposal;

    public void setPaymentProposal(PaymentProposal paymentProposal) {
        this.paymentProposal = paymentProposal;
    }

    public PaymentProposal getPaymentProposal() {
        return paymentProposal;
    }
}
