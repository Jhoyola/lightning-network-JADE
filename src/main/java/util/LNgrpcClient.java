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

    public LNgrpcClient(String host, int port, String certPath, String macaroonPath) {

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

        } catch (IOException e) {
            //TODO Handle exception better
            e.printStackTrace();
            stub_ = null;
        } catch (Exception e) {
            e.printStackTrace();
            stub_ = null;
        }
        stub = stub_;
    }

    private Rpc.ChannelBalanceResponse getChannelBalance() {
        return stub.channelBalance(Rpc.ChannelBalanceRequest.getDefaultInstance());
    }

    private String createJsonMemo(String convId, String prodId, double amountCurr, String currency) {

        JSONObject jsonMemo = new JSONObject();
        jsonMemo.put("convId", convId);
        jsonMemo.put("prodId", prodId);
        jsonMemo.put("amountCurr", amountCurr);
        jsonMemo.put("currency", currency);

        return jsonMemo.toJSONString();
    }

    //retuns the balance in sats that can be sent
    public long getSendableBalance() {
        return getChannelBalance().getLocalBalance().getSat();
    }

    //retuns the balance in sats that can be received
    public long getReceivableBalance() {
        return getChannelBalance().getRemoteBalance().getSat();
    }

    public String[] createInvoice(long amount, String convId, String prodId, double amountCurr, String currency) {
        Rpc.Invoice.Builder invoiceBuilder = Rpc.Invoice.newBuilder();
        invoiceBuilder.setValue(amount); //value in satoshis

        //create the memo of the invoice
        invoiceBuilder.setMemo(createJsonMemo(convId, prodId, amountCurr, currency));

        Rpc.Invoice i = invoiceBuilder.build();
        Rpc.AddInvoiceResponse response = stub.addInvoice(i);

        String rHashHex = String.valueOf(Hex.encodeHex(response.getRHash().toByteArray()));

        //return 2 strings: payment request [0] and rHash [1]
        return new String[]{response.getPaymentRequest(), rHashHex};
    }

    public boolean checkInvoiceStrCorresponds(String invoiceStr, int satsValue, String convId, String prodId, double amountCurr, String currency) {

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
            if(!memoJsonObj.get("prodId").toString().equals(prodId)) {
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

    public String sendPayment(String invoice) {
        Rpc.SendResponse response = stub.sendPaymentSync(Rpc.SendRequest.newBuilder().setPaymentRequest(invoice).build());

        //TODO ERROR HANDLING
        //response.getPaymentError()

        //paymentHash is equivalent of RHash in the invoice!
        return String.valueOf(Hex.encodeHex(response.getPaymentHash().toByteArray()));
    }

    public long amountOfPaymentReceived(String rHashHex) {

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


}
