package LNPaymentOntology;

import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

public class PaymentProposalAccepted implements Predicate {
    private boolean accepted;
    private PaymentProposal paymentProposal;
    private LNInvoice lnInvoice;
    private String reasonForRejection;

    public void setPaymentProposal(PaymentProposal paymentProposal) {
        this.paymentProposal = paymentProposal;
    }

    public PaymentProposal getPaymentProposal() {
        return paymentProposal;
    }

    public void setLnInvoice(LNInvoice lnInvoice) {
        this.lnInvoice = lnInvoice;
    }

    //The invoice is not mandatory as the proposal might be rejected
    @Slot(mandatory = false)
    public LNInvoice getLnInvoice() {
        return lnInvoice;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }

    @Slot(mandatory = false)
    public String getReasonForRejection() {
        if(reasonForRejection.isEmpty()) {
            return "";
        }
        return reasonForRejection;
    }
}
