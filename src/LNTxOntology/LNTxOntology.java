package LNTxOntology;

import jade.content.onto.*;

public class LNTxOntology extends BeanOntology {

    // The name identifying this ontology
    public static final String ONTOLOGY_NAME = "LightningNetwork-ontology";

    // The singleton instance of this ontology
    private static Ontology theInstance = new LNTxOntology();

    // This is the method to access the singleton ontology object
    public static Ontology getInstance() {
        return theInstance;
    }

    // Private constructor
    private LNTxOntology() {
        // The LNTxOntology extends the basic ontology
        super(ONTOLOGY_NAME);

        try {
            add(TxValue.class);
            add(PaymentProposal.class);
            add(AcceptPaymentProposalAndCreateLNInvoice.class);
            add(LNInvoice.class);
            add(PaymentProposalAccepted.class);
            add(ReceivedPaymentQuery.class);
            //....


        } catch (Exception oe) {
            oe.printStackTrace();
        }
    }
}
