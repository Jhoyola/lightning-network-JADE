package util;

import LNTxOntology.PaymentProposal;
import jade.core.AID;

import java.util.Date;
import java.util.UUID;

public class CompletePayment {

    public enum Role {
        SENDER,
        RECEIVER
    };

    private Role role;
    private boolean success;
    private PaymentProposal proposal;
    private String paymentHash;
    private long timeStamp;
    private UUID convId;
    private AID counterParty;
    private TransactionTimer timer;
    private long feesPaid;
    private String failureReason;

    public CompletePayment (Role role, boolean success, PaymentProposal proposal, String paymentHash, UUID convId, AID counterParty, long feesPaid, TransactionTimer timer) {
        this.role = role;
        this.success = success;
        this.proposal = proposal;
        this.paymentHash = paymentHash;
        this.convId = convId;
        this.counterParty = counterParty;
        this.feesPaid = feesPaid;
        this.timer = timer;
        this.timeStamp = System.currentTimeMillis();
        this.failureReason = "";
    }

    public Role getRole() {
        return role;
    }

    public boolean isSuccess() {
        return success;
    }

    public PaymentProposal getPaymentProposal() {
        return proposal;
    }

    public String getPaymentHash() {
        return paymentHash;
    }

    public Date getDateTime() {
        return new Date(timeStamp);
    }

    public UUID getConvId() {
        return convId;
    }

    public long getFeesPaid() {
        return feesPaid;
    }

    public TransactionTimer getTimer() {
        return timer;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}
