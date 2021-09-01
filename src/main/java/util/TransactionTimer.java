package util;

public class TransactionTimer {

    private long startTime;
    private long endTime;

    private long paymentStartTime;
    private long paymentEndTime;

    public TransactionTimer() {
        //initialize to zeros
        startTime = 0;
        endTime = 0;
        paymentStartTime = 0;
        paymentEndTime = 0;
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public void setPaymentStartTime() {
        this.paymentStartTime = System.currentTimeMillis();
    }

    public void setPaymentEndTime() {
        this.paymentEndTime = System.currentTimeMillis();
    }

    public long getTotalTime() {
        if (startTime == 0 || endTime == 0 || startTime > endTime) {
            //error
            return -1;
        }
        return endTime - startTime;
    }

    public long getPaymentTime() {
        if (paymentStartTime == 0 || paymentEndTime == 0 || paymentStartTime > paymentEndTime) {
            //error
            return -1;
        }
        return paymentEndTime - paymentStartTime;
    }
}
