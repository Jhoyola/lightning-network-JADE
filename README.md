# JADE MAS micropayments using Bitcoin Lightning Network

- Developed for the Master's Thesis of Juho Yrjölä (juho.yrjola@iki.fi) in Tampere University, Program of Automation Engineering.  
- Link to download the thesis: https://urn.fi/URN:NBN:fi:tuni-202202222105  
- Developed with connection to LND version 0.13.1-beta.  
- Tested with Java SE 13.0.2.  
- Files in the protocol images directory give an explanation of the protocol sequence.  
- Built using maven. 
- No guarantees of any kind. The system is not very thoroughly tested!

#### Main functionalities

- Payments between JADE agents using Bitcoin Lightning Network.  
- Denomination of payment amount in fiat currency.  
- Trustless verification of payment validity.  
- Developed to be easily adoptable to multiple use cases.  

#### Implementation for new use cases

- PaymentReceiverTesterAgent and PaymentSenderTesterAgent act as examples how to use the system.  
- Extend the PaymentReceiverAgent or PaymentSenderAgent. There should be no need to edit PaymentReceiverAgent or PaymentSenderAgent.  
- super.setup() function should be called in the beginning of the setup function of the extended agent.  
- LND node rpc connection paramenters should be defined using the setLNHost function.  
- Price api should be defined using the setPriceApi function. New price apis can be defined: they should implement the PriceAPI interface.  
- isProposalAccepted function can be overwritten for the payment receiver to make custom rules for accepting the payment.  
- paymentComplete function can be overwritten to define what happens after the payment either succeeds or fails.  
- Receiver agent should run the PaymentReceiveBehaviour to receive payments. "perpetual" parameter defines if it continues to receive payments after the first one.  
- Sender agent should run the PaymentSendBehaviour to send a payment. Include the "payment id" parameter to associate the payment to a product or event.  

#### Running PaymentReceiverTesterAgent and PaymentSenderTesterAgent 

- Setup and configure separate LND nodes for sending and receiving payments. Make sure that they have payment channels with sufficient capacity. Unlock the nodes.  
- Set correct parameters to setLNHost() function in PaymentSenderTesterAgent and PaymentReceiverTesterAgent: IP and port of the LND node, cert created by LND, admin macaroon file created by LND.  
- If either of the provided PriceAPIs is not reachable anymore, change it to a working PriceAPI object for setPriceApi() function in PaymentSenderTesterAgent and PaymentReceiverTesterAgent
- To test without a connection to LND: set empty parameters to setLNHost(): setLNHost("", 0, "", "");
- Run Maven build.  
- Run jade.Boot as the main class with program arguments: -gui -agents PaymentSenderAgent:agents.PaymentSenderTesterAgent;PaymentReceiverAgent:agents.PaymentReceiverTesterAgent  

#### Running the book trading example

- As an other example, book trading agents are extended to make payments using the protocol. The original book trading agents are JADE example agents and can be found from the official JADE examples.
- Set the paramenters for setLNHost() and setPriceApi() in BookBuyerAgent and BookSellerAgent
- Run as earlier but with program arguments: -gui -agents BookBuyer:agents.BookBuyerAgent(testbook1);BookSeller:agents.BookSellerAgent
- BookBuyer now tries to buy the book titled "testbook1" every 60 seconds
- In the BookSellerGui window add a book with the title of testbook1. Set a price as an integer. The price is Euro cents, such that if 100 is given as the price, it is 1€.
- New BookBuyer agents can be created in the agent management gui to buy more books. The books must be added in the BookSeller gui to be available for buying.
