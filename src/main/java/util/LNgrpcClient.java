package util;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.*;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

import io.grpc.netty.shaded.io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.grpc.netty.shaded.io.netty.handler.codec.bytes.ByteArrayEncoder;
import lnrpc.LightningGrpc;
import lnrpc.Rpc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Executor;

import org.apache.commons.codec.DecoderException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.apache.commons.codec.binary.Hex;

class MacaroonCallCredential extends CallCredentials {
    private final String macaroon;

    MacaroonCallCredential(String macaroon) {
        this.macaroon = macaroon;
    }

    public void thisUsesUnstableApi() {}

    @Override
    public void applyRequestMetadata(
            RequestInfo requestInfo,
            Executor executor,
            final MetadataApplier metadataApplier
    ) {
        executor.execute(() -> {
            try {
                Metadata headers = new Metadata();
                Metadata.Key < String > macaroonKey = Metadata.Key.of("macaroon", Metadata.ASCII_STRING_MARSHALLER);
                headers.put(macaroonKey, macaroon);
                metadataApplier.apply(headers);
            } catch (Throwable e) {
                metadataApplier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });
    }
}

public class LNgrpcClient {

    private final LightningGrpc.LightningBlockingStub stub;

    private boolean useMock;

    public LNgrpcClient(String host, int port, String certPath, String macaroonPath) throws LightningNetworkException {

        //leave host empty to use mock version
        if(host.isEmpty()) {
            useMock = true;
            stub = null;
            return;
        }

        useMock = false;
        LightningGrpc.LightningBlockingStub stub_;

        try {

            //create credentials from cert file
            ChannelCredentials credentials = TlsChannelCredentials
                    .newBuilder()
                    .trustManager(new File(certPath))
                    .build();

            //create channel to the ln node
            ManagedChannel channel = NettyChannelBuilder.forAddress(host, port, credentials).build();

            //encode macaroon to hex
            String macaroon =
                    String.valueOf(Hex.encodeHex(
                            Files.readAllBytes(Paths.get(macaroonPath))
                    ));

            stub_ = LightningGrpc
                    .newBlockingStub(channel)
                    .withCallCredentials(new MacaroonCallCredential(macaroon));

        } catch (Exception e) {
            //e.printStackTrace();
            throw new LightningNetworkException(e.getMessage());
        }
        stub = stub_;
    }

    private Rpc.ChannelBalanceResponse getChannelBalance() {
        return stub.channelBalance(Rpc.ChannelBalanceRequest.getDefaultInstance());
    }

    private String createJsonMemo(String convId, String payId, double amountCurr, String currency) {

        JSONObject jsonMemo = new JSONObject();
        jsonMemo.put("convId", convId);
        jsonMemo.put("payId", payId);
        jsonMemo.put("amountCurr", amountCurr);
        jsonMemo.put("currency", currency);

        return jsonMemo.toJSONString();
    }

    //retuns the balance in sats that can be sent
    public long getSendableBalance() {
        if(useMock) {
            return 9999999;
        }
        return getChannelBalance().getLocalBalance().getSat();
    }

    //retuns the balance in sats that can be received
    public long getReceivableBalance() {
        if(useMock) {
            return 9999999;
        }
        return getChannelBalance().getRemoteBalance().getSat();
    }

    public String[] createInvoice(long amount, String convId, String payId, double amountCurr, String currency) throws LightningNetworkException {
        if(useMock) {
            return new String[]{"mock_paymentrequest", "mock_rhash"};
        }

        try {
            Rpc.Invoice.Builder invoiceBuilder = Rpc.Invoice.newBuilder();
            invoiceBuilder.setValue(amount); //value in satoshis

            //create the memo of the invoice
            invoiceBuilder.setMemo(createJsonMemo(convId, payId, amountCurr, currency));

            Rpc.Invoice i = invoiceBuilder.build();
            Rpc.AddInvoiceResponse response = stub.addInvoice(i);

            if(!response.getInitializationErrorString().isEmpty()) {
                throw new LightningNetworkException(response.getInitializationErrorString());
            }

            String rHashHex = String.valueOf(Hex.encodeHex(response.getRHash().toByteArray()));

            //return 2 strings: payment request [0] and rHash [1]
            return new String[]{response.getPaymentRequest(), rHashHex};
        } catch (Exception e) {
            throw new LightningNetworkException(e.getMessage());
        }
    }

    public boolean checkInvoiceStrCorresponds(String invoiceStr, int satsValue, String convId, String payId, double amountCurr, String currency) {
        if(useMock) {
            return true;
        }

        Rpc.PayReq invoice = stub.decodePayReq(Rpc.PayReqString.newBuilder().setPayReq(invoiceStr).build());

        if(invoice.getNumSatoshis() != satsValue) {
            return false;
        }

        //check that the values correspond to the values in the memo message
        JSONObject memoJsonObj = null;
        try {
            JSONParser parser = new JSONParser();
            memoJsonObj = (JSONObject) parser.parse(invoice.getDescription());

            if(!memoJsonObj.get("convId").toString().equals(convId)) {
                return false;
            }
            if(!memoJsonObj.get("payId").toString().equals(payId)) {
                return false;
            }
            if(Double.parseDouble(memoJsonObj.get("amountCurr").toString()) != amountCurr) {
                return false;
            }
            if(!memoJsonObj.get("currency").toString().equals(currency)) {
                return false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public String sendPayment(String invoice, int feeLimitSat) throws LightningNetworkException {
        if(useMock) {
            return "mock_rhash";
        }

        try {
            //Also would have a possibility of percentual fee limit
            Rpc.FeeLimit feeLimit = Rpc.FeeLimit.newBuilder().setFixed(feeLimitSat).build();

            Rpc.SendResponse response = stub.sendPaymentSync(Rpc.SendRequest.newBuilder().setPaymentRequest(invoice).setFeeLimit(feeLimit).build());

            //throw if has any errors
            if(!response.getPaymentError().isEmpty()) {
                throw new LightningNetworkException(response.getPaymentError());
            }

            //return paymentHash (equivalent of RHash in the invoice!)
            return String.valueOf(Hex.encodeHex(response.getPaymentHash().toByteArray()));

        } catch (Exception e) {
            throw new LightningNetworkException(e.getMessage());
        }
    }

    public long amountOfPaymentReceived(String rHashHex) {
        if(useMock) {
            return 50000;
        }

        try {
            Rpc.PaymentHash rHashRequest = Rpc.PaymentHash.newBuilder().setRHash(ByteString.copyFrom(Hex.decodeHex(rHashHex.toCharArray()))).build();

            Rpc.Invoice response = stub.lookupInvoice(rHashRequest);
            return response.getAmtPaidSat();

        } catch (DecoderException e) {
            e.printStackTrace();
        }

        //not paid!
        return 0;
    }

    public long getFeesPaid(String rHashHex) throws LightningNetworkException {
        if(useMock) {
            return 0;
        }

        try {

            //get 5 latest payments
            Rpc.ListPaymentsRequest listPaymentsRequest = Rpc.ListPaymentsRequest.newBuilder().setMaxPayments(5).setReversed(true).build();
            Rpc.ListPaymentsResponse response = stub.listPayments(listPaymentsRequest);
            List<Rpc.Payment> paymentsList = response.getPaymentsList();

            //get the fees of the correct payment
            for (Rpc.Payment payment : paymentsList) {
                if(rHashHex.equals(payment.getPaymentHash())) {
                    return payment.getFeeSat();
                }
            }

            throw new LightningNetworkException("Payment not found in the last 5 payments. Cannot calculate fees.");

        } catch (Exception e) {
            throw new LightningNetworkException(e.getMessage());
        }
    }

}
