package agents;

import LNTxOntology.PaymentProposal;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import util.CompletePayment;
import util.ListedProduct;
import util.ProductCatalog;

public class PaymentReceiverTesterAgent extends PaymentReceiverAgent {

    private ProductCatalog productCatalog;

    protected void setup() {
        super.setup();

        enableDebugLogging();

        //simnet
        setLNHost("192.168.178.83", 10002, "src/main/resources/tls_simnet.cert", "src/main/resources/simnet_b_admin.macaroon");

        //mainnet
        //setLNHost("192.168.178.83", 10003, "src/main/resources/tls.cert", "src/main/resources/mainnet_a_admin.macaroon");


        //ADD SOME PRODUCTS FOR TESTING
        //Use the "payment id" as product id
        productCatalog = new ProductCatalog();

        ListedProduct p = new ListedProduct("prod_1");
        p.addPrice(0.05, "eur");
        p.addPrice(0.06, "usd");
        productCatalog.addProduct(p);

        p = new ListedProduct("prod_2");
        p.addPrice(0.15, "eur");
        p.addPrice(0.7, "eur");
        p.addPrice(10000, "eur");
        productCatalog.addProduct(p);


        // Registration with the DF for the initiation
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("receive-ln-tx");
        sd.setName("PaymentReceiverAgentService");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
            addBehaviour(new PaymentReceiveBehaviour(this, true));
        } catch (FIPAException e) {
            System.out.println("Agent "+getLocalName()+" - Cannot register with DF");
            doDelete();
        }

    }

    protected void paymentComplete(CompletePayment payment) {
        if(payment.isSuccess()) {
            System.out.println("Receiver Agent: SUCCESS");
            System.out.println("Received: "+payment.getPaymentProposal().getAsStringForLogging());
        } else {
            System.out.println("Receiver Agent: PAYMENT FAILED: "+payment.getFailureReason());
        }
    }

    //set rules for accepting the proposal
    protected boolean isProposalAccepted(PaymentProposal proposal) {
        System.out.println("Checking if product found in catalog.");

        //validate that the product is in the catalog
        //payment id:s correspond to product id:s in this test case
        if (productCatalog.hasProductWithPrice(proposal.getPayId(),proposal.getCurrencyValue(),proposal.getCurrency())) {
            return true;
        } else {
            return false;
        }
    }


}
