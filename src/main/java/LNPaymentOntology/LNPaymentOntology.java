package LNPaymentOntology;

import jade.content.onto.*;

public class LNPaymentOntology extends BeanOntology {

    // The name identifying this ontology
    public static final String ONTOLOGY_NAME = "LightningNetwork-ontology";

    // The singleton instance of this ontology
    private static Ontology theInstance = new LNPaymentOntology();

    // This is the method to access the singleton ontology object
    public static Ontology getInstance() {
        return theInstance;
    }

    // Private constructor
    private LNPaymentOntology() {
        // The LNPaymentOntology extends the basic ontology
        super(ONTOLOGY_NAME);

        try {
            add(PaymentValue.class);
            add(PaymentProposal.class);
            add(AcceptPaymentProposalAndCreateLNInvoice.class);
            add(LNInvoice.class);
            add(PaymentProposalAccepted.class);
            add(ReceivedPayment.class);

        } catch (Exception oe) {
            oe.printStackTrace();
        }
    }
}
