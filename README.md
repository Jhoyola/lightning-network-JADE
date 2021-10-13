# JADE MAS micropayments using Bitcoin Lightning Network

- Developed for the Master's Thesis of Juho Yrjölä (juho.yrjola@iki.fi) in Tampere University, Program of Automation Engineering.  
- Developed with connection to LND version 0.13.1-beta.  
- Tested with Java SE 13.0.2.  
- Files in the protocol images directory give an explanation of the protocol sequence.  
- Built using maven.  

#### Main functionalities

- Payments between JADE agents using Bitcoin Lightning Network.  
- Denomination of payment amount in fiat currency.  
- Trustless verification of payment validity.  
- Developed to be easily adoptable to multiple use cases.  

#### PaymentReceiverTesterAgent and PaymentSenderTesterAgent act as examples how to use the system

- Inherit the PaymentReceiverAgent or PaymentSenderAgent. There should be no need to edit PaymentReceiverAgent or PaymentSenderAgent.  
- LND node rpc connection paramenters should be defined using the setLNHost function.  
- Price api should be defined using the setPriceApi function. New price apis can be defined: they should implement the PriceAPI interface.  
- isProposalAccepted function can be overwritten for the payment receiver to make custom rules for accepting the payment.  
- paymentComplete function can be overwritten to define what happens after the payment either succeeds or fails.  
- Receiver agent should run the PaymentReceiveBehaviour to receive payments. "perpetual" parameter defines if the it contiues to receive payments after the first one.  
- Sender agent should run the PaymentSendBehaviour to send a payment. Include the "payment id" parameter to associate the payment to a product or event.  

#### Running

- Setup and configure separate LND nodes for sending and receiving payments. Make sure that they have payment channels with sufficient capacity. Unlock the nodes.  
- Set correct parameters to setLNHost function in PaymentSenderTesterAgent and PaymentReceiverTesterAgent: IP and port of the LND node, cert created by LND, admin macaroon file created by LND.  
- Run Maven build.  
- Run jade.Boot as the main class with program arguments: -gui -agents PaymentSenderAgent:agents.PaymentSenderTesterAgent;PaymentReceiverAgent:agents.PaymentReceiverTesterAgent  
