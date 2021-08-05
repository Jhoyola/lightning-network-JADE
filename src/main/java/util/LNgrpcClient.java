package util;

import io.grpc.*;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;

import lnrpc.LightningGrpc;
import lnrpc.Rpc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;

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

    //FOR TESTING!!!!!
    public void test() {

        try {
            Rpc.GetInfoResponse response = stub.getInfo(Rpc.GetInfoRequest.getDefaultInstance());
            System.out.println(response.getIdentityPubkey());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
