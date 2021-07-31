package util;

import io.grpc.*;
import io.grpc.netty.*;

import lnrpc.LightningGrpc;
import lnrpc.Rpc;

import static lnrpc.LightningGrpc.newBlockingStub;

public class LNgrpcClient {

    private final LightningGrpc.LightningBlockingStub stub;
    private ManagedChannel channel;

    public LNgrpcClient(String host, int port) {

        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        stub = newBlockingStub(channel);
    }

    //FOR TESTING!!!!!
    public String getInfo() {

        Rpc.GetInfoResponse response = stub.getInfo(Rpc.GetInfoRequest.newBuilder().build());
        return String.valueOf(response.getBlockHeight());
    }
}
