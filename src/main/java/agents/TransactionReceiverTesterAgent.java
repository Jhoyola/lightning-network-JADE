package agents;

import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import util.ProductPrice;
import java.util.ArrayList;

public class TransactionReceiverTesterAgent extends TransactionReceiverAgent {

    protected void setup() {
        super.setup();

        enableDebugLogging();

        //simnet
        setLNHost("192.168.1.83", 10002, "src/main/resources/tls_simnet.cert", "src/main/resources/simnet_b_admin.macaroon");

        //mainnet
        //setLNHost("192.168.1.83", 10003, "src/main/resources/tls.cert", "src/main/resources/mainnet_a_admin.macaroon");

        //ADD SOME PRODUCTS FOR TESTING
        ArrayList<ProductPrice> prices = new ArrayList<ProductPrice>();
        prices.add(new ProductPrice(0.05, "eur"));
        prices.add(new ProductPrice(0.06, "usd"));
        addProductToCatalog("prod_1", prices);

        prices = new ArrayList<ProductPrice>();
        prices.add(new ProductPrice(0.15, "eur"));
        prices.add(new ProductPrice(0.7, "eur"));
        prices.add(new ProductPrice(10000, "eur"));
        addProductToCatalog("prod_2", prices);


        // Registration with the DF for the initiation
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("receive-ln-tx");
        sd.setName("TransactionReceiverAgentService");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
            addBehaviour(new TransactReceiveBehaviour(this, true));
        } catch (FIPAException e) {
            System.out.println("Agent "+getLocalName()+" - Cannot register with DF");
            doDelete();
        }

    }

}
