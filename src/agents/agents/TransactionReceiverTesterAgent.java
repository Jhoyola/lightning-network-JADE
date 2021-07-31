package agents;

import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.util.Logger;
import util.ProductPrice;

import java.util.ArrayList;

public class TransactionReceiverTesterAgent extends TransactionReceiverAgent {

    protected void setup() {
        super.setup();

        enableDebugLogging();

        //ADD SOME PRODUCTS FOR TESTING
        ArrayList<ProductPrice> prices = new ArrayList<ProductPrice>();
        prices.add(new ProductPrice(0.2, "eur"));
        prices.add(new ProductPrice(0.22, "usd"));
        addProductToCatalog("prod_1", prices);

        prices = new ArrayList<ProductPrice>();
        prices.add(new ProductPrice(0.6, "eur"));
        prices.add(new ProductPrice(0.7, "eur"));
        prices.add(new ProductPrice(0.8, "eur"));
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
