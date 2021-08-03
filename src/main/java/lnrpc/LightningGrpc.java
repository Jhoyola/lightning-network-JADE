package lnrpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Lightning is the main RPC server of the daemon.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: rpc.proto")
public final class LightningGrpc {

  private LightningGrpc() {}

  public static final String SERVICE_NAME = "lnrpc.Lightning";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWalletBalanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.WalletBalanceRequest,
      lnrpc.Rpc.WalletBalanceResponse> METHOD_WALLET_BALANCE = getWalletBalanceMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.WalletBalanceRequest,
      lnrpc.Rpc.WalletBalanceResponse> getWalletBalanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.WalletBalanceRequest,
      lnrpc.Rpc.WalletBalanceResponse> getWalletBalanceMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.WalletBalanceRequest, lnrpc.Rpc.WalletBalanceResponse> getWalletBalanceMethod;
    if ((getWalletBalanceMethod = LightningGrpc.getWalletBalanceMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getWalletBalanceMethod = LightningGrpc.getWalletBalanceMethod) == null) {
          LightningGrpc.getWalletBalanceMethod = getWalletBalanceMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.WalletBalanceRequest, lnrpc.Rpc.WalletBalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "WalletBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.WalletBalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.WalletBalanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("WalletBalance"))
                  .build();
          }
        }
     }
     return getWalletBalanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getChannelBalanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelBalanceRequest,
      lnrpc.Rpc.ChannelBalanceResponse> METHOD_CHANNEL_BALANCE = getChannelBalanceMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelBalanceRequest,
      lnrpc.Rpc.ChannelBalanceResponse> getChannelBalanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelBalanceRequest,
      lnrpc.Rpc.ChannelBalanceResponse> getChannelBalanceMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelBalanceRequest, lnrpc.Rpc.ChannelBalanceResponse> getChannelBalanceMethod;
    if ((getChannelBalanceMethod = LightningGrpc.getChannelBalanceMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getChannelBalanceMethod = LightningGrpc.getChannelBalanceMethod) == null) {
          LightningGrpc.getChannelBalanceMethod = getChannelBalanceMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ChannelBalanceRequest, lnrpc.Rpc.ChannelBalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ChannelBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelBalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelBalanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ChannelBalance"))
                  .build();
          }
        }
     }
     return getChannelBalanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTransactionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.GetTransactionsRequest,
      lnrpc.Rpc.TransactionDetails> METHOD_GET_TRANSACTIONS = getGetTransactionsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.GetTransactionsRequest,
      lnrpc.Rpc.TransactionDetails> getGetTransactionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.GetTransactionsRequest,
      lnrpc.Rpc.TransactionDetails> getGetTransactionsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.GetTransactionsRequest, lnrpc.Rpc.TransactionDetails> getGetTransactionsMethod;
    if ((getGetTransactionsMethod = LightningGrpc.getGetTransactionsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getGetTransactionsMethod = LightningGrpc.getGetTransactionsMethod) == null) {
          LightningGrpc.getGetTransactionsMethod = getGetTransactionsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.GetTransactionsRequest, lnrpc.Rpc.TransactionDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "GetTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.GetTransactionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.TransactionDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("GetTransactions"))
                  .build();
          }
        }
     }
     return getGetTransactionsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getEstimateFeeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.EstimateFeeRequest,
      lnrpc.Rpc.EstimateFeeResponse> METHOD_ESTIMATE_FEE = getEstimateFeeMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.EstimateFeeRequest,
      lnrpc.Rpc.EstimateFeeResponse> getEstimateFeeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.EstimateFeeRequest,
      lnrpc.Rpc.EstimateFeeResponse> getEstimateFeeMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.EstimateFeeRequest, lnrpc.Rpc.EstimateFeeResponse> getEstimateFeeMethod;
    if ((getEstimateFeeMethod = LightningGrpc.getEstimateFeeMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getEstimateFeeMethod = LightningGrpc.getEstimateFeeMethod) == null) {
          LightningGrpc.getEstimateFeeMethod = getEstimateFeeMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.EstimateFeeRequest, lnrpc.Rpc.EstimateFeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "EstimateFee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.EstimateFeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.EstimateFeeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("EstimateFee"))
                  .build();
          }
        }
     }
     return getEstimateFeeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendCoinsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.SendCoinsRequest,
      lnrpc.Rpc.SendCoinsResponse> METHOD_SEND_COINS = getSendCoinsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.SendCoinsRequest,
      lnrpc.Rpc.SendCoinsResponse> getSendCoinsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.SendCoinsRequest,
      lnrpc.Rpc.SendCoinsResponse> getSendCoinsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.SendCoinsRequest, lnrpc.Rpc.SendCoinsResponse> getSendCoinsMethod;
    if ((getSendCoinsMethod = LightningGrpc.getSendCoinsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSendCoinsMethod = LightningGrpc.getSendCoinsMethod) == null) {
          LightningGrpc.getSendCoinsMethod = getSendCoinsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.SendCoinsRequest, lnrpc.Rpc.SendCoinsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SendCoins"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendCoinsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendCoinsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SendCoins"))
                  .build();
          }
        }
     }
     return getSendCoinsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListUnspentMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ListUnspentRequest,
      lnrpc.Rpc.ListUnspentResponse> METHOD_LIST_UNSPENT = getListUnspentMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ListUnspentRequest,
      lnrpc.Rpc.ListUnspentResponse> getListUnspentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ListUnspentRequest,
      lnrpc.Rpc.ListUnspentResponse> getListUnspentMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ListUnspentRequest, lnrpc.Rpc.ListUnspentResponse> getListUnspentMethod;
    if ((getListUnspentMethod = LightningGrpc.getListUnspentMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getListUnspentMethod = LightningGrpc.getListUnspentMethod) == null) {
          LightningGrpc.getListUnspentMethod = getListUnspentMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ListUnspentRequest, lnrpc.Rpc.ListUnspentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ListUnspent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListUnspentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListUnspentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ListUnspent"))
                  .build();
          }
        }
     }
     return getListUnspentMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubscribeTransactionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.GetTransactionsRequest,
      lnrpc.Rpc.Transaction> METHOD_SUBSCRIBE_TRANSACTIONS = getSubscribeTransactionsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.GetTransactionsRequest,
      lnrpc.Rpc.Transaction> getSubscribeTransactionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.GetTransactionsRequest,
      lnrpc.Rpc.Transaction> getSubscribeTransactionsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.GetTransactionsRequest, lnrpc.Rpc.Transaction> getSubscribeTransactionsMethod;
    if ((getSubscribeTransactionsMethod = LightningGrpc.getSubscribeTransactionsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSubscribeTransactionsMethod = LightningGrpc.getSubscribeTransactionsMethod) == null) {
          LightningGrpc.getSubscribeTransactionsMethod = getSubscribeTransactionsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.GetTransactionsRequest, lnrpc.Rpc.Transaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SubscribeTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.GetTransactionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.Transaction.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SubscribeTransactions"))
                  .build();
          }
        }
     }
     return getSubscribeTransactionsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendManyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.SendManyRequest,
      lnrpc.Rpc.SendManyResponse> METHOD_SEND_MANY = getSendManyMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.SendManyRequest,
      lnrpc.Rpc.SendManyResponse> getSendManyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.SendManyRequest,
      lnrpc.Rpc.SendManyResponse> getSendManyMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.SendManyRequest, lnrpc.Rpc.SendManyResponse> getSendManyMethod;
    if ((getSendManyMethod = LightningGrpc.getSendManyMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSendManyMethod = LightningGrpc.getSendManyMethod) == null) {
          LightningGrpc.getSendManyMethod = getSendManyMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.SendManyRequest, lnrpc.Rpc.SendManyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SendMany"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendManyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendManyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SendMany"))
                  .build();
          }
        }
     }
     return getSendManyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getNewAddressMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.NewAddressRequest,
      lnrpc.Rpc.NewAddressResponse> METHOD_NEW_ADDRESS = getNewAddressMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.NewAddressRequest,
      lnrpc.Rpc.NewAddressResponse> getNewAddressMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.NewAddressRequest,
      lnrpc.Rpc.NewAddressResponse> getNewAddressMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.NewAddressRequest, lnrpc.Rpc.NewAddressResponse> getNewAddressMethod;
    if ((getNewAddressMethod = LightningGrpc.getNewAddressMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getNewAddressMethod = LightningGrpc.getNewAddressMethod) == null) {
          LightningGrpc.getNewAddressMethod = getNewAddressMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.NewAddressRequest, lnrpc.Rpc.NewAddressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "NewAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.NewAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.NewAddressResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("NewAddress"))
                  .build();
          }
        }
     }
     return getNewAddressMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSignMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.SignMessageRequest,
      lnrpc.Rpc.SignMessageResponse> METHOD_SIGN_MESSAGE = getSignMessageMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.SignMessageRequest,
      lnrpc.Rpc.SignMessageResponse> getSignMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.SignMessageRequest,
      lnrpc.Rpc.SignMessageResponse> getSignMessageMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.SignMessageRequest, lnrpc.Rpc.SignMessageResponse> getSignMessageMethod;
    if ((getSignMessageMethod = LightningGrpc.getSignMessageMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSignMessageMethod = LightningGrpc.getSignMessageMethod) == null) {
          LightningGrpc.getSignMessageMethod = getSignMessageMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.SignMessageRequest, lnrpc.Rpc.SignMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SignMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SignMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SignMessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SignMessage"))
                  .build();
          }
        }
     }
     return getSignMessageMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getVerifyMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.VerifyMessageRequest,
      lnrpc.Rpc.VerifyMessageResponse> METHOD_VERIFY_MESSAGE = getVerifyMessageMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.VerifyMessageRequest,
      lnrpc.Rpc.VerifyMessageResponse> getVerifyMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.VerifyMessageRequest,
      lnrpc.Rpc.VerifyMessageResponse> getVerifyMessageMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.VerifyMessageRequest, lnrpc.Rpc.VerifyMessageResponse> getVerifyMessageMethod;
    if ((getVerifyMessageMethod = LightningGrpc.getVerifyMessageMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getVerifyMessageMethod = LightningGrpc.getVerifyMessageMethod) == null) {
          LightningGrpc.getVerifyMessageMethod = getVerifyMessageMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.VerifyMessageRequest, lnrpc.Rpc.VerifyMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "VerifyMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.VerifyMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.VerifyMessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("VerifyMessage"))
                  .build();
          }
        }
     }
     return getVerifyMessageMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getConnectPeerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ConnectPeerRequest,
      lnrpc.Rpc.ConnectPeerResponse> METHOD_CONNECT_PEER = getConnectPeerMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ConnectPeerRequest,
      lnrpc.Rpc.ConnectPeerResponse> getConnectPeerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ConnectPeerRequest,
      lnrpc.Rpc.ConnectPeerResponse> getConnectPeerMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ConnectPeerRequest, lnrpc.Rpc.ConnectPeerResponse> getConnectPeerMethod;
    if ((getConnectPeerMethod = LightningGrpc.getConnectPeerMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getConnectPeerMethod = LightningGrpc.getConnectPeerMethod) == null) {
          LightningGrpc.getConnectPeerMethod = getConnectPeerMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ConnectPeerRequest, lnrpc.Rpc.ConnectPeerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ConnectPeer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ConnectPeerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ConnectPeerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ConnectPeer"))
                  .build();
          }
        }
     }
     return getConnectPeerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDisconnectPeerMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.DisconnectPeerRequest,
      lnrpc.Rpc.DisconnectPeerResponse> METHOD_DISCONNECT_PEER = getDisconnectPeerMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.DisconnectPeerRequest,
      lnrpc.Rpc.DisconnectPeerResponse> getDisconnectPeerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.DisconnectPeerRequest,
      lnrpc.Rpc.DisconnectPeerResponse> getDisconnectPeerMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.DisconnectPeerRequest, lnrpc.Rpc.DisconnectPeerResponse> getDisconnectPeerMethod;
    if ((getDisconnectPeerMethod = LightningGrpc.getDisconnectPeerMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getDisconnectPeerMethod = LightningGrpc.getDisconnectPeerMethod) == null) {
          LightningGrpc.getDisconnectPeerMethod = getDisconnectPeerMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.DisconnectPeerRequest, lnrpc.Rpc.DisconnectPeerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "DisconnectPeer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.DisconnectPeerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.DisconnectPeerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("DisconnectPeer"))
                  .build();
          }
        }
     }
     return getDisconnectPeerMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListPeersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ListPeersRequest,
      lnrpc.Rpc.ListPeersResponse> METHOD_LIST_PEERS = getListPeersMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ListPeersRequest,
      lnrpc.Rpc.ListPeersResponse> getListPeersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ListPeersRequest,
      lnrpc.Rpc.ListPeersResponse> getListPeersMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ListPeersRequest, lnrpc.Rpc.ListPeersResponse> getListPeersMethod;
    if ((getListPeersMethod = LightningGrpc.getListPeersMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getListPeersMethod = LightningGrpc.getListPeersMethod) == null) {
          LightningGrpc.getListPeersMethod = getListPeersMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ListPeersRequest, lnrpc.Rpc.ListPeersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ListPeers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListPeersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListPeersResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ListPeers"))
                  .build();
          }
        }
     }
     return getListPeersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubscribePeerEventsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.PeerEventSubscription,
      lnrpc.Rpc.PeerEvent> METHOD_SUBSCRIBE_PEER_EVENTS = getSubscribePeerEventsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.PeerEventSubscription,
      lnrpc.Rpc.PeerEvent> getSubscribePeerEventsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.PeerEventSubscription,
      lnrpc.Rpc.PeerEvent> getSubscribePeerEventsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.PeerEventSubscription, lnrpc.Rpc.PeerEvent> getSubscribePeerEventsMethod;
    if ((getSubscribePeerEventsMethod = LightningGrpc.getSubscribePeerEventsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSubscribePeerEventsMethod = LightningGrpc.getSubscribePeerEventsMethod) == null) {
          LightningGrpc.getSubscribePeerEventsMethod = getSubscribePeerEventsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.PeerEventSubscription, lnrpc.Rpc.PeerEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SubscribePeerEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PeerEventSubscription.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PeerEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SubscribePeerEvents"))
                  .build();
          }
        }
     }
     return getSubscribePeerEventsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.GetInfoRequest,
      lnrpc.Rpc.GetInfoResponse> METHOD_GET_INFO = getGetInfoMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.GetInfoRequest,
      lnrpc.Rpc.GetInfoResponse> getGetInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.GetInfoRequest,
      lnrpc.Rpc.GetInfoResponse> getGetInfoMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.GetInfoRequest, lnrpc.Rpc.GetInfoResponse> getGetInfoMethod;
    if ((getGetInfoMethod = LightningGrpc.getGetInfoMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getGetInfoMethod = LightningGrpc.getGetInfoMethod) == null) {
          LightningGrpc.getGetInfoMethod = getGetInfoMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.GetInfoRequest, lnrpc.Rpc.GetInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "GetInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.GetInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.GetInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("GetInfo"))
                  .build();
          }
        }
     }
     return getGetInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetRecoveryInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.GetRecoveryInfoRequest,
      lnrpc.Rpc.GetRecoveryInfoResponse> METHOD_GET_RECOVERY_INFO = getGetRecoveryInfoMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.GetRecoveryInfoRequest,
      lnrpc.Rpc.GetRecoveryInfoResponse> getGetRecoveryInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.GetRecoveryInfoRequest,
      lnrpc.Rpc.GetRecoveryInfoResponse> getGetRecoveryInfoMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.GetRecoveryInfoRequest, lnrpc.Rpc.GetRecoveryInfoResponse> getGetRecoveryInfoMethod;
    if ((getGetRecoveryInfoMethod = LightningGrpc.getGetRecoveryInfoMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getGetRecoveryInfoMethod = LightningGrpc.getGetRecoveryInfoMethod) == null) {
          LightningGrpc.getGetRecoveryInfoMethod = getGetRecoveryInfoMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.GetRecoveryInfoRequest, lnrpc.Rpc.GetRecoveryInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "GetRecoveryInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.GetRecoveryInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.GetRecoveryInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("GetRecoveryInfo"))
                  .build();
          }
        }
     }
     return getGetRecoveryInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPendingChannelsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.PendingChannelsRequest,
      lnrpc.Rpc.PendingChannelsResponse> METHOD_PENDING_CHANNELS = getPendingChannelsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.PendingChannelsRequest,
      lnrpc.Rpc.PendingChannelsResponse> getPendingChannelsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.PendingChannelsRequest,
      lnrpc.Rpc.PendingChannelsResponse> getPendingChannelsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.PendingChannelsRequest, lnrpc.Rpc.PendingChannelsResponse> getPendingChannelsMethod;
    if ((getPendingChannelsMethod = LightningGrpc.getPendingChannelsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getPendingChannelsMethod = LightningGrpc.getPendingChannelsMethod) == null) {
          LightningGrpc.getPendingChannelsMethod = getPendingChannelsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.PendingChannelsRequest, lnrpc.Rpc.PendingChannelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "PendingChannels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PendingChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PendingChannelsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("PendingChannels"))
                  .build();
          }
        }
     }
     return getPendingChannelsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListChannelsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ListChannelsRequest,
      lnrpc.Rpc.ListChannelsResponse> METHOD_LIST_CHANNELS = getListChannelsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ListChannelsRequest,
      lnrpc.Rpc.ListChannelsResponse> getListChannelsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ListChannelsRequest,
      lnrpc.Rpc.ListChannelsResponse> getListChannelsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ListChannelsRequest, lnrpc.Rpc.ListChannelsResponse> getListChannelsMethod;
    if ((getListChannelsMethod = LightningGrpc.getListChannelsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getListChannelsMethod = LightningGrpc.getListChannelsMethod) == null) {
          LightningGrpc.getListChannelsMethod = getListChannelsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ListChannelsRequest, lnrpc.Rpc.ListChannelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ListChannels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListChannelsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ListChannels"))
                  .build();
          }
        }
     }
     return getListChannelsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubscribeChannelEventsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelEventSubscription,
      lnrpc.Rpc.ChannelEventUpdate> METHOD_SUBSCRIBE_CHANNEL_EVENTS = getSubscribeChannelEventsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelEventSubscription,
      lnrpc.Rpc.ChannelEventUpdate> getSubscribeChannelEventsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelEventSubscription,
      lnrpc.Rpc.ChannelEventUpdate> getSubscribeChannelEventsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelEventSubscription, lnrpc.Rpc.ChannelEventUpdate> getSubscribeChannelEventsMethod;
    if ((getSubscribeChannelEventsMethod = LightningGrpc.getSubscribeChannelEventsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSubscribeChannelEventsMethod = LightningGrpc.getSubscribeChannelEventsMethod) == null) {
          LightningGrpc.getSubscribeChannelEventsMethod = getSubscribeChannelEventsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ChannelEventSubscription, lnrpc.Rpc.ChannelEventUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SubscribeChannelEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelEventSubscription.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelEventUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SubscribeChannelEvents"))
                  .build();
          }
        }
     }
     return getSubscribeChannelEventsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getClosedChannelsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ClosedChannelsRequest,
      lnrpc.Rpc.ClosedChannelsResponse> METHOD_CLOSED_CHANNELS = getClosedChannelsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ClosedChannelsRequest,
      lnrpc.Rpc.ClosedChannelsResponse> getClosedChannelsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ClosedChannelsRequest,
      lnrpc.Rpc.ClosedChannelsResponse> getClosedChannelsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ClosedChannelsRequest, lnrpc.Rpc.ClosedChannelsResponse> getClosedChannelsMethod;
    if ((getClosedChannelsMethod = LightningGrpc.getClosedChannelsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getClosedChannelsMethod = LightningGrpc.getClosedChannelsMethod) == null) {
          LightningGrpc.getClosedChannelsMethod = getClosedChannelsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ClosedChannelsRequest, lnrpc.Rpc.ClosedChannelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ClosedChannels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ClosedChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ClosedChannelsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ClosedChannels"))
                  .build();
          }
        }
     }
     return getClosedChannelsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getOpenChannelSyncMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.OpenChannelRequest,
      lnrpc.Rpc.ChannelPoint> METHOD_OPEN_CHANNEL_SYNC = getOpenChannelSyncMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.OpenChannelRequest,
      lnrpc.Rpc.ChannelPoint> getOpenChannelSyncMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.OpenChannelRequest,
      lnrpc.Rpc.ChannelPoint> getOpenChannelSyncMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.OpenChannelRequest, lnrpc.Rpc.ChannelPoint> getOpenChannelSyncMethod;
    if ((getOpenChannelSyncMethod = LightningGrpc.getOpenChannelSyncMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getOpenChannelSyncMethod = LightningGrpc.getOpenChannelSyncMethod) == null) {
          LightningGrpc.getOpenChannelSyncMethod = getOpenChannelSyncMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.OpenChannelRequest, lnrpc.Rpc.ChannelPoint>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "OpenChannelSync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.OpenChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelPoint.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("OpenChannelSync"))
                  .build();
          }
        }
     }
     return getOpenChannelSyncMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getOpenChannelMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.OpenChannelRequest,
      lnrpc.Rpc.OpenStatusUpdate> METHOD_OPEN_CHANNEL = getOpenChannelMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.OpenChannelRequest,
      lnrpc.Rpc.OpenStatusUpdate> getOpenChannelMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.OpenChannelRequest,
      lnrpc.Rpc.OpenStatusUpdate> getOpenChannelMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.OpenChannelRequest, lnrpc.Rpc.OpenStatusUpdate> getOpenChannelMethod;
    if ((getOpenChannelMethod = LightningGrpc.getOpenChannelMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getOpenChannelMethod = LightningGrpc.getOpenChannelMethod) == null) {
          LightningGrpc.getOpenChannelMethod = getOpenChannelMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.OpenChannelRequest, lnrpc.Rpc.OpenStatusUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "OpenChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.OpenChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.OpenStatusUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("OpenChannel"))
                  .build();
          }
        }
     }
     return getOpenChannelMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getFundingStateStepMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.FundingTransitionMsg,
      lnrpc.Rpc.FundingStateStepResp> METHOD_FUNDING_STATE_STEP = getFundingStateStepMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.FundingTransitionMsg,
      lnrpc.Rpc.FundingStateStepResp> getFundingStateStepMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.FundingTransitionMsg,
      lnrpc.Rpc.FundingStateStepResp> getFundingStateStepMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.FundingTransitionMsg, lnrpc.Rpc.FundingStateStepResp> getFundingStateStepMethod;
    if ((getFundingStateStepMethod = LightningGrpc.getFundingStateStepMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getFundingStateStepMethod = LightningGrpc.getFundingStateStepMethod) == null) {
          LightningGrpc.getFundingStateStepMethod = getFundingStateStepMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.FundingTransitionMsg, lnrpc.Rpc.FundingStateStepResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "FundingStateStep"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.FundingTransitionMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.FundingStateStepResp.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("FundingStateStep"))
                  .build();
          }
        }
     }
     return getFundingStateStepMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getChannelAcceptorMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelAcceptResponse,
      lnrpc.Rpc.ChannelAcceptRequest> METHOD_CHANNEL_ACCEPTOR = getChannelAcceptorMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelAcceptResponse,
      lnrpc.Rpc.ChannelAcceptRequest> getChannelAcceptorMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelAcceptResponse,
      lnrpc.Rpc.ChannelAcceptRequest> getChannelAcceptorMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelAcceptResponse, lnrpc.Rpc.ChannelAcceptRequest> getChannelAcceptorMethod;
    if ((getChannelAcceptorMethod = LightningGrpc.getChannelAcceptorMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getChannelAcceptorMethod = LightningGrpc.getChannelAcceptorMethod) == null) {
          LightningGrpc.getChannelAcceptorMethod = getChannelAcceptorMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ChannelAcceptResponse, lnrpc.Rpc.ChannelAcceptRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ChannelAcceptor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelAcceptResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelAcceptRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ChannelAcceptor"))
                  .build();
          }
        }
     }
     return getChannelAcceptorMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCloseChannelMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.CloseChannelRequest,
      lnrpc.Rpc.CloseStatusUpdate> METHOD_CLOSE_CHANNEL = getCloseChannelMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.CloseChannelRequest,
      lnrpc.Rpc.CloseStatusUpdate> getCloseChannelMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.CloseChannelRequest,
      lnrpc.Rpc.CloseStatusUpdate> getCloseChannelMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.CloseChannelRequest, lnrpc.Rpc.CloseStatusUpdate> getCloseChannelMethod;
    if ((getCloseChannelMethod = LightningGrpc.getCloseChannelMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getCloseChannelMethod = LightningGrpc.getCloseChannelMethod) == null) {
          LightningGrpc.getCloseChannelMethod = getCloseChannelMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.CloseChannelRequest, lnrpc.Rpc.CloseStatusUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "CloseChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.CloseChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.CloseStatusUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("CloseChannel"))
                  .build();
          }
        }
     }
     return getCloseChannelMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAbandonChannelMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.AbandonChannelRequest,
      lnrpc.Rpc.AbandonChannelResponse> METHOD_ABANDON_CHANNEL = getAbandonChannelMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.AbandonChannelRequest,
      lnrpc.Rpc.AbandonChannelResponse> getAbandonChannelMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.AbandonChannelRequest,
      lnrpc.Rpc.AbandonChannelResponse> getAbandonChannelMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.AbandonChannelRequest, lnrpc.Rpc.AbandonChannelResponse> getAbandonChannelMethod;
    if ((getAbandonChannelMethod = LightningGrpc.getAbandonChannelMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getAbandonChannelMethod = LightningGrpc.getAbandonChannelMethod) == null) {
          LightningGrpc.getAbandonChannelMethod = getAbandonChannelMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.AbandonChannelRequest, lnrpc.Rpc.AbandonChannelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "AbandonChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.AbandonChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.AbandonChannelResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("AbandonChannel"))
                  .build();
          }
        }
     }
     return getAbandonChannelMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendPaymentMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.SendRequest,
      lnrpc.Rpc.SendResponse> METHOD_SEND_PAYMENT = getSendPaymentMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.SendRequest,
      lnrpc.Rpc.SendResponse> getSendPaymentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.SendRequest,
      lnrpc.Rpc.SendResponse> getSendPaymentMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.SendRequest, lnrpc.Rpc.SendResponse> getSendPaymentMethod;
    if ((getSendPaymentMethod = LightningGrpc.getSendPaymentMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSendPaymentMethod = LightningGrpc.getSendPaymentMethod) == null) {
          LightningGrpc.getSendPaymentMethod = getSendPaymentMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.SendRequest, lnrpc.Rpc.SendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SendPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SendPayment"))
                  .build();
          }
        }
     }
     return getSendPaymentMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendPaymentSyncMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.SendRequest,
      lnrpc.Rpc.SendResponse> METHOD_SEND_PAYMENT_SYNC = getSendPaymentSyncMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.SendRequest,
      lnrpc.Rpc.SendResponse> getSendPaymentSyncMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.SendRequest,
      lnrpc.Rpc.SendResponse> getSendPaymentSyncMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.SendRequest, lnrpc.Rpc.SendResponse> getSendPaymentSyncMethod;
    if ((getSendPaymentSyncMethod = LightningGrpc.getSendPaymentSyncMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSendPaymentSyncMethod = LightningGrpc.getSendPaymentSyncMethod) == null) {
          LightningGrpc.getSendPaymentSyncMethod = getSendPaymentSyncMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.SendRequest, lnrpc.Rpc.SendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SendPaymentSync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SendPaymentSync"))
                  .build();
          }
        }
     }
     return getSendPaymentSyncMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendToRouteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.SendToRouteRequest,
      lnrpc.Rpc.SendResponse> METHOD_SEND_TO_ROUTE = getSendToRouteMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.SendToRouteRequest,
      lnrpc.Rpc.SendResponse> getSendToRouteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.SendToRouteRequest,
      lnrpc.Rpc.SendResponse> getSendToRouteMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.SendToRouteRequest, lnrpc.Rpc.SendResponse> getSendToRouteMethod;
    if ((getSendToRouteMethod = LightningGrpc.getSendToRouteMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSendToRouteMethod = LightningGrpc.getSendToRouteMethod) == null) {
          LightningGrpc.getSendToRouteMethod = getSendToRouteMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.SendToRouteRequest, lnrpc.Rpc.SendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SendToRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendToRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SendToRoute"))
                  .build();
          }
        }
     }
     return getSendToRouteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendToRouteSyncMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.SendToRouteRequest,
      lnrpc.Rpc.SendResponse> METHOD_SEND_TO_ROUTE_SYNC = getSendToRouteSyncMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.SendToRouteRequest,
      lnrpc.Rpc.SendResponse> getSendToRouteSyncMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.SendToRouteRequest,
      lnrpc.Rpc.SendResponse> getSendToRouteSyncMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.SendToRouteRequest, lnrpc.Rpc.SendResponse> getSendToRouteSyncMethod;
    if ((getSendToRouteSyncMethod = LightningGrpc.getSendToRouteSyncMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSendToRouteSyncMethod = LightningGrpc.getSendToRouteSyncMethod) == null) {
          LightningGrpc.getSendToRouteSyncMethod = getSendToRouteSyncMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.SendToRouteRequest, lnrpc.Rpc.SendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SendToRouteSync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendToRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.SendResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SendToRouteSync"))
                  .build();
          }
        }
     }
     return getSendToRouteSyncMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddInvoiceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.Invoice,
      lnrpc.Rpc.AddInvoiceResponse> METHOD_ADD_INVOICE = getAddInvoiceMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.Invoice,
      lnrpc.Rpc.AddInvoiceResponse> getAddInvoiceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.Invoice,
      lnrpc.Rpc.AddInvoiceResponse> getAddInvoiceMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.Invoice, lnrpc.Rpc.AddInvoiceResponse> getAddInvoiceMethod;
    if ((getAddInvoiceMethod = LightningGrpc.getAddInvoiceMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getAddInvoiceMethod = LightningGrpc.getAddInvoiceMethod) == null) {
          LightningGrpc.getAddInvoiceMethod = getAddInvoiceMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.Invoice, lnrpc.Rpc.AddInvoiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "AddInvoice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.Invoice.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.AddInvoiceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("AddInvoice"))
                  .build();
          }
        }
     }
     return getAddInvoiceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListInvoicesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ListInvoiceRequest,
      lnrpc.Rpc.ListInvoiceResponse> METHOD_LIST_INVOICES = getListInvoicesMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ListInvoiceRequest,
      lnrpc.Rpc.ListInvoiceResponse> getListInvoicesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ListInvoiceRequest,
      lnrpc.Rpc.ListInvoiceResponse> getListInvoicesMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ListInvoiceRequest, lnrpc.Rpc.ListInvoiceResponse> getListInvoicesMethod;
    if ((getListInvoicesMethod = LightningGrpc.getListInvoicesMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getListInvoicesMethod = LightningGrpc.getListInvoicesMethod) == null) {
          LightningGrpc.getListInvoicesMethod = getListInvoicesMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ListInvoiceRequest, lnrpc.Rpc.ListInvoiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ListInvoices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListInvoiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListInvoiceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ListInvoices"))
                  .build();
          }
        }
     }
     return getListInvoicesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLookupInvoiceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.PaymentHash,
      lnrpc.Rpc.Invoice> METHOD_LOOKUP_INVOICE = getLookupInvoiceMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.PaymentHash,
      lnrpc.Rpc.Invoice> getLookupInvoiceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.PaymentHash,
      lnrpc.Rpc.Invoice> getLookupInvoiceMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.PaymentHash, lnrpc.Rpc.Invoice> getLookupInvoiceMethod;
    if ((getLookupInvoiceMethod = LightningGrpc.getLookupInvoiceMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getLookupInvoiceMethod = LightningGrpc.getLookupInvoiceMethod) == null) {
          LightningGrpc.getLookupInvoiceMethod = getLookupInvoiceMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.PaymentHash, lnrpc.Rpc.Invoice>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "LookupInvoice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PaymentHash.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.Invoice.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("LookupInvoice"))
                  .build();
          }
        }
     }
     return getLookupInvoiceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubscribeInvoicesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.InvoiceSubscription,
      lnrpc.Rpc.Invoice> METHOD_SUBSCRIBE_INVOICES = getSubscribeInvoicesMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.InvoiceSubscription,
      lnrpc.Rpc.Invoice> getSubscribeInvoicesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.InvoiceSubscription,
      lnrpc.Rpc.Invoice> getSubscribeInvoicesMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.InvoiceSubscription, lnrpc.Rpc.Invoice> getSubscribeInvoicesMethod;
    if ((getSubscribeInvoicesMethod = LightningGrpc.getSubscribeInvoicesMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSubscribeInvoicesMethod = LightningGrpc.getSubscribeInvoicesMethod) == null) {
          LightningGrpc.getSubscribeInvoicesMethod = getSubscribeInvoicesMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.InvoiceSubscription, lnrpc.Rpc.Invoice>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SubscribeInvoices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.InvoiceSubscription.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.Invoice.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SubscribeInvoices"))
                  .build();
          }
        }
     }
     return getSubscribeInvoicesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDecodePayReqMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.PayReqString,
      lnrpc.Rpc.PayReq> METHOD_DECODE_PAY_REQ = getDecodePayReqMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.PayReqString,
      lnrpc.Rpc.PayReq> getDecodePayReqMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.PayReqString,
      lnrpc.Rpc.PayReq> getDecodePayReqMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.PayReqString, lnrpc.Rpc.PayReq> getDecodePayReqMethod;
    if ((getDecodePayReqMethod = LightningGrpc.getDecodePayReqMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getDecodePayReqMethod = LightningGrpc.getDecodePayReqMethod) == null) {
          LightningGrpc.getDecodePayReqMethod = getDecodePayReqMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.PayReqString, lnrpc.Rpc.PayReq>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "DecodePayReq"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PayReqString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PayReq.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("DecodePayReq"))
                  .build();
          }
        }
     }
     return getDecodePayReqMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListPaymentsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ListPaymentsRequest,
      lnrpc.Rpc.ListPaymentsResponse> METHOD_LIST_PAYMENTS = getListPaymentsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ListPaymentsRequest,
      lnrpc.Rpc.ListPaymentsResponse> getListPaymentsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ListPaymentsRequest,
      lnrpc.Rpc.ListPaymentsResponse> getListPaymentsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ListPaymentsRequest, lnrpc.Rpc.ListPaymentsResponse> getListPaymentsMethod;
    if ((getListPaymentsMethod = LightningGrpc.getListPaymentsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getListPaymentsMethod = LightningGrpc.getListPaymentsMethod) == null) {
          LightningGrpc.getListPaymentsMethod = getListPaymentsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ListPaymentsRequest, lnrpc.Rpc.ListPaymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ListPayments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListPaymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListPaymentsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ListPayments"))
                  .build();
          }
        }
     }
     return getListPaymentsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteAllPaymentsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.DeleteAllPaymentsRequest,
      lnrpc.Rpc.DeleteAllPaymentsResponse> METHOD_DELETE_ALL_PAYMENTS = getDeleteAllPaymentsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.DeleteAllPaymentsRequest,
      lnrpc.Rpc.DeleteAllPaymentsResponse> getDeleteAllPaymentsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.DeleteAllPaymentsRequest,
      lnrpc.Rpc.DeleteAllPaymentsResponse> getDeleteAllPaymentsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.DeleteAllPaymentsRequest, lnrpc.Rpc.DeleteAllPaymentsResponse> getDeleteAllPaymentsMethod;
    if ((getDeleteAllPaymentsMethod = LightningGrpc.getDeleteAllPaymentsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getDeleteAllPaymentsMethod = LightningGrpc.getDeleteAllPaymentsMethod) == null) {
          LightningGrpc.getDeleteAllPaymentsMethod = getDeleteAllPaymentsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.DeleteAllPaymentsRequest, lnrpc.Rpc.DeleteAllPaymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "DeleteAllPayments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.DeleteAllPaymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.DeleteAllPaymentsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("DeleteAllPayments"))
                  .build();
          }
        }
     }
     return getDeleteAllPaymentsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDescribeGraphMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelGraphRequest,
      lnrpc.Rpc.ChannelGraph> METHOD_DESCRIBE_GRAPH = getDescribeGraphMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelGraphRequest,
      lnrpc.Rpc.ChannelGraph> getDescribeGraphMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelGraphRequest,
      lnrpc.Rpc.ChannelGraph> getDescribeGraphMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelGraphRequest, lnrpc.Rpc.ChannelGraph> getDescribeGraphMethod;
    if ((getDescribeGraphMethod = LightningGrpc.getDescribeGraphMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getDescribeGraphMethod = LightningGrpc.getDescribeGraphMethod) == null) {
          LightningGrpc.getDescribeGraphMethod = getDescribeGraphMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ChannelGraphRequest, lnrpc.Rpc.ChannelGraph>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "DescribeGraph"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelGraphRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelGraph.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("DescribeGraph"))
                  .build();
          }
        }
     }
     return getDescribeGraphMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNodeMetricsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.NodeMetricsRequest,
      lnrpc.Rpc.NodeMetricsResponse> METHOD_GET_NODE_METRICS = getGetNodeMetricsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.NodeMetricsRequest,
      lnrpc.Rpc.NodeMetricsResponse> getGetNodeMetricsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.NodeMetricsRequest,
      lnrpc.Rpc.NodeMetricsResponse> getGetNodeMetricsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.NodeMetricsRequest, lnrpc.Rpc.NodeMetricsResponse> getGetNodeMetricsMethod;
    if ((getGetNodeMetricsMethod = LightningGrpc.getGetNodeMetricsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getGetNodeMetricsMethod = LightningGrpc.getGetNodeMetricsMethod) == null) {
          LightningGrpc.getGetNodeMetricsMethod = getGetNodeMetricsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.NodeMetricsRequest, lnrpc.Rpc.NodeMetricsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "GetNodeMetrics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.NodeMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.NodeMetricsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("GetNodeMetrics"))
                  .build();
          }
        }
     }
     return getGetNodeMetricsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetChanInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ChanInfoRequest,
      lnrpc.Rpc.ChannelEdge> METHOD_GET_CHAN_INFO = getGetChanInfoMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ChanInfoRequest,
      lnrpc.Rpc.ChannelEdge> getGetChanInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ChanInfoRequest,
      lnrpc.Rpc.ChannelEdge> getGetChanInfoMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ChanInfoRequest, lnrpc.Rpc.ChannelEdge> getGetChanInfoMethod;
    if ((getGetChanInfoMethod = LightningGrpc.getGetChanInfoMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getGetChanInfoMethod = LightningGrpc.getGetChanInfoMethod) == null) {
          LightningGrpc.getGetChanInfoMethod = getGetChanInfoMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ChanInfoRequest, lnrpc.Rpc.ChannelEdge>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "GetChanInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChanInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelEdge.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("GetChanInfo"))
                  .build();
          }
        }
     }
     return getGetChanInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNodeInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.NodeInfoRequest,
      lnrpc.Rpc.NodeInfo> METHOD_GET_NODE_INFO = getGetNodeInfoMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.NodeInfoRequest,
      lnrpc.Rpc.NodeInfo> getGetNodeInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.NodeInfoRequest,
      lnrpc.Rpc.NodeInfo> getGetNodeInfoMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.NodeInfoRequest, lnrpc.Rpc.NodeInfo> getGetNodeInfoMethod;
    if ((getGetNodeInfoMethod = LightningGrpc.getGetNodeInfoMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getGetNodeInfoMethod = LightningGrpc.getGetNodeInfoMethod) == null) {
          LightningGrpc.getGetNodeInfoMethod = getGetNodeInfoMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.NodeInfoRequest, lnrpc.Rpc.NodeInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "GetNodeInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.NodeInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.NodeInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("GetNodeInfo"))
                  .build();
          }
        }
     }
     return getGetNodeInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getQueryRoutesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.QueryRoutesRequest,
      lnrpc.Rpc.QueryRoutesResponse> METHOD_QUERY_ROUTES = getQueryRoutesMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.QueryRoutesRequest,
      lnrpc.Rpc.QueryRoutesResponse> getQueryRoutesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.QueryRoutesRequest,
      lnrpc.Rpc.QueryRoutesResponse> getQueryRoutesMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.QueryRoutesRequest, lnrpc.Rpc.QueryRoutesResponse> getQueryRoutesMethod;
    if ((getQueryRoutesMethod = LightningGrpc.getQueryRoutesMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getQueryRoutesMethod = LightningGrpc.getQueryRoutesMethod) == null) {
          LightningGrpc.getQueryRoutesMethod = getQueryRoutesMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.QueryRoutesRequest, lnrpc.Rpc.QueryRoutesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "QueryRoutes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.QueryRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.QueryRoutesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("QueryRoutes"))
                  .build();
          }
        }
     }
     return getQueryRoutesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNetworkInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.NetworkInfoRequest,
      lnrpc.Rpc.NetworkInfo> METHOD_GET_NETWORK_INFO = getGetNetworkInfoMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.NetworkInfoRequest,
      lnrpc.Rpc.NetworkInfo> getGetNetworkInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.NetworkInfoRequest,
      lnrpc.Rpc.NetworkInfo> getGetNetworkInfoMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.NetworkInfoRequest, lnrpc.Rpc.NetworkInfo> getGetNetworkInfoMethod;
    if ((getGetNetworkInfoMethod = LightningGrpc.getGetNetworkInfoMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getGetNetworkInfoMethod = LightningGrpc.getGetNetworkInfoMethod) == null) {
          LightningGrpc.getGetNetworkInfoMethod = getGetNetworkInfoMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.NetworkInfoRequest, lnrpc.Rpc.NetworkInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "GetNetworkInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.NetworkInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.NetworkInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("GetNetworkInfo"))
                  .build();
          }
        }
     }
     return getGetNetworkInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStopDaemonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.StopRequest,
      lnrpc.Rpc.StopResponse> METHOD_STOP_DAEMON = getStopDaemonMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.StopRequest,
      lnrpc.Rpc.StopResponse> getStopDaemonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.StopRequest,
      lnrpc.Rpc.StopResponse> getStopDaemonMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.StopRequest, lnrpc.Rpc.StopResponse> getStopDaemonMethod;
    if ((getStopDaemonMethod = LightningGrpc.getStopDaemonMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getStopDaemonMethod = LightningGrpc.getStopDaemonMethod) == null) {
          LightningGrpc.getStopDaemonMethod = getStopDaemonMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.StopRequest, lnrpc.Rpc.StopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "StopDaemon"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.StopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.StopResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("StopDaemon"))
                  .build();
          }
        }
     }
     return getStopDaemonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubscribeChannelGraphMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.GraphTopologySubscription,
      lnrpc.Rpc.GraphTopologyUpdate> METHOD_SUBSCRIBE_CHANNEL_GRAPH = getSubscribeChannelGraphMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.GraphTopologySubscription,
      lnrpc.Rpc.GraphTopologyUpdate> getSubscribeChannelGraphMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.GraphTopologySubscription,
      lnrpc.Rpc.GraphTopologyUpdate> getSubscribeChannelGraphMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.GraphTopologySubscription, lnrpc.Rpc.GraphTopologyUpdate> getSubscribeChannelGraphMethod;
    if ((getSubscribeChannelGraphMethod = LightningGrpc.getSubscribeChannelGraphMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSubscribeChannelGraphMethod = LightningGrpc.getSubscribeChannelGraphMethod) == null) {
          LightningGrpc.getSubscribeChannelGraphMethod = getSubscribeChannelGraphMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.GraphTopologySubscription, lnrpc.Rpc.GraphTopologyUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SubscribeChannelGraph"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.GraphTopologySubscription.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.GraphTopologyUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SubscribeChannelGraph"))
                  .build();
          }
        }
     }
     return getSubscribeChannelGraphMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDebugLevelMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.DebugLevelRequest,
      lnrpc.Rpc.DebugLevelResponse> METHOD_DEBUG_LEVEL = getDebugLevelMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.DebugLevelRequest,
      lnrpc.Rpc.DebugLevelResponse> getDebugLevelMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.DebugLevelRequest,
      lnrpc.Rpc.DebugLevelResponse> getDebugLevelMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.DebugLevelRequest, lnrpc.Rpc.DebugLevelResponse> getDebugLevelMethod;
    if ((getDebugLevelMethod = LightningGrpc.getDebugLevelMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getDebugLevelMethod = LightningGrpc.getDebugLevelMethod) == null) {
          LightningGrpc.getDebugLevelMethod = getDebugLevelMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.DebugLevelRequest, lnrpc.Rpc.DebugLevelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "DebugLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.DebugLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.DebugLevelResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("DebugLevel"))
                  .build();
          }
        }
     }
     return getDebugLevelMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getFeeReportMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.FeeReportRequest,
      lnrpc.Rpc.FeeReportResponse> METHOD_FEE_REPORT = getFeeReportMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.FeeReportRequest,
      lnrpc.Rpc.FeeReportResponse> getFeeReportMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.FeeReportRequest,
      lnrpc.Rpc.FeeReportResponse> getFeeReportMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.FeeReportRequest, lnrpc.Rpc.FeeReportResponse> getFeeReportMethod;
    if ((getFeeReportMethod = LightningGrpc.getFeeReportMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getFeeReportMethod = LightningGrpc.getFeeReportMethod) == null) {
          LightningGrpc.getFeeReportMethod = getFeeReportMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.FeeReportRequest, lnrpc.Rpc.FeeReportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "FeeReport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.FeeReportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.FeeReportResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("FeeReport"))
                  .build();
          }
        }
     }
     return getFeeReportMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateChannelPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.PolicyUpdateRequest,
      lnrpc.Rpc.PolicyUpdateResponse> METHOD_UPDATE_CHANNEL_POLICY = getUpdateChannelPolicyMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.PolicyUpdateRequest,
      lnrpc.Rpc.PolicyUpdateResponse> getUpdateChannelPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.PolicyUpdateRequest,
      lnrpc.Rpc.PolicyUpdateResponse> getUpdateChannelPolicyMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.PolicyUpdateRequest, lnrpc.Rpc.PolicyUpdateResponse> getUpdateChannelPolicyMethod;
    if ((getUpdateChannelPolicyMethod = LightningGrpc.getUpdateChannelPolicyMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getUpdateChannelPolicyMethod = LightningGrpc.getUpdateChannelPolicyMethod) == null) {
          LightningGrpc.getUpdateChannelPolicyMethod = getUpdateChannelPolicyMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.PolicyUpdateRequest, lnrpc.Rpc.PolicyUpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "UpdateChannelPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PolicyUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.PolicyUpdateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("UpdateChannelPolicy"))
                  .build();
          }
        }
     }
     return getUpdateChannelPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getForwardingHistoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ForwardingHistoryRequest,
      lnrpc.Rpc.ForwardingHistoryResponse> METHOD_FORWARDING_HISTORY = getForwardingHistoryMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ForwardingHistoryRequest,
      lnrpc.Rpc.ForwardingHistoryResponse> getForwardingHistoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ForwardingHistoryRequest,
      lnrpc.Rpc.ForwardingHistoryResponse> getForwardingHistoryMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ForwardingHistoryRequest, lnrpc.Rpc.ForwardingHistoryResponse> getForwardingHistoryMethod;
    if ((getForwardingHistoryMethod = LightningGrpc.getForwardingHistoryMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getForwardingHistoryMethod = LightningGrpc.getForwardingHistoryMethod) == null) {
          LightningGrpc.getForwardingHistoryMethod = getForwardingHistoryMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ForwardingHistoryRequest, lnrpc.Rpc.ForwardingHistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ForwardingHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ForwardingHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ForwardingHistoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ForwardingHistory"))
                  .build();
          }
        }
     }
     return getForwardingHistoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExportChannelBackupMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ExportChannelBackupRequest,
      lnrpc.Rpc.ChannelBackup> METHOD_EXPORT_CHANNEL_BACKUP = getExportChannelBackupMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ExportChannelBackupRequest,
      lnrpc.Rpc.ChannelBackup> getExportChannelBackupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ExportChannelBackupRequest,
      lnrpc.Rpc.ChannelBackup> getExportChannelBackupMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ExportChannelBackupRequest, lnrpc.Rpc.ChannelBackup> getExportChannelBackupMethod;
    if ((getExportChannelBackupMethod = LightningGrpc.getExportChannelBackupMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getExportChannelBackupMethod = LightningGrpc.getExportChannelBackupMethod) == null) {
          LightningGrpc.getExportChannelBackupMethod = getExportChannelBackupMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ExportChannelBackupRequest, lnrpc.Rpc.ChannelBackup>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ExportChannelBackup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ExportChannelBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelBackup.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ExportChannelBackup"))
                  .build();
          }
        }
     }
     return getExportChannelBackupMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExportAllChannelBackupsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ChanBackupExportRequest,
      lnrpc.Rpc.ChanBackupSnapshot> METHOD_EXPORT_ALL_CHANNEL_BACKUPS = getExportAllChannelBackupsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ChanBackupExportRequest,
      lnrpc.Rpc.ChanBackupSnapshot> getExportAllChannelBackupsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ChanBackupExportRequest,
      lnrpc.Rpc.ChanBackupSnapshot> getExportAllChannelBackupsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ChanBackupExportRequest, lnrpc.Rpc.ChanBackupSnapshot> getExportAllChannelBackupsMethod;
    if ((getExportAllChannelBackupsMethod = LightningGrpc.getExportAllChannelBackupsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getExportAllChannelBackupsMethod = LightningGrpc.getExportAllChannelBackupsMethod) == null) {
          LightningGrpc.getExportAllChannelBackupsMethod = getExportAllChannelBackupsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ChanBackupExportRequest, lnrpc.Rpc.ChanBackupSnapshot>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ExportAllChannelBackups"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChanBackupExportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChanBackupSnapshot.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ExportAllChannelBackups"))
                  .build();
          }
        }
     }
     return getExportAllChannelBackupsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getVerifyChanBackupMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ChanBackupSnapshot,
      lnrpc.Rpc.VerifyChanBackupResponse> METHOD_VERIFY_CHAN_BACKUP = getVerifyChanBackupMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ChanBackupSnapshot,
      lnrpc.Rpc.VerifyChanBackupResponse> getVerifyChanBackupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ChanBackupSnapshot,
      lnrpc.Rpc.VerifyChanBackupResponse> getVerifyChanBackupMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ChanBackupSnapshot, lnrpc.Rpc.VerifyChanBackupResponse> getVerifyChanBackupMethod;
    if ((getVerifyChanBackupMethod = LightningGrpc.getVerifyChanBackupMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getVerifyChanBackupMethod = LightningGrpc.getVerifyChanBackupMethod) == null) {
          LightningGrpc.getVerifyChanBackupMethod = getVerifyChanBackupMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ChanBackupSnapshot, lnrpc.Rpc.VerifyChanBackupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "VerifyChanBackup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChanBackupSnapshot.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.VerifyChanBackupResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("VerifyChanBackup"))
                  .build();
          }
        }
     }
     return getVerifyChanBackupMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRestoreChannelBackupsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.RestoreChanBackupRequest,
      lnrpc.Rpc.RestoreBackupResponse> METHOD_RESTORE_CHANNEL_BACKUPS = getRestoreChannelBackupsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.RestoreChanBackupRequest,
      lnrpc.Rpc.RestoreBackupResponse> getRestoreChannelBackupsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.RestoreChanBackupRequest,
      lnrpc.Rpc.RestoreBackupResponse> getRestoreChannelBackupsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.RestoreChanBackupRequest, lnrpc.Rpc.RestoreBackupResponse> getRestoreChannelBackupsMethod;
    if ((getRestoreChannelBackupsMethod = LightningGrpc.getRestoreChannelBackupsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getRestoreChannelBackupsMethod = LightningGrpc.getRestoreChannelBackupsMethod) == null) {
          LightningGrpc.getRestoreChannelBackupsMethod = getRestoreChannelBackupsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.RestoreChanBackupRequest, lnrpc.Rpc.RestoreBackupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "RestoreChannelBackups"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.RestoreChanBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.RestoreBackupResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("RestoreChannelBackups"))
                  .build();
          }
        }
     }
     return getRestoreChannelBackupsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubscribeChannelBackupsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelBackupSubscription,
      lnrpc.Rpc.ChanBackupSnapshot> METHOD_SUBSCRIBE_CHANNEL_BACKUPS = getSubscribeChannelBackupsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelBackupSubscription,
      lnrpc.Rpc.ChanBackupSnapshot> getSubscribeChannelBackupsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelBackupSubscription,
      lnrpc.Rpc.ChanBackupSnapshot> getSubscribeChannelBackupsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ChannelBackupSubscription, lnrpc.Rpc.ChanBackupSnapshot> getSubscribeChannelBackupsMethod;
    if ((getSubscribeChannelBackupsMethod = LightningGrpc.getSubscribeChannelBackupsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getSubscribeChannelBackupsMethod = LightningGrpc.getSubscribeChannelBackupsMethod) == null) {
          LightningGrpc.getSubscribeChannelBackupsMethod = getSubscribeChannelBackupsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ChannelBackupSubscription, lnrpc.Rpc.ChanBackupSnapshot>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "SubscribeChannelBackups"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChannelBackupSubscription.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ChanBackupSnapshot.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("SubscribeChannelBackups"))
                  .build();
          }
        }
     }
     return getSubscribeChannelBackupsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBakeMacaroonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.BakeMacaroonRequest,
      lnrpc.Rpc.BakeMacaroonResponse> METHOD_BAKE_MACAROON = getBakeMacaroonMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.BakeMacaroonRequest,
      lnrpc.Rpc.BakeMacaroonResponse> getBakeMacaroonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.BakeMacaroonRequest,
      lnrpc.Rpc.BakeMacaroonResponse> getBakeMacaroonMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.BakeMacaroonRequest, lnrpc.Rpc.BakeMacaroonResponse> getBakeMacaroonMethod;
    if ((getBakeMacaroonMethod = LightningGrpc.getBakeMacaroonMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getBakeMacaroonMethod = LightningGrpc.getBakeMacaroonMethod) == null) {
          LightningGrpc.getBakeMacaroonMethod = getBakeMacaroonMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.BakeMacaroonRequest, lnrpc.Rpc.BakeMacaroonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "BakeMacaroon"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.BakeMacaroonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.BakeMacaroonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("BakeMacaroon"))
                  .build();
          }
        }
     }
     return getBakeMacaroonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListMacaroonIDsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ListMacaroonIDsRequest,
      lnrpc.Rpc.ListMacaroonIDsResponse> METHOD_LIST_MACAROON_IDS = getListMacaroonIDsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ListMacaroonIDsRequest,
      lnrpc.Rpc.ListMacaroonIDsResponse> getListMacaroonIDsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ListMacaroonIDsRequest,
      lnrpc.Rpc.ListMacaroonIDsResponse> getListMacaroonIDsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ListMacaroonIDsRequest, lnrpc.Rpc.ListMacaroonIDsResponse> getListMacaroonIDsMethod;
    if ((getListMacaroonIDsMethod = LightningGrpc.getListMacaroonIDsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getListMacaroonIDsMethod = LightningGrpc.getListMacaroonIDsMethod) == null) {
          LightningGrpc.getListMacaroonIDsMethod = getListMacaroonIDsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ListMacaroonIDsRequest, lnrpc.Rpc.ListMacaroonIDsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ListMacaroonIDs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListMacaroonIDsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListMacaroonIDsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ListMacaroonIDs"))
                  .build();
          }
        }
     }
     return getListMacaroonIDsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteMacaroonIDMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.DeleteMacaroonIDRequest,
      lnrpc.Rpc.DeleteMacaroonIDResponse> METHOD_DELETE_MACAROON_ID = getDeleteMacaroonIDMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.DeleteMacaroonIDRequest,
      lnrpc.Rpc.DeleteMacaroonIDResponse> getDeleteMacaroonIDMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.DeleteMacaroonIDRequest,
      lnrpc.Rpc.DeleteMacaroonIDResponse> getDeleteMacaroonIDMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.DeleteMacaroonIDRequest, lnrpc.Rpc.DeleteMacaroonIDResponse> getDeleteMacaroonIDMethod;
    if ((getDeleteMacaroonIDMethod = LightningGrpc.getDeleteMacaroonIDMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getDeleteMacaroonIDMethod = LightningGrpc.getDeleteMacaroonIDMethod) == null) {
          LightningGrpc.getDeleteMacaroonIDMethod = getDeleteMacaroonIDMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.DeleteMacaroonIDRequest, lnrpc.Rpc.DeleteMacaroonIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "DeleteMacaroonID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.DeleteMacaroonIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.DeleteMacaroonIDResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("DeleteMacaroonID"))
                  .build();
          }
        }
     }
     return getDeleteMacaroonIDMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListPermissionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<lnrpc.Rpc.ListPermissionsRequest,
      lnrpc.Rpc.ListPermissionsResponse> METHOD_LIST_PERMISSIONS = getListPermissionsMethod();

  private static volatile io.grpc.MethodDescriptor<lnrpc.Rpc.ListPermissionsRequest,
      lnrpc.Rpc.ListPermissionsResponse> getListPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<lnrpc.Rpc.ListPermissionsRequest,
      lnrpc.Rpc.ListPermissionsResponse> getListPermissionsMethod() {
    io.grpc.MethodDescriptor<lnrpc.Rpc.ListPermissionsRequest, lnrpc.Rpc.ListPermissionsResponse> getListPermissionsMethod;
    if ((getListPermissionsMethod = LightningGrpc.getListPermissionsMethod) == null) {
      synchronized (LightningGrpc.class) {
        if ((getListPermissionsMethod = LightningGrpc.getListPermissionsMethod) == null) {
          LightningGrpc.getListPermissionsMethod = getListPermissionsMethod = 
              io.grpc.MethodDescriptor.<lnrpc.Rpc.ListPermissionsRequest, lnrpc.Rpc.ListPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lnrpc.Lightning", "ListPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lnrpc.Rpc.ListPermissionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightningMethodDescriptorSupplier("ListPermissions"))
                  .build();
          }
        }
     }
     return getListPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightningStub newStub(io.grpc.Channel channel) {
    return new LightningStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightningBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightningBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightningFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightningFutureStub(channel);
  }

  /**
   * <pre>
   * Lightning is the main RPC server of the daemon.
   * </pre>
   */
  public static abstract class LightningImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * lncli: `walletbalance`
     *WalletBalance returns total unspent outputs(confirmed and unconfirmed), all
     *confirmed unspent outputs and all unconfirmed unspent outputs under control
     *of the wallet.
     * </pre>
     */
    public void walletBalance(lnrpc.Rpc.WalletBalanceRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.WalletBalanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWalletBalanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `channelbalance`
     *ChannelBalance returns a report on the total funds across all open channels,
     *categorized in local/remote, pending local/remote and unsettled local/remote
     *balances.
     * </pre>
     */
    public void channelBalance(lnrpc.Rpc.ChannelBalanceRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelBalanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChannelBalanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `listchaintxns`
     *GetTransactions returns a list describing all the known transactions
     *relevant to the wallet.
     * </pre>
     */
    public void getTransactions(lnrpc.Rpc.GetTransactionsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.TransactionDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `estimatefee`
     *EstimateFee asks the chain backend to estimate the fee rate and total fees
     *for a transaction that pays to multiple specified outputs.
     *When using REST, the `AddrToAmount` map type can be set by appending
     *`&amp;AddrToAmount[&lt;address&gt;]=&lt;amount_to_send&gt;` to the URL. Unfortunately this
     *map type doesn't appear in the REST API documentation because of a bug in
     *the grpc-gateway library.
     * </pre>
     */
    public void estimateFee(lnrpc.Rpc.EstimateFeeRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.EstimateFeeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEstimateFeeMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `sendcoins`
     *SendCoins executes a request to send coins to a particular address. Unlike
     *SendMany, this RPC call only allows creating a single output at a time. If
     *neither target_conf, or sat_per_vbyte are set, then the internal wallet will
     *consult its fee model to determine a fee for the default confirmation
     *target.
     * </pre>
     */
    public void sendCoins(lnrpc.Rpc.SendCoinsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendCoinsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendCoinsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `listunspent`
     *Deprecated, use walletrpc.ListUnspent instead.
     *ListUnspent returns a list of all utxos spendable by the wallet with a
     *number of confirmations between the specified minimum and maximum.
     * </pre>
     */
    public void listUnspent(lnrpc.Rpc.ListUnspentRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListUnspentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListUnspentMethod(), responseObserver);
    }

    /**
     * <pre>
     *SubscribeTransactions creates a uni-directional stream from the server to
     *the client in which any newly discovered transactions relevant to the
     *wallet are sent over.
     * </pre>
     */
    public void subscribeTransactions(lnrpc.Rpc.GetTransactionsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.Transaction> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeTransactionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `sendmany`
     *SendMany handles a request for a transaction that creates multiple specified
     *outputs in parallel. If neither target_conf, or sat_per_vbyte are set, then
     *the internal wallet will consult its fee model to determine a fee for the
     *default confirmation target.
     * </pre>
     */
    public void sendMany(lnrpc.Rpc.SendManyRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendManyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendManyMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `newaddress`
     *NewAddress creates a new address under control of the local wallet.
     * </pre>
     */
    public void newAddress(lnrpc.Rpc.NewAddressRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.NewAddressResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getNewAddressMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `signmessage`
     *SignMessage signs a message with this node's private key. The returned
     *signature string is `zbase32` encoded and pubkey recoverable, meaning that
     *only the message digest and signature are needed for verification.
     * </pre>
     */
    public void signMessage(lnrpc.Rpc.SignMessageRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SignMessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSignMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `verifymessage`
     *VerifyMessage verifies a signature over a msg. The signature must be
     *zbase32 encoded and signed by an active node in the resident node's
     *channel database. In addition to returning the validity of the signature,
     *VerifyMessage also returns the recovered pubkey from the signature.
     * </pre>
     */
    public void verifyMessage(lnrpc.Rpc.VerifyMessageRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.VerifyMessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getVerifyMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `connect`
     *ConnectPeer attempts to establish a connection to a remote peer. This is at
     *the networking level, and is used for communication between nodes. This is
     *distinct from establishing a channel with a peer.
     * </pre>
     */
    public void connectPeer(lnrpc.Rpc.ConnectPeerRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ConnectPeerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getConnectPeerMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `disconnect`
     *DisconnectPeer attempts to disconnect one peer from another identified by a
     *given pubKey. In the case that we currently have a pending or active channel
     *with the target peer, then this action will be not be allowed.
     * </pre>
     */
    public void disconnectPeer(lnrpc.Rpc.DisconnectPeerRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.DisconnectPeerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDisconnectPeerMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `listpeers`
     *ListPeers returns a verbose listing of all currently active peers.
     * </pre>
     */
    public void listPeers(lnrpc.Rpc.ListPeersRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPeersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListPeersMethod(), responseObserver);
    }

    /**
     * <pre>
     *SubscribePeerEvents creates a uni-directional stream from the server to
     *the client in which any events relevant to the state of peers are sent
     *over. Events include peers going online and offline.
     * </pre>
     */
    public void subscribePeerEvents(lnrpc.Rpc.PeerEventSubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.PeerEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribePeerEventsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `getinfo`
     *GetInfo returns general information concerning the lightning node including
     *it's identity pubkey, alias, the chains it is connected to, and information
     *concerning the number of open+pending channels.
     * </pre>
     */
    public void getInfo(lnrpc.Rpc.GetInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.GetInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     ** lncli: `getrecoveryinfo`
     *GetRecoveryInfo returns information concerning the recovery mode including
     *whether it's in a recovery mode, whether the recovery is finished, and the
     *progress made so far.
     * </pre>
     */
    public void getRecoveryInfo(lnrpc.Rpc.GetRecoveryInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.GetRecoveryInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRecoveryInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `pendingchannels`
     *PendingChannels returns a list of all the channels that are currently
     *considered "pending". A channel is pending if it has finished the funding
     *workflow and is waiting for confirmations for the funding txn, or is in the
     *process of closure, either initiated cooperatively or non-cooperatively.
     * </pre>
     */
    public void pendingChannels(lnrpc.Rpc.PendingChannelsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.PendingChannelsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPendingChannelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `listchannels`
     *ListChannels returns a description of all the open channels that this node
     *is a participant in.
     * </pre>
     */
    public void listChannels(lnrpc.Rpc.ListChannelsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListChannelsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListChannelsMethod(), responseObserver);
    }

    /**
     * <pre>
     *SubscribeChannelEvents creates a uni-directional stream from the server to
     *the client in which any updates relevant to the state of the channels are
     *sent over. Events include new active channels, inactive channels, and closed
     *channels.
     * </pre>
     */
    public void subscribeChannelEvents(lnrpc.Rpc.ChannelEventSubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelEventUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeChannelEventsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `closedchannels`
     *ClosedChannels returns a description of all the closed channels that
     *this node was a participant in.
     * </pre>
     */
    public void closedChannels(lnrpc.Rpc.ClosedChannelsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ClosedChannelsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getClosedChannelsMethod(), responseObserver);
    }

    /**
     * <pre>
     *OpenChannelSync is a synchronous version of the OpenChannel RPC call. This
     *call is meant to be consumed by clients to the REST proxy. As with all
     *other sync calls, all byte slices are intended to be populated as hex
     *encoded strings.
     * </pre>
     */
    public void openChannelSync(lnrpc.Rpc.OpenChannelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelPoint> responseObserver) {
      asyncUnimplementedUnaryCall(getOpenChannelSyncMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `openchannel`
     *OpenChannel attempts to open a singly funded channel specified in the
     *request to a remote peer. Users are able to specify a target number of
     *blocks that the funding transaction should be confirmed in, or a manual fee
     *rate to us for the funding transaction. If neither are specified, then a
     *lax block confirmation target is used. Each OpenStatusUpdate will return
     *the pending channel ID of the in-progress channel. Depending on the
     *arguments specified in the OpenChannelRequest, this pending channel ID can
     *then be used to manually progress the channel funding flow.
     * </pre>
     */
    public void openChannel(lnrpc.Rpc.OpenChannelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.OpenStatusUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getOpenChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     *FundingStateStep is an advanced funding related call that allows the caller
     *to either execute some preparatory steps for a funding workflow, or
     *manually progress a funding workflow. The primary way a funding flow is
     *identified is via its pending channel ID. As an example, this method can be
     *used to specify that we're expecting a funding flow for a particular
     *pending channel ID, for which we need to use specific parameters.
     *Alternatively, this can be used to interactively drive PSBT signing for
     *funding for partially complete funding transactions.
     * </pre>
     */
    public void fundingStateStep(lnrpc.Rpc.FundingTransitionMsg request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.FundingStateStepResp> responseObserver) {
      asyncUnimplementedUnaryCall(getFundingStateStepMethod(), responseObserver);
    }

    /**
     * <pre>
     *ChannelAcceptor dispatches a bi-directional streaming RPC in which
     *OpenChannel requests are sent to the client and the client responds with
     *a boolean that tells LND whether or not to accept the channel. This allows
     *node operators to specify their own criteria for accepting inbound channels
     *through a single persistent connection.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelAcceptResponse> channelAcceptor(
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelAcceptRequest> responseObserver) {
      return asyncUnimplementedStreamingCall(getChannelAcceptorMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `closechannel`
     *CloseChannel attempts to close an active channel identified by its channel
     *outpoint (ChannelPoint). The actions of this method can additionally be
     *augmented to attempt a force close after a timeout period in the case of an
     *inactive peer. If a non-force close (cooperative closure) is requested,
     *then the user can specify either a target number of blocks until the
     *closure transaction is confirmed, or a manual fee rate. If neither are
     *specified, then a default lax, block confirmation target is used.
     * </pre>
     */
    public void closeChannel(lnrpc.Rpc.CloseChannelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.CloseStatusUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getCloseChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `abandonchannel`
     *AbandonChannel removes all channel state from the database except for a
     *close summary. This method can be used to get rid of permanently unusable
     *channels due to bugs fixed in newer versions of lnd. This method can also be
     *used to remove externally funded channels where the funding transaction was
     *never broadcast. Only available for non-externally funded channels in dev
     *build.
     * </pre>
     */
    public void abandonChannel(lnrpc.Rpc.AbandonChannelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.AbandonChannelResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAbandonChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `sendpayment`
     *Deprecated, use routerrpc.SendPaymentV2. SendPayment dispatches a
     *bi-directional streaming RPC for sending payments through the Lightning
     *Network. A single RPC invocation creates a persistent bi-directional
     *stream allowing clients to rapidly send payments through the Lightning
     *Network with a single persistent connection.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lnrpc.Rpc.SendRequest> sendPayment(
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendPaymentMethod(), responseObserver);
    }

    /**
     * <pre>
     *SendPaymentSync is the synchronous non-streaming version of SendPayment.
     *This RPC is intended to be consumed by clients of the REST proxy.
     *Additionally, this RPC expects the destination's public key and the payment
     *hash (if any) to be encoded as hex strings.
     * </pre>
     */
    public void sendPaymentSync(lnrpc.Rpc.SendRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendPaymentSyncMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `sendtoroute`
     *Deprecated, use routerrpc.SendToRouteV2. SendToRoute is a bi-directional
     *streaming RPC for sending payment through the Lightning Network. This
     *method differs from SendPayment in that it allows users to specify a full
     *route manually. This can be used for things like rebalancing, and atomic
     *swaps.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lnrpc.Rpc.SendToRouteRequest> sendToRoute(
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendToRouteMethod(), responseObserver);
    }

    /**
     * <pre>
     *SendToRouteSync is a synchronous version of SendToRoute. It Will block
     *until the payment either fails or succeeds.
     * </pre>
     */
    public void sendToRouteSync(lnrpc.Rpc.SendToRouteRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendToRouteSyncMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `addinvoice`
     *AddInvoice attempts to add a new invoice to the invoice database. Any
     *duplicated invoices are rejected, therefore all invoices *must* have a
     *unique payment preimage.
     * </pre>
     */
    public void addInvoice(lnrpc.Rpc.Invoice request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.AddInvoiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddInvoiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `listinvoices`
     *ListInvoices returns a list of all the invoices currently stored within the
     *database. Any active debug invoices are ignored. It has full support for
     *paginated responses, allowing users to query for specific invoices through
     *their add_index. This can be done by using either the first_index_offset or
     *last_index_offset fields included in the response as the index_offset of the
     *next request. By default, the first 100 invoices created will be returned.
     *Backwards pagination is also supported through the Reversed flag.
     * </pre>
     */
    public void listInvoices(lnrpc.Rpc.ListInvoiceRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListInvoiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListInvoicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `lookupinvoice`
     *LookupInvoice attempts to look up an invoice according to its payment hash.
     *The passed payment hash *must* be exactly 32 bytes, if not, an error is
     *returned.
     * </pre>
     */
    public void lookupInvoice(lnrpc.Rpc.PaymentHash request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.Invoice> responseObserver) {
      asyncUnimplementedUnaryCall(getLookupInvoiceMethod(), responseObserver);
    }

    /**
     * <pre>
     *SubscribeInvoices returns a uni-directional stream (server -&gt; client) for
     *notifying the client of newly added/settled invoices. The caller can
     *optionally specify the add_index and/or the settle_index. If the add_index
     *is specified, then we'll first start by sending add invoice events for all
     *invoices with an add_index greater than the specified value. If the
     *settle_index is specified, the next, we'll send out all settle events for
     *invoices with a settle_index greater than the specified value. One or both
     *of these fields can be set. If no fields are set, then we'll only send out
     *the latest add/settle events.
     * </pre>
     */
    public void subscribeInvoices(lnrpc.Rpc.InvoiceSubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.Invoice> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeInvoicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `decodepayreq`
     *DecodePayReq takes an encoded payment request string and attempts to decode
     *it, returning a full description of the conditions encoded within the
     *payment request.
     * </pre>
     */
    public void decodePayReq(lnrpc.Rpc.PayReqString request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.PayReq> responseObserver) {
      asyncUnimplementedUnaryCall(getDecodePayReqMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `listpayments`
     *ListPayments returns a list of all outgoing payments.
     * </pre>
     */
    public void listPayments(lnrpc.Rpc.ListPaymentsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPaymentsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListPaymentsMethod(), responseObserver);
    }

    /**
     * <pre>
     *DeleteAllPayments deletes all outgoing payments from DB.
     * </pre>
     */
    public void deleteAllPayments(lnrpc.Rpc.DeleteAllPaymentsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.DeleteAllPaymentsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAllPaymentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `describegraph`
     *DescribeGraph returns a description of the latest graph state from the
     *point of view of the node. The graph information is partitioned into two
     *components: all the nodes/vertexes, and all the edges that connect the
     *vertexes themselves. As this is a directed graph, the edges also contain
     *the node directional specific routing policy which includes: the time lock
     *delta, fee information, etc.
     * </pre>
     */
    public void describeGraph(lnrpc.Rpc.ChannelGraphRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelGraph> responseObserver) {
      asyncUnimplementedUnaryCall(getDescribeGraphMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `getnodemetrics`
     *GetNodeMetrics returns node metrics calculated from the graph. Currently
     *the only supported metric is betweenness centrality of individual nodes.
     * </pre>
     */
    public void getNodeMetrics(lnrpc.Rpc.NodeMetricsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.NodeMetricsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNodeMetricsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `getchaninfo`
     *GetChanInfo returns the latest authenticated network announcement for the
     *given channel identified by its channel ID: an 8-byte integer which
     *uniquely identifies the location of transaction's funding output within the
     *blockchain.
     * </pre>
     */
    public void getChanInfo(lnrpc.Rpc.ChanInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelEdge> responseObserver) {
      asyncUnimplementedUnaryCall(getGetChanInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `getnodeinfo`
     *GetNodeInfo returns the latest advertised, aggregated, and authenticated
     *channel information for the specified node identified by its public key.
     * </pre>
     */
    public void getNodeInfo(lnrpc.Rpc.NodeInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.NodeInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNodeInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `queryroutes`
     *QueryRoutes attempts to query the daemon's Channel Router for a possible
     *route to a target destination capable of carrying a specific amount of
     *satoshis. The returned route contains the full details required to craft and
     *send an HTLC, also including the necessary information that should be
     *present within the Sphinx packet encapsulated within the HTLC.
     *When using REST, the `dest_custom_records` map type can be set by appending
     *`&amp;dest_custom_records[&lt;record_number&gt;]=&lt;record_data_base64_url_encoded&gt;`
     *to the URL. Unfortunately this map type doesn't appear in the REST API
     *documentation because of a bug in the grpc-gateway library.
     * </pre>
     */
    public void queryRoutes(lnrpc.Rpc.QueryRoutesRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.QueryRoutesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryRoutesMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `getnetworkinfo`
     *GetNetworkInfo returns some basic stats about the known channel graph from
     *the point of view of the node.
     * </pre>
     */
    public void getNetworkInfo(lnrpc.Rpc.NetworkInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.NetworkInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNetworkInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `stop`
     *StopDaemon will send a shutdown request to the interrupt handler, triggering
     *a graceful shutdown of the daemon.
     * </pre>
     */
    public void stopDaemon(lnrpc.Rpc.StopRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.StopResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStopDaemonMethod(), responseObserver);
    }

    /**
     * <pre>
     *SubscribeChannelGraph launches a streaming RPC that allows the caller to
     *receive notifications upon any changes to the channel graph topology from
     *the point of view of the responding node. Events notified include: new
     *nodes coming online, nodes updating their authenticated attributes, new
     *channels being advertised, updates in the routing policy for a directional
     *channel edge, and when channels are closed on-chain.
     * </pre>
     */
    public void subscribeChannelGraph(lnrpc.Rpc.GraphTopologySubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.GraphTopologyUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeChannelGraphMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `debuglevel`
     *DebugLevel allows a caller to programmatically set the logging verbosity of
     *lnd. The logging can be targeted according to a coarse daemon-wide logging
     *level, or in a granular fashion to specify the logging for a target
     *sub-system.
     * </pre>
     */
    public void debugLevel(lnrpc.Rpc.DebugLevelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.DebugLevelResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDebugLevelMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `feereport`
     *FeeReport allows the caller to obtain a report detailing the current fee
     *schedule enforced by the node globally for each channel.
     * </pre>
     */
    public void feeReport(lnrpc.Rpc.FeeReportRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.FeeReportResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFeeReportMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `updatechanpolicy`
     *UpdateChannelPolicy allows the caller to update the fee schedule and
     *channel policies for all channels globally, or a particular channel.
     * </pre>
     */
    public void updateChannelPolicy(lnrpc.Rpc.PolicyUpdateRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.PolicyUpdateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateChannelPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `fwdinghistory`
     *ForwardingHistory allows the caller to query the htlcswitch for a record of
     *all HTLCs forwarded within the target time range, and integer offset
     *within that time range, for a maximum number of events. If no maximum number
     *of events is specified, up to 100 events will be returned. If no time-range
     *is specified, then events will be returned in the order that they occured.
     *A list of forwarding events are returned. The size of each forwarding event
     *is 40 bytes, and the max message size able to be returned in gRPC is 4 MiB.
     *As a result each message can only contain 50k entries. Each response has
     *the index offset of the last entry. The index offset can be provided to the
     *request to allow the caller to skip a series of records.
     * </pre>
     */
    public void forwardingHistory(lnrpc.Rpc.ForwardingHistoryRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ForwardingHistoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getForwardingHistoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `exportchanbackup`
     *ExportChannelBackup attempts to return an encrypted static channel backup
     *for the target channel identified by it channel point. The backup is
     *encrypted with a key generated from the aezeed seed of the user. The
     *returned backup can either be restored using the RestoreChannelBackup
     *method once lnd is running, or via the InitWallet and UnlockWallet methods
     *from the WalletUnlocker service.
     * </pre>
     */
    public void exportChannelBackup(lnrpc.Rpc.ExportChannelBackupRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelBackup> responseObserver) {
      asyncUnimplementedUnaryCall(getExportChannelBackupMethod(), responseObserver);
    }

    /**
     * <pre>
     *ExportAllChannelBackups returns static channel backups for all existing
     *channels known to lnd. A set of regular singular static channel backups for
     *each channel are returned. Additionally, a multi-channel backup is returned
     *as well, which contains a single encrypted blob containing the backups of
     *each channel.
     * </pre>
     */
    public void exportAllChannelBackups(lnrpc.Rpc.ChanBackupExportRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChanBackupSnapshot> responseObserver) {
      asyncUnimplementedUnaryCall(getExportAllChannelBackupsMethod(), responseObserver);
    }

    /**
     * <pre>
     *VerifyChanBackup allows a caller to verify the integrity of a channel backup
     *snapshot. This method will accept either a packed Single or a packed Multi.
     *Specifying both will result in an error.
     * </pre>
     */
    public void verifyChanBackup(lnrpc.Rpc.ChanBackupSnapshot request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.VerifyChanBackupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getVerifyChanBackupMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `restorechanbackup`
     *RestoreChannelBackups accepts a set of singular channel backups, or a
     *single encrypted multi-chan backup and attempts to recover any funds
     *remaining within the channel. If we are able to unpack the backup, then the
     *new channel will be shown under listchannels, as well as pending channels.
     * </pre>
     */
    public void restoreChannelBackups(lnrpc.Rpc.RestoreChanBackupRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.RestoreBackupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRestoreChannelBackupsMethod(), responseObserver);
    }

    /**
     * <pre>
     *SubscribeChannelBackups allows a client to sub-subscribe to the most up to
     *date information concerning the state of all channel backups. Each time a
     *new channel is added, we return the new set of channels, along with a
     *multi-chan backup containing the backup info for all channels. Each time a
     *channel is closed, we send a new update, which contains new new chan back
     *ups, but the updated set of encrypted multi-chan backups with the closed
     *channel(s) removed.
     * </pre>
     */
    public void subscribeChannelBackups(lnrpc.Rpc.ChannelBackupSubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChanBackupSnapshot> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeChannelBackupsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `bakemacaroon`
     *BakeMacaroon allows the creation of a new macaroon with custom read and
     *write permissions. No first-party caveats are added since this can be done
     *offline.
     * </pre>
     */
    public void bakeMacaroon(lnrpc.Rpc.BakeMacaroonRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.BakeMacaroonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBakeMacaroonMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `listmacaroonids`
     *ListMacaroonIDs returns all root key IDs that are in use.
     * </pre>
     */
    public void listMacaroonIDs(lnrpc.Rpc.ListMacaroonIDsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListMacaroonIDsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListMacaroonIDsMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `deletemacaroonid`
     *DeleteMacaroonID deletes the specified macaroon ID and invalidates all
     *macaroons derived from that ID.
     * </pre>
     */
    public void deleteMacaroonID(lnrpc.Rpc.DeleteMacaroonIDRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.DeleteMacaroonIDResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMacaroonIDMethod(), responseObserver);
    }

    /**
     * <pre>
     * lncli: `listpermissions`
     *ListPermissions lists all RPC method URIs and their required macaroon
     *permissions to access them.
     * </pre>
     */
    public void listPermissions(lnrpc.Rpc.ListPermissionsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListPermissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWalletBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.WalletBalanceRequest,
                lnrpc.Rpc.WalletBalanceResponse>(
                  this, METHODID_WALLET_BALANCE)))
          .addMethod(
            getChannelBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ChannelBalanceRequest,
                lnrpc.Rpc.ChannelBalanceResponse>(
                  this, METHODID_CHANNEL_BALANCE)))
          .addMethod(
            getGetTransactionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.GetTransactionsRequest,
                lnrpc.Rpc.TransactionDetails>(
                  this, METHODID_GET_TRANSACTIONS)))
          .addMethod(
            getEstimateFeeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.EstimateFeeRequest,
                lnrpc.Rpc.EstimateFeeResponse>(
                  this, METHODID_ESTIMATE_FEE)))
          .addMethod(
            getSendCoinsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.SendCoinsRequest,
                lnrpc.Rpc.SendCoinsResponse>(
                  this, METHODID_SEND_COINS)))
          .addMethod(
            getListUnspentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ListUnspentRequest,
                lnrpc.Rpc.ListUnspentResponse>(
                  this, METHODID_LIST_UNSPENT)))
          .addMethod(
            getSubscribeTransactionsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.GetTransactionsRequest,
                lnrpc.Rpc.Transaction>(
                  this, METHODID_SUBSCRIBE_TRANSACTIONS)))
          .addMethod(
            getSendManyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.SendManyRequest,
                lnrpc.Rpc.SendManyResponse>(
                  this, METHODID_SEND_MANY)))
          .addMethod(
            getNewAddressMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.NewAddressRequest,
                lnrpc.Rpc.NewAddressResponse>(
                  this, METHODID_NEW_ADDRESS)))
          .addMethod(
            getSignMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.SignMessageRequest,
                lnrpc.Rpc.SignMessageResponse>(
                  this, METHODID_SIGN_MESSAGE)))
          .addMethod(
            getVerifyMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.VerifyMessageRequest,
                lnrpc.Rpc.VerifyMessageResponse>(
                  this, METHODID_VERIFY_MESSAGE)))
          .addMethod(
            getConnectPeerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ConnectPeerRequest,
                lnrpc.Rpc.ConnectPeerResponse>(
                  this, METHODID_CONNECT_PEER)))
          .addMethod(
            getDisconnectPeerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.DisconnectPeerRequest,
                lnrpc.Rpc.DisconnectPeerResponse>(
                  this, METHODID_DISCONNECT_PEER)))
          .addMethod(
            getListPeersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ListPeersRequest,
                lnrpc.Rpc.ListPeersResponse>(
                  this, METHODID_LIST_PEERS)))
          .addMethod(
            getSubscribePeerEventsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.PeerEventSubscription,
                lnrpc.Rpc.PeerEvent>(
                  this, METHODID_SUBSCRIBE_PEER_EVENTS)))
          .addMethod(
            getGetInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.GetInfoRequest,
                lnrpc.Rpc.GetInfoResponse>(
                  this, METHODID_GET_INFO)))
          .addMethod(
            getGetRecoveryInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.GetRecoveryInfoRequest,
                lnrpc.Rpc.GetRecoveryInfoResponse>(
                  this, METHODID_GET_RECOVERY_INFO)))
          .addMethod(
            getPendingChannelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.PendingChannelsRequest,
                lnrpc.Rpc.PendingChannelsResponse>(
                  this, METHODID_PENDING_CHANNELS)))
          .addMethod(
            getListChannelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ListChannelsRequest,
                lnrpc.Rpc.ListChannelsResponse>(
                  this, METHODID_LIST_CHANNELS)))
          .addMethod(
            getSubscribeChannelEventsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.ChannelEventSubscription,
                lnrpc.Rpc.ChannelEventUpdate>(
                  this, METHODID_SUBSCRIBE_CHANNEL_EVENTS)))
          .addMethod(
            getClosedChannelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ClosedChannelsRequest,
                lnrpc.Rpc.ClosedChannelsResponse>(
                  this, METHODID_CLOSED_CHANNELS)))
          .addMethod(
            getOpenChannelSyncMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.OpenChannelRequest,
                lnrpc.Rpc.ChannelPoint>(
                  this, METHODID_OPEN_CHANNEL_SYNC)))
          .addMethod(
            getOpenChannelMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.OpenChannelRequest,
                lnrpc.Rpc.OpenStatusUpdate>(
                  this, METHODID_OPEN_CHANNEL)))
          .addMethod(
            getFundingStateStepMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.FundingTransitionMsg,
                lnrpc.Rpc.FundingStateStepResp>(
                  this, METHODID_FUNDING_STATE_STEP)))
          .addMethod(
            getChannelAcceptorMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.ChannelAcceptResponse,
                lnrpc.Rpc.ChannelAcceptRequest>(
                  this, METHODID_CHANNEL_ACCEPTOR)))
          .addMethod(
            getCloseChannelMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.CloseChannelRequest,
                lnrpc.Rpc.CloseStatusUpdate>(
                  this, METHODID_CLOSE_CHANNEL)))
          .addMethod(
            getAbandonChannelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.AbandonChannelRequest,
                lnrpc.Rpc.AbandonChannelResponse>(
                  this, METHODID_ABANDON_CHANNEL)))
          .addMethod(
            getSendPaymentMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.SendRequest,
                lnrpc.Rpc.SendResponse>(
                  this, METHODID_SEND_PAYMENT)))
          .addMethod(
            getSendPaymentSyncMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.SendRequest,
                lnrpc.Rpc.SendResponse>(
                  this, METHODID_SEND_PAYMENT_SYNC)))
          .addMethod(
            getSendToRouteMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.SendToRouteRequest,
                lnrpc.Rpc.SendResponse>(
                  this, METHODID_SEND_TO_ROUTE)))
          .addMethod(
            getSendToRouteSyncMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.SendToRouteRequest,
                lnrpc.Rpc.SendResponse>(
                  this, METHODID_SEND_TO_ROUTE_SYNC)))
          .addMethod(
            getAddInvoiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.Invoice,
                lnrpc.Rpc.AddInvoiceResponse>(
                  this, METHODID_ADD_INVOICE)))
          .addMethod(
            getListInvoicesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ListInvoiceRequest,
                lnrpc.Rpc.ListInvoiceResponse>(
                  this, METHODID_LIST_INVOICES)))
          .addMethod(
            getLookupInvoiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.PaymentHash,
                lnrpc.Rpc.Invoice>(
                  this, METHODID_LOOKUP_INVOICE)))
          .addMethod(
            getSubscribeInvoicesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.InvoiceSubscription,
                lnrpc.Rpc.Invoice>(
                  this, METHODID_SUBSCRIBE_INVOICES)))
          .addMethod(
            getDecodePayReqMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.PayReqString,
                lnrpc.Rpc.PayReq>(
                  this, METHODID_DECODE_PAY_REQ)))
          .addMethod(
            getListPaymentsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ListPaymentsRequest,
                lnrpc.Rpc.ListPaymentsResponse>(
                  this, METHODID_LIST_PAYMENTS)))
          .addMethod(
            getDeleteAllPaymentsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.DeleteAllPaymentsRequest,
                lnrpc.Rpc.DeleteAllPaymentsResponse>(
                  this, METHODID_DELETE_ALL_PAYMENTS)))
          .addMethod(
            getDescribeGraphMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ChannelGraphRequest,
                lnrpc.Rpc.ChannelGraph>(
                  this, METHODID_DESCRIBE_GRAPH)))
          .addMethod(
            getGetNodeMetricsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.NodeMetricsRequest,
                lnrpc.Rpc.NodeMetricsResponse>(
                  this, METHODID_GET_NODE_METRICS)))
          .addMethod(
            getGetChanInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ChanInfoRequest,
                lnrpc.Rpc.ChannelEdge>(
                  this, METHODID_GET_CHAN_INFO)))
          .addMethod(
            getGetNodeInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.NodeInfoRequest,
                lnrpc.Rpc.NodeInfo>(
                  this, METHODID_GET_NODE_INFO)))
          .addMethod(
            getQueryRoutesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.QueryRoutesRequest,
                lnrpc.Rpc.QueryRoutesResponse>(
                  this, METHODID_QUERY_ROUTES)))
          .addMethod(
            getGetNetworkInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.NetworkInfoRequest,
                lnrpc.Rpc.NetworkInfo>(
                  this, METHODID_GET_NETWORK_INFO)))
          .addMethod(
            getStopDaemonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.StopRequest,
                lnrpc.Rpc.StopResponse>(
                  this, METHODID_STOP_DAEMON)))
          .addMethod(
            getSubscribeChannelGraphMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.GraphTopologySubscription,
                lnrpc.Rpc.GraphTopologyUpdate>(
                  this, METHODID_SUBSCRIBE_CHANNEL_GRAPH)))
          .addMethod(
            getDebugLevelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.DebugLevelRequest,
                lnrpc.Rpc.DebugLevelResponse>(
                  this, METHODID_DEBUG_LEVEL)))
          .addMethod(
            getFeeReportMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.FeeReportRequest,
                lnrpc.Rpc.FeeReportResponse>(
                  this, METHODID_FEE_REPORT)))
          .addMethod(
            getUpdateChannelPolicyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.PolicyUpdateRequest,
                lnrpc.Rpc.PolicyUpdateResponse>(
                  this, METHODID_UPDATE_CHANNEL_POLICY)))
          .addMethod(
            getForwardingHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ForwardingHistoryRequest,
                lnrpc.Rpc.ForwardingHistoryResponse>(
                  this, METHODID_FORWARDING_HISTORY)))
          .addMethod(
            getExportChannelBackupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ExportChannelBackupRequest,
                lnrpc.Rpc.ChannelBackup>(
                  this, METHODID_EXPORT_CHANNEL_BACKUP)))
          .addMethod(
            getExportAllChannelBackupsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ChanBackupExportRequest,
                lnrpc.Rpc.ChanBackupSnapshot>(
                  this, METHODID_EXPORT_ALL_CHANNEL_BACKUPS)))
          .addMethod(
            getVerifyChanBackupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ChanBackupSnapshot,
                lnrpc.Rpc.VerifyChanBackupResponse>(
                  this, METHODID_VERIFY_CHAN_BACKUP)))
          .addMethod(
            getRestoreChannelBackupsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.RestoreChanBackupRequest,
                lnrpc.Rpc.RestoreBackupResponse>(
                  this, METHODID_RESTORE_CHANNEL_BACKUPS)))
          .addMethod(
            getSubscribeChannelBackupsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                lnrpc.Rpc.ChannelBackupSubscription,
                lnrpc.Rpc.ChanBackupSnapshot>(
                  this, METHODID_SUBSCRIBE_CHANNEL_BACKUPS)))
          .addMethod(
            getBakeMacaroonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.BakeMacaroonRequest,
                lnrpc.Rpc.BakeMacaroonResponse>(
                  this, METHODID_BAKE_MACAROON)))
          .addMethod(
            getListMacaroonIDsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ListMacaroonIDsRequest,
                lnrpc.Rpc.ListMacaroonIDsResponse>(
                  this, METHODID_LIST_MACAROON_IDS)))
          .addMethod(
            getDeleteMacaroonIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.DeleteMacaroonIDRequest,
                lnrpc.Rpc.DeleteMacaroonIDResponse>(
                  this, METHODID_DELETE_MACAROON_ID)))
          .addMethod(
            getListPermissionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lnrpc.Rpc.ListPermissionsRequest,
                lnrpc.Rpc.ListPermissionsResponse>(
                  this, METHODID_LIST_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Lightning is the main RPC server of the daemon.
   * </pre>
   */
  public static final class LightningStub extends io.grpc.stub.AbstractStub<LightningStub> {
    private LightningStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightningStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightningStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightningStub(channel, callOptions);
    }

    /**
     * <pre>
     * lncli: `walletbalance`
     *WalletBalance returns total unspent outputs(confirmed and unconfirmed), all
     *confirmed unspent outputs and all unconfirmed unspent outputs under control
     *of the wallet.
     * </pre>
     */
    public void walletBalance(lnrpc.Rpc.WalletBalanceRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.WalletBalanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWalletBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `channelbalance`
     *ChannelBalance returns a report on the total funds across all open channels,
     *categorized in local/remote, pending local/remote and unsettled local/remote
     *balances.
     * </pre>
     */
    public void channelBalance(lnrpc.Rpc.ChannelBalanceRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelBalanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChannelBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `listchaintxns`
     *GetTransactions returns a list describing all the known transactions
     *relevant to the wallet.
     * </pre>
     */
    public void getTransactions(lnrpc.Rpc.GetTransactionsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.TransactionDetails> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `estimatefee`
     *EstimateFee asks the chain backend to estimate the fee rate and total fees
     *for a transaction that pays to multiple specified outputs.
     *When using REST, the `AddrToAmount` map type can be set by appending
     *`&amp;AddrToAmount[&lt;address&gt;]=&lt;amount_to_send&gt;` to the URL. Unfortunately this
     *map type doesn't appear in the REST API documentation because of a bug in
     *the grpc-gateway library.
     * </pre>
     */
    public void estimateFee(lnrpc.Rpc.EstimateFeeRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.EstimateFeeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEstimateFeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `sendcoins`
     *SendCoins executes a request to send coins to a particular address. Unlike
     *SendMany, this RPC call only allows creating a single output at a time. If
     *neither target_conf, or sat_per_vbyte are set, then the internal wallet will
     *consult its fee model to determine a fee for the default confirmation
     *target.
     * </pre>
     */
    public void sendCoins(lnrpc.Rpc.SendCoinsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendCoinsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendCoinsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `listunspent`
     *Deprecated, use walletrpc.ListUnspent instead.
     *ListUnspent returns a list of all utxos spendable by the wallet with a
     *number of confirmations between the specified minimum and maximum.
     * </pre>
     */
    public void listUnspent(lnrpc.Rpc.ListUnspentRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListUnspentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListUnspentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *SubscribeTransactions creates a uni-directional stream from the server to
     *the client in which any newly discovered transactions relevant to the
     *wallet are sent over.
     * </pre>
     */
    public void subscribeTransactions(lnrpc.Rpc.GetTransactionsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.Transaction> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `sendmany`
     *SendMany handles a request for a transaction that creates multiple specified
     *outputs in parallel. If neither target_conf, or sat_per_vbyte are set, then
     *the internal wallet will consult its fee model to determine a fee for the
     *default confirmation target.
     * </pre>
     */
    public void sendMany(lnrpc.Rpc.SendManyRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendManyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendManyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `newaddress`
     *NewAddress creates a new address under control of the local wallet.
     * </pre>
     */
    public void newAddress(lnrpc.Rpc.NewAddressRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.NewAddressResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNewAddressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `signmessage`
     *SignMessage signs a message with this node's private key. The returned
     *signature string is `zbase32` encoded and pubkey recoverable, meaning that
     *only the message digest and signature are needed for verification.
     * </pre>
     */
    public void signMessage(lnrpc.Rpc.SignMessageRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SignMessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `verifymessage`
     *VerifyMessage verifies a signature over a msg. The signature must be
     *zbase32 encoded and signed by an active node in the resident node's
     *channel database. In addition to returning the validity of the signature,
     *VerifyMessage also returns the recovered pubkey from the signature.
     * </pre>
     */
    public void verifyMessage(lnrpc.Rpc.VerifyMessageRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.VerifyMessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerifyMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `connect`
     *ConnectPeer attempts to establish a connection to a remote peer. This is at
     *the networking level, and is used for communication between nodes. This is
     *distinct from establishing a channel with a peer.
     * </pre>
     */
    public void connectPeer(lnrpc.Rpc.ConnectPeerRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ConnectPeerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConnectPeerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `disconnect`
     *DisconnectPeer attempts to disconnect one peer from another identified by a
     *given pubKey. In the case that we currently have a pending or active channel
     *with the target peer, then this action will be not be allowed.
     * </pre>
     */
    public void disconnectPeer(lnrpc.Rpc.DisconnectPeerRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.DisconnectPeerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDisconnectPeerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `listpeers`
     *ListPeers returns a verbose listing of all currently active peers.
     * </pre>
     */
    public void listPeers(lnrpc.Rpc.ListPeersRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPeersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListPeersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *SubscribePeerEvents creates a uni-directional stream from the server to
     *the client in which any events relevant to the state of peers are sent
     *over. Events include peers going online and offline.
     * </pre>
     */
    public void subscribePeerEvents(lnrpc.Rpc.PeerEventSubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.PeerEvent> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribePeerEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `getinfo`
     *GetInfo returns general information concerning the lightning node including
     *it's identity pubkey, alias, the chains it is connected to, and information
     *concerning the number of open+pending channels.
     * </pre>
     */
    public void getInfo(lnrpc.Rpc.GetInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.GetInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     ** lncli: `getrecoveryinfo`
     *GetRecoveryInfo returns information concerning the recovery mode including
     *whether it's in a recovery mode, whether the recovery is finished, and the
     *progress made so far.
     * </pre>
     */
    public void getRecoveryInfo(lnrpc.Rpc.GetRecoveryInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.GetRecoveryInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRecoveryInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `pendingchannels`
     *PendingChannels returns a list of all the channels that are currently
     *considered "pending". A channel is pending if it has finished the funding
     *workflow and is waiting for confirmations for the funding txn, or is in the
     *process of closure, either initiated cooperatively or non-cooperatively.
     * </pre>
     */
    public void pendingChannels(lnrpc.Rpc.PendingChannelsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.PendingChannelsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPendingChannelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `listchannels`
     *ListChannels returns a description of all the open channels that this node
     *is a participant in.
     * </pre>
     */
    public void listChannels(lnrpc.Rpc.ListChannelsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListChannelsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListChannelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *SubscribeChannelEvents creates a uni-directional stream from the server to
     *the client in which any updates relevant to the state of the channels are
     *sent over. Events include new active channels, inactive channels, and closed
     *channels.
     * </pre>
     */
    public void subscribeChannelEvents(lnrpc.Rpc.ChannelEventSubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelEventUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeChannelEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `closedchannels`
     *ClosedChannels returns a description of all the closed channels that
     *this node was a participant in.
     * </pre>
     */
    public void closedChannels(lnrpc.Rpc.ClosedChannelsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ClosedChannelsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClosedChannelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *OpenChannelSync is a synchronous version of the OpenChannel RPC call. This
     *call is meant to be consumed by clients to the REST proxy. As with all
     *other sync calls, all byte slices are intended to be populated as hex
     *encoded strings.
     * </pre>
     */
    public void openChannelSync(lnrpc.Rpc.OpenChannelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelPoint> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOpenChannelSyncMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `openchannel`
     *OpenChannel attempts to open a singly funded channel specified in the
     *request to a remote peer. Users are able to specify a target number of
     *blocks that the funding transaction should be confirmed in, or a manual fee
     *rate to us for the funding transaction. If neither are specified, then a
     *lax block confirmation target is used. Each OpenStatusUpdate will return
     *the pending channel ID of the in-progress channel. Depending on the
     *arguments specified in the OpenChannelRequest, this pending channel ID can
     *then be used to manually progress the channel funding flow.
     * </pre>
     */
    public void openChannel(lnrpc.Rpc.OpenChannelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.OpenStatusUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getOpenChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *FundingStateStep is an advanced funding related call that allows the caller
     *to either execute some preparatory steps for a funding workflow, or
     *manually progress a funding workflow. The primary way a funding flow is
     *identified is via its pending channel ID. As an example, this method can be
     *used to specify that we're expecting a funding flow for a particular
     *pending channel ID, for which we need to use specific parameters.
     *Alternatively, this can be used to interactively drive PSBT signing for
     *funding for partially complete funding transactions.
     * </pre>
     */
    public void fundingStateStep(lnrpc.Rpc.FundingTransitionMsg request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.FundingStateStepResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFundingStateStepMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *ChannelAcceptor dispatches a bi-directional streaming RPC in which
     *OpenChannel requests are sent to the client and the client responds with
     *a boolean that tells LND whether or not to accept the channel. This allows
     *node operators to specify their own criteria for accepting inbound channels
     *through a single persistent connection.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelAcceptResponse> channelAcceptor(
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelAcceptRequest> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getChannelAcceptorMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * lncli: `closechannel`
     *CloseChannel attempts to close an active channel identified by its channel
     *outpoint (ChannelPoint). The actions of this method can additionally be
     *augmented to attempt a force close after a timeout period in the case of an
     *inactive peer. If a non-force close (cooperative closure) is requested,
     *then the user can specify either a target number of blocks until the
     *closure transaction is confirmed, or a manual fee rate. If neither are
     *specified, then a default lax, block confirmation target is used.
     * </pre>
     */
    public void closeChannel(lnrpc.Rpc.CloseChannelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.CloseStatusUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCloseChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `abandonchannel`
     *AbandonChannel removes all channel state from the database except for a
     *close summary. This method can be used to get rid of permanently unusable
     *channels due to bugs fixed in newer versions of lnd. This method can also be
     *used to remove externally funded channels where the funding transaction was
     *never broadcast. Only available for non-externally funded channels in dev
     *build.
     * </pre>
     */
    public void abandonChannel(lnrpc.Rpc.AbandonChannelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.AbandonChannelResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAbandonChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `sendpayment`
     *Deprecated, use routerrpc.SendPaymentV2. SendPayment dispatches a
     *bi-directional streaming RPC for sending payments through the Lightning
     *Network. A single RPC invocation creates a persistent bi-directional
     *stream allowing clients to rapidly send payments through the Lightning
     *Network with a single persistent connection.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lnrpc.Rpc.SendRequest> sendPayment(
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendPaymentMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *SendPaymentSync is the synchronous non-streaming version of SendPayment.
     *This RPC is intended to be consumed by clients of the REST proxy.
     *Additionally, this RPC expects the destination's public key and the payment
     *hash (if any) to be encoded as hex strings.
     * </pre>
     */
    public void sendPaymentSync(lnrpc.Rpc.SendRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendPaymentSyncMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `sendtoroute`
     *Deprecated, use routerrpc.SendToRouteV2. SendToRoute is a bi-directional
     *streaming RPC for sending payment through the Lightning Network. This
     *method differs from SendPayment in that it allows users to specify a full
     *route manually. This can be used for things like rebalancing, and atomic
     *swaps.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lnrpc.Rpc.SendToRouteRequest> sendToRoute(
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendToRouteMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *SendToRouteSync is a synchronous version of SendToRoute. It Will block
     *until the payment either fails or succeeds.
     * </pre>
     */
    public void sendToRouteSync(lnrpc.Rpc.SendToRouteRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendToRouteSyncMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `addinvoice`
     *AddInvoice attempts to add a new invoice to the invoice database. Any
     *duplicated invoices are rejected, therefore all invoices *must* have a
     *unique payment preimage.
     * </pre>
     */
    public void addInvoice(lnrpc.Rpc.Invoice request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.AddInvoiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddInvoiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `listinvoices`
     *ListInvoices returns a list of all the invoices currently stored within the
     *database. Any active debug invoices are ignored. It has full support for
     *paginated responses, allowing users to query for specific invoices through
     *their add_index. This can be done by using either the first_index_offset or
     *last_index_offset fields included in the response as the index_offset of the
     *next request. By default, the first 100 invoices created will be returned.
     *Backwards pagination is also supported through the Reversed flag.
     * </pre>
     */
    public void listInvoices(lnrpc.Rpc.ListInvoiceRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListInvoiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInvoicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `lookupinvoice`
     *LookupInvoice attempts to look up an invoice according to its payment hash.
     *The passed payment hash *must* be exactly 32 bytes, if not, an error is
     *returned.
     * </pre>
     */
    public void lookupInvoice(lnrpc.Rpc.PaymentHash request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.Invoice> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLookupInvoiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *SubscribeInvoices returns a uni-directional stream (server -&gt; client) for
     *notifying the client of newly added/settled invoices. The caller can
     *optionally specify the add_index and/or the settle_index. If the add_index
     *is specified, then we'll first start by sending add invoice events for all
     *invoices with an add_index greater than the specified value. If the
     *settle_index is specified, the next, we'll send out all settle events for
     *invoices with a settle_index greater than the specified value. One or both
     *of these fields can be set. If no fields are set, then we'll only send out
     *the latest add/settle events.
     * </pre>
     */
    public void subscribeInvoices(lnrpc.Rpc.InvoiceSubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.Invoice> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeInvoicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `decodepayreq`
     *DecodePayReq takes an encoded payment request string and attempts to decode
     *it, returning a full description of the conditions encoded within the
     *payment request.
     * </pre>
     */
    public void decodePayReq(lnrpc.Rpc.PayReqString request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.PayReq> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDecodePayReqMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `listpayments`
     *ListPayments returns a list of all outgoing payments.
     * </pre>
     */
    public void listPayments(lnrpc.Rpc.ListPaymentsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPaymentsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListPaymentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *DeleteAllPayments deletes all outgoing payments from DB.
     * </pre>
     */
    public void deleteAllPayments(lnrpc.Rpc.DeleteAllPaymentsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.DeleteAllPaymentsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAllPaymentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `describegraph`
     *DescribeGraph returns a description of the latest graph state from the
     *point of view of the node. The graph information is partitioned into two
     *components: all the nodes/vertexes, and all the edges that connect the
     *vertexes themselves. As this is a directed graph, the edges also contain
     *the node directional specific routing policy which includes: the time lock
     *delta, fee information, etc.
     * </pre>
     */
    public void describeGraph(lnrpc.Rpc.ChannelGraphRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelGraph> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDescribeGraphMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `getnodemetrics`
     *GetNodeMetrics returns node metrics calculated from the graph. Currently
     *the only supported metric is betweenness centrality of individual nodes.
     * </pre>
     */
    public void getNodeMetrics(lnrpc.Rpc.NodeMetricsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.NodeMetricsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNodeMetricsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `getchaninfo`
     *GetChanInfo returns the latest authenticated network announcement for the
     *given channel identified by its channel ID: an 8-byte integer which
     *uniquely identifies the location of transaction's funding output within the
     *blockchain.
     * </pre>
     */
    public void getChanInfo(lnrpc.Rpc.ChanInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelEdge> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetChanInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `getnodeinfo`
     *GetNodeInfo returns the latest advertised, aggregated, and authenticated
     *channel information for the specified node identified by its public key.
     * </pre>
     */
    public void getNodeInfo(lnrpc.Rpc.NodeInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.NodeInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNodeInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `queryroutes`
     *QueryRoutes attempts to query the daemon's Channel Router for a possible
     *route to a target destination capable of carrying a specific amount of
     *satoshis. The returned route contains the full details required to craft and
     *send an HTLC, also including the necessary information that should be
     *present within the Sphinx packet encapsulated within the HTLC.
     *When using REST, the `dest_custom_records` map type can be set by appending
     *`&amp;dest_custom_records[&lt;record_number&gt;]=&lt;record_data_base64_url_encoded&gt;`
     *to the URL. Unfortunately this map type doesn't appear in the REST API
     *documentation because of a bug in the grpc-gateway library.
     * </pre>
     */
    public void queryRoutes(lnrpc.Rpc.QueryRoutesRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.QueryRoutesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryRoutesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `getnetworkinfo`
     *GetNetworkInfo returns some basic stats about the known channel graph from
     *the point of view of the node.
     * </pre>
     */
    public void getNetworkInfo(lnrpc.Rpc.NetworkInfoRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.NetworkInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNetworkInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `stop`
     *StopDaemon will send a shutdown request to the interrupt handler, triggering
     *a graceful shutdown of the daemon.
     * </pre>
     */
    public void stopDaemon(lnrpc.Rpc.StopRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.StopResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStopDaemonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *SubscribeChannelGraph launches a streaming RPC that allows the caller to
     *receive notifications upon any changes to the channel graph topology from
     *the point of view of the responding node. Events notified include: new
     *nodes coming online, nodes updating their authenticated attributes, new
     *channels being advertised, updates in the routing policy for a directional
     *channel edge, and when channels are closed on-chain.
     * </pre>
     */
    public void subscribeChannelGraph(lnrpc.Rpc.GraphTopologySubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.GraphTopologyUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeChannelGraphMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `debuglevel`
     *DebugLevel allows a caller to programmatically set the logging verbosity of
     *lnd. The logging can be targeted according to a coarse daemon-wide logging
     *level, or in a granular fashion to specify the logging for a target
     *sub-system.
     * </pre>
     */
    public void debugLevel(lnrpc.Rpc.DebugLevelRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.DebugLevelResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDebugLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `feereport`
     *FeeReport allows the caller to obtain a report detailing the current fee
     *schedule enforced by the node globally for each channel.
     * </pre>
     */
    public void feeReport(lnrpc.Rpc.FeeReportRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.FeeReportResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFeeReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `updatechanpolicy`
     *UpdateChannelPolicy allows the caller to update the fee schedule and
     *channel policies for all channels globally, or a particular channel.
     * </pre>
     */
    public void updateChannelPolicy(lnrpc.Rpc.PolicyUpdateRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.PolicyUpdateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateChannelPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `fwdinghistory`
     *ForwardingHistory allows the caller to query the htlcswitch for a record of
     *all HTLCs forwarded within the target time range, and integer offset
     *within that time range, for a maximum number of events. If no maximum number
     *of events is specified, up to 100 events will be returned. If no time-range
     *is specified, then events will be returned in the order that they occured.
     *A list of forwarding events are returned. The size of each forwarding event
     *is 40 bytes, and the max message size able to be returned in gRPC is 4 MiB.
     *As a result each message can only contain 50k entries. Each response has
     *the index offset of the last entry. The index offset can be provided to the
     *request to allow the caller to skip a series of records.
     * </pre>
     */
    public void forwardingHistory(lnrpc.Rpc.ForwardingHistoryRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ForwardingHistoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getForwardingHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `exportchanbackup`
     *ExportChannelBackup attempts to return an encrypted static channel backup
     *for the target channel identified by it channel point. The backup is
     *encrypted with a key generated from the aezeed seed of the user. The
     *returned backup can either be restored using the RestoreChannelBackup
     *method once lnd is running, or via the InitWallet and UnlockWallet methods
     *from the WalletUnlocker service.
     * </pre>
     */
    public void exportChannelBackup(lnrpc.Rpc.ExportChannelBackupRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelBackup> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExportChannelBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *ExportAllChannelBackups returns static channel backups for all existing
     *channels known to lnd. A set of regular singular static channel backups for
     *each channel are returned. Additionally, a multi-channel backup is returned
     *as well, which contains a single encrypted blob containing the backups of
     *each channel.
     * </pre>
     */
    public void exportAllChannelBackups(lnrpc.Rpc.ChanBackupExportRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChanBackupSnapshot> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExportAllChannelBackupsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *VerifyChanBackup allows a caller to verify the integrity of a channel backup
     *snapshot. This method will accept either a packed Single or a packed Multi.
     *Specifying both will result in an error.
     * </pre>
     */
    public void verifyChanBackup(lnrpc.Rpc.ChanBackupSnapshot request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.VerifyChanBackupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerifyChanBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `restorechanbackup`
     *RestoreChannelBackups accepts a set of singular channel backups, or a
     *single encrypted multi-chan backup and attempts to recover any funds
     *remaining within the channel. If we are able to unpack the backup, then the
     *new channel will be shown under listchannels, as well as pending channels.
     * </pre>
     */
    public void restoreChannelBackups(lnrpc.Rpc.RestoreChanBackupRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.RestoreBackupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRestoreChannelBackupsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *SubscribeChannelBackups allows a client to sub-subscribe to the most up to
     *date information concerning the state of all channel backups. Each time a
     *new channel is added, we return the new set of channels, along with a
     *multi-chan backup containing the backup info for all channels. Each time a
     *channel is closed, we send a new update, which contains new new chan back
     *ups, but the updated set of encrypted multi-chan backups with the closed
     *channel(s) removed.
     * </pre>
     */
    public void subscribeChannelBackups(lnrpc.Rpc.ChannelBackupSubscription request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ChanBackupSnapshot> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeChannelBackupsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `bakemacaroon`
     *BakeMacaroon allows the creation of a new macaroon with custom read and
     *write permissions. No first-party caveats are added since this can be done
     *offline.
     * </pre>
     */
    public void bakeMacaroon(lnrpc.Rpc.BakeMacaroonRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.BakeMacaroonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBakeMacaroonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `listmacaroonids`
     *ListMacaroonIDs returns all root key IDs that are in use.
     * </pre>
     */
    public void listMacaroonIDs(lnrpc.Rpc.ListMacaroonIDsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListMacaroonIDsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListMacaroonIDsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `deletemacaroonid`
     *DeleteMacaroonID deletes the specified macaroon ID and invalidates all
     *macaroons derived from that ID.
     * </pre>
     */
    public void deleteMacaroonID(lnrpc.Rpc.DeleteMacaroonIDRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.DeleteMacaroonIDResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMacaroonIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * lncli: `listpermissions`
     *ListPermissions lists all RPC method URIs and their required macaroon
     *permissions to access them.
     * </pre>
     */
    public void listPermissions(lnrpc.Rpc.ListPermissionsRequest request,
        io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Lightning is the main RPC server of the daemon.
   * </pre>
   */
  public static final class LightningBlockingStub extends io.grpc.stub.AbstractStub<LightningBlockingStub> {
    private LightningBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightningBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightningBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightningBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * lncli: `walletbalance`
     *WalletBalance returns total unspent outputs(confirmed and unconfirmed), all
     *confirmed unspent outputs and all unconfirmed unspent outputs under control
     *of the wallet.
     * </pre>
     */
    public lnrpc.Rpc.WalletBalanceResponse walletBalance(lnrpc.Rpc.WalletBalanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getWalletBalanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `channelbalance`
     *ChannelBalance returns a report on the total funds across all open channels,
     *categorized in local/remote, pending local/remote and unsettled local/remote
     *balances.
     * </pre>
     */
    public lnrpc.Rpc.ChannelBalanceResponse channelBalance(lnrpc.Rpc.ChannelBalanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getChannelBalanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `listchaintxns`
     *GetTransactions returns a list describing all the known transactions
     *relevant to the wallet.
     * </pre>
     */
    public lnrpc.Rpc.TransactionDetails getTransactions(lnrpc.Rpc.GetTransactionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `estimatefee`
     *EstimateFee asks the chain backend to estimate the fee rate and total fees
     *for a transaction that pays to multiple specified outputs.
     *When using REST, the `AddrToAmount` map type can be set by appending
     *`&amp;AddrToAmount[&lt;address&gt;]=&lt;amount_to_send&gt;` to the URL. Unfortunately this
     *map type doesn't appear in the REST API documentation because of a bug in
     *the grpc-gateway library.
     * </pre>
     */
    public lnrpc.Rpc.EstimateFeeResponse estimateFee(lnrpc.Rpc.EstimateFeeRequest request) {
      return blockingUnaryCall(
          getChannel(), getEstimateFeeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `sendcoins`
     *SendCoins executes a request to send coins to a particular address. Unlike
     *SendMany, this RPC call only allows creating a single output at a time. If
     *neither target_conf, or sat_per_vbyte are set, then the internal wallet will
     *consult its fee model to determine a fee for the default confirmation
     *target.
     * </pre>
     */
    public lnrpc.Rpc.SendCoinsResponse sendCoins(lnrpc.Rpc.SendCoinsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendCoinsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `listunspent`
     *Deprecated, use walletrpc.ListUnspent instead.
     *ListUnspent returns a list of all utxos spendable by the wallet with a
     *number of confirmations between the specified minimum and maximum.
     * </pre>
     */
    public lnrpc.Rpc.ListUnspentResponse listUnspent(lnrpc.Rpc.ListUnspentRequest request) {
      return blockingUnaryCall(
          getChannel(), getListUnspentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SubscribeTransactions creates a uni-directional stream from the server to
     *the client in which any newly discovered transactions relevant to the
     *wallet are sent over.
     * </pre>
     */
    public java.util.Iterator<lnrpc.Rpc.Transaction> subscribeTransactions(
        lnrpc.Rpc.GetTransactionsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeTransactionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `sendmany`
     *SendMany handles a request for a transaction that creates multiple specified
     *outputs in parallel. If neither target_conf, or sat_per_vbyte are set, then
     *the internal wallet will consult its fee model to determine a fee for the
     *default confirmation target.
     * </pre>
     */
    public lnrpc.Rpc.SendManyResponse sendMany(lnrpc.Rpc.SendManyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendManyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `newaddress`
     *NewAddress creates a new address under control of the local wallet.
     * </pre>
     */
    public lnrpc.Rpc.NewAddressResponse newAddress(lnrpc.Rpc.NewAddressRequest request) {
      return blockingUnaryCall(
          getChannel(), getNewAddressMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `signmessage`
     *SignMessage signs a message with this node's private key. The returned
     *signature string is `zbase32` encoded and pubkey recoverable, meaning that
     *only the message digest and signature are needed for verification.
     * </pre>
     */
    public lnrpc.Rpc.SignMessageResponse signMessage(lnrpc.Rpc.SignMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getSignMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `verifymessage`
     *VerifyMessage verifies a signature over a msg. The signature must be
     *zbase32 encoded and signed by an active node in the resident node's
     *channel database. In addition to returning the validity of the signature,
     *VerifyMessage also returns the recovered pubkey from the signature.
     * </pre>
     */
    public lnrpc.Rpc.VerifyMessageResponse verifyMessage(lnrpc.Rpc.VerifyMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getVerifyMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `connect`
     *ConnectPeer attempts to establish a connection to a remote peer. This is at
     *the networking level, and is used for communication between nodes. This is
     *distinct from establishing a channel with a peer.
     * </pre>
     */
    public lnrpc.Rpc.ConnectPeerResponse connectPeer(lnrpc.Rpc.ConnectPeerRequest request) {
      return blockingUnaryCall(
          getChannel(), getConnectPeerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `disconnect`
     *DisconnectPeer attempts to disconnect one peer from another identified by a
     *given pubKey. In the case that we currently have a pending or active channel
     *with the target peer, then this action will be not be allowed.
     * </pre>
     */
    public lnrpc.Rpc.DisconnectPeerResponse disconnectPeer(lnrpc.Rpc.DisconnectPeerRequest request) {
      return blockingUnaryCall(
          getChannel(), getDisconnectPeerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `listpeers`
     *ListPeers returns a verbose listing of all currently active peers.
     * </pre>
     */
    public lnrpc.Rpc.ListPeersResponse listPeers(lnrpc.Rpc.ListPeersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListPeersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SubscribePeerEvents creates a uni-directional stream from the server to
     *the client in which any events relevant to the state of peers are sent
     *over. Events include peers going online and offline.
     * </pre>
     */
    public java.util.Iterator<lnrpc.Rpc.PeerEvent> subscribePeerEvents(
        lnrpc.Rpc.PeerEventSubscription request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribePeerEventsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `getinfo`
     *GetInfo returns general information concerning the lightning node including
     *it's identity pubkey, alias, the chains it is connected to, and information
     *concerning the number of open+pending channels.
     * </pre>
     */
    public lnrpc.Rpc.GetInfoResponse getInfo(lnrpc.Rpc.GetInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     ** lncli: `getrecoveryinfo`
     *GetRecoveryInfo returns information concerning the recovery mode including
     *whether it's in a recovery mode, whether the recovery is finished, and the
     *progress made so far.
     * </pre>
     */
    public lnrpc.Rpc.GetRecoveryInfoResponse getRecoveryInfo(lnrpc.Rpc.GetRecoveryInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRecoveryInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `pendingchannels`
     *PendingChannels returns a list of all the channels that are currently
     *considered "pending". A channel is pending if it has finished the funding
     *workflow and is waiting for confirmations for the funding txn, or is in the
     *process of closure, either initiated cooperatively or non-cooperatively.
     * </pre>
     */
    public lnrpc.Rpc.PendingChannelsResponse pendingChannels(lnrpc.Rpc.PendingChannelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getPendingChannelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `listchannels`
     *ListChannels returns a description of all the open channels that this node
     *is a participant in.
     * </pre>
     */
    public lnrpc.Rpc.ListChannelsResponse listChannels(lnrpc.Rpc.ListChannelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListChannelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SubscribeChannelEvents creates a uni-directional stream from the server to
     *the client in which any updates relevant to the state of the channels are
     *sent over. Events include new active channels, inactive channels, and closed
     *channels.
     * </pre>
     */
    public java.util.Iterator<lnrpc.Rpc.ChannelEventUpdate> subscribeChannelEvents(
        lnrpc.Rpc.ChannelEventSubscription request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeChannelEventsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `closedchannels`
     *ClosedChannels returns a description of all the closed channels that
     *this node was a participant in.
     * </pre>
     */
    public lnrpc.Rpc.ClosedChannelsResponse closedChannels(lnrpc.Rpc.ClosedChannelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getClosedChannelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *OpenChannelSync is a synchronous version of the OpenChannel RPC call. This
     *call is meant to be consumed by clients to the REST proxy. As with all
     *other sync calls, all byte slices are intended to be populated as hex
     *encoded strings.
     * </pre>
     */
    public lnrpc.Rpc.ChannelPoint openChannelSync(lnrpc.Rpc.OpenChannelRequest request) {
      return blockingUnaryCall(
          getChannel(), getOpenChannelSyncMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `openchannel`
     *OpenChannel attempts to open a singly funded channel specified in the
     *request to a remote peer. Users are able to specify a target number of
     *blocks that the funding transaction should be confirmed in, or a manual fee
     *rate to us for the funding transaction. If neither are specified, then a
     *lax block confirmation target is used. Each OpenStatusUpdate will return
     *the pending channel ID of the in-progress channel. Depending on the
     *arguments specified in the OpenChannelRequest, this pending channel ID can
     *then be used to manually progress the channel funding flow.
     * </pre>
     */
    public java.util.Iterator<lnrpc.Rpc.OpenStatusUpdate> openChannel(
        lnrpc.Rpc.OpenChannelRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getOpenChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *FundingStateStep is an advanced funding related call that allows the caller
     *to either execute some preparatory steps for a funding workflow, or
     *manually progress a funding workflow. The primary way a funding flow is
     *identified is via its pending channel ID. As an example, this method can be
     *used to specify that we're expecting a funding flow for a particular
     *pending channel ID, for which we need to use specific parameters.
     *Alternatively, this can be used to interactively drive PSBT signing for
     *funding for partially complete funding transactions.
     * </pre>
     */
    public lnrpc.Rpc.FundingStateStepResp fundingStateStep(lnrpc.Rpc.FundingTransitionMsg request) {
      return blockingUnaryCall(
          getChannel(), getFundingStateStepMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `closechannel`
     *CloseChannel attempts to close an active channel identified by its channel
     *outpoint (ChannelPoint). The actions of this method can additionally be
     *augmented to attempt a force close after a timeout period in the case of an
     *inactive peer. If a non-force close (cooperative closure) is requested,
     *then the user can specify either a target number of blocks until the
     *closure transaction is confirmed, or a manual fee rate. If neither are
     *specified, then a default lax, block confirmation target is used.
     * </pre>
     */
    public java.util.Iterator<lnrpc.Rpc.CloseStatusUpdate> closeChannel(
        lnrpc.Rpc.CloseChannelRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getCloseChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `abandonchannel`
     *AbandonChannel removes all channel state from the database except for a
     *close summary. This method can be used to get rid of permanently unusable
     *channels due to bugs fixed in newer versions of lnd. This method can also be
     *used to remove externally funded channels where the funding transaction was
     *never broadcast. Only available for non-externally funded channels in dev
     *build.
     * </pre>
     */
    public lnrpc.Rpc.AbandonChannelResponse abandonChannel(lnrpc.Rpc.AbandonChannelRequest request) {
      return blockingUnaryCall(
          getChannel(), getAbandonChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SendPaymentSync is the synchronous non-streaming version of SendPayment.
     *This RPC is intended to be consumed by clients of the REST proxy.
     *Additionally, this RPC expects the destination's public key and the payment
     *hash (if any) to be encoded as hex strings.
     * </pre>
     */
    public lnrpc.Rpc.SendResponse sendPaymentSync(lnrpc.Rpc.SendRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendPaymentSyncMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SendToRouteSync is a synchronous version of SendToRoute. It Will block
     *until the payment either fails or succeeds.
     * </pre>
     */
    public lnrpc.Rpc.SendResponse sendToRouteSync(lnrpc.Rpc.SendToRouteRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendToRouteSyncMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `addinvoice`
     *AddInvoice attempts to add a new invoice to the invoice database. Any
     *duplicated invoices are rejected, therefore all invoices *must* have a
     *unique payment preimage.
     * </pre>
     */
    public lnrpc.Rpc.AddInvoiceResponse addInvoice(lnrpc.Rpc.Invoice request) {
      return blockingUnaryCall(
          getChannel(), getAddInvoiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `listinvoices`
     *ListInvoices returns a list of all the invoices currently stored within the
     *database. Any active debug invoices are ignored. It has full support for
     *paginated responses, allowing users to query for specific invoices through
     *their add_index. This can be done by using either the first_index_offset or
     *last_index_offset fields included in the response as the index_offset of the
     *next request. By default, the first 100 invoices created will be returned.
     *Backwards pagination is also supported through the Reversed flag.
     * </pre>
     */
    public lnrpc.Rpc.ListInvoiceResponse listInvoices(lnrpc.Rpc.ListInvoiceRequest request) {
      return blockingUnaryCall(
          getChannel(), getListInvoicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `lookupinvoice`
     *LookupInvoice attempts to look up an invoice according to its payment hash.
     *The passed payment hash *must* be exactly 32 bytes, if not, an error is
     *returned.
     * </pre>
     */
    public lnrpc.Rpc.Invoice lookupInvoice(lnrpc.Rpc.PaymentHash request) {
      return blockingUnaryCall(
          getChannel(), getLookupInvoiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SubscribeInvoices returns a uni-directional stream (server -&gt; client) for
     *notifying the client of newly added/settled invoices. The caller can
     *optionally specify the add_index and/or the settle_index. If the add_index
     *is specified, then we'll first start by sending add invoice events for all
     *invoices with an add_index greater than the specified value. If the
     *settle_index is specified, the next, we'll send out all settle events for
     *invoices with a settle_index greater than the specified value. One or both
     *of these fields can be set. If no fields are set, then we'll only send out
     *the latest add/settle events.
     * </pre>
     */
    public java.util.Iterator<lnrpc.Rpc.Invoice> subscribeInvoices(
        lnrpc.Rpc.InvoiceSubscription request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeInvoicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `decodepayreq`
     *DecodePayReq takes an encoded payment request string and attempts to decode
     *it, returning a full description of the conditions encoded within the
     *payment request.
     * </pre>
     */
    public lnrpc.Rpc.PayReq decodePayReq(lnrpc.Rpc.PayReqString request) {
      return blockingUnaryCall(
          getChannel(), getDecodePayReqMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `listpayments`
     *ListPayments returns a list of all outgoing payments.
     * </pre>
     */
    public lnrpc.Rpc.ListPaymentsResponse listPayments(lnrpc.Rpc.ListPaymentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListPaymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *DeleteAllPayments deletes all outgoing payments from DB.
     * </pre>
     */
    public lnrpc.Rpc.DeleteAllPaymentsResponse deleteAllPayments(lnrpc.Rpc.DeleteAllPaymentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAllPaymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `describegraph`
     *DescribeGraph returns a description of the latest graph state from the
     *point of view of the node. The graph information is partitioned into two
     *components: all the nodes/vertexes, and all the edges that connect the
     *vertexes themselves. As this is a directed graph, the edges also contain
     *the node directional specific routing policy which includes: the time lock
     *delta, fee information, etc.
     * </pre>
     */
    public lnrpc.Rpc.ChannelGraph describeGraph(lnrpc.Rpc.ChannelGraphRequest request) {
      return blockingUnaryCall(
          getChannel(), getDescribeGraphMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `getnodemetrics`
     *GetNodeMetrics returns node metrics calculated from the graph. Currently
     *the only supported metric is betweenness centrality of individual nodes.
     * </pre>
     */
    public lnrpc.Rpc.NodeMetricsResponse getNodeMetrics(lnrpc.Rpc.NodeMetricsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNodeMetricsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `getchaninfo`
     *GetChanInfo returns the latest authenticated network announcement for the
     *given channel identified by its channel ID: an 8-byte integer which
     *uniquely identifies the location of transaction's funding output within the
     *blockchain.
     * </pre>
     */
    public lnrpc.Rpc.ChannelEdge getChanInfo(lnrpc.Rpc.ChanInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetChanInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `getnodeinfo`
     *GetNodeInfo returns the latest advertised, aggregated, and authenticated
     *channel information for the specified node identified by its public key.
     * </pre>
     */
    public lnrpc.Rpc.NodeInfo getNodeInfo(lnrpc.Rpc.NodeInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNodeInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `queryroutes`
     *QueryRoutes attempts to query the daemon's Channel Router for a possible
     *route to a target destination capable of carrying a specific amount of
     *satoshis. The returned route contains the full details required to craft and
     *send an HTLC, also including the necessary information that should be
     *present within the Sphinx packet encapsulated within the HTLC.
     *When using REST, the `dest_custom_records` map type can be set by appending
     *`&amp;dest_custom_records[&lt;record_number&gt;]=&lt;record_data_base64_url_encoded&gt;`
     *to the URL. Unfortunately this map type doesn't appear in the REST API
     *documentation because of a bug in the grpc-gateway library.
     * </pre>
     */
    public lnrpc.Rpc.QueryRoutesResponse queryRoutes(lnrpc.Rpc.QueryRoutesRequest request) {
      return blockingUnaryCall(
          getChannel(), getQueryRoutesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `getnetworkinfo`
     *GetNetworkInfo returns some basic stats about the known channel graph from
     *the point of view of the node.
     * </pre>
     */
    public lnrpc.Rpc.NetworkInfo getNetworkInfo(lnrpc.Rpc.NetworkInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNetworkInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `stop`
     *StopDaemon will send a shutdown request to the interrupt handler, triggering
     *a graceful shutdown of the daemon.
     * </pre>
     */
    public lnrpc.Rpc.StopResponse stopDaemon(lnrpc.Rpc.StopRequest request) {
      return blockingUnaryCall(
          getChannel(), getStopDaemonMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SubscribeChannelGraph launches a streaming RPC that allows the caller to
     *receive notifications upon any changes to the channel graph topology from
     *the point of view of the responding node. Events notified include: new
     *nodes coming online, nodes updating their authenticated attributes, new
     *channels being advertised, updates in the routing policy for a directional
     *channel edge, and when channels are closed on-chain.
     * </pre>
     */
    public java.util.Iterator<lnrpc.Rpc.GraphTopologyUpdate> subscribeChannelGraph(
        lnrpc.Rpc.GraphTopologySubscription request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeChannelGraphMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `debuglevel`
     *DebugLevel allows a caller to programmatically set the logging verbosity of
     *lnd. The logging can be targeted according to a coarse daemon-wide logging
     *level, or in a granular fashion to specify the logging for a target
     *sub-system.
     * </pre>
     */
    public lnrpc.Rpc.DebugLevelResponse debugLevel(lnrpc.Rpc.DebugLevelRequest request) {
      return blockingUnaryCall(
          getChannel(), getDebugLevelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `feereport`
     *FeeReport allows the caller to obtain a report detailing the current fee
     *schedule enforced by the node globally for each channel.
     * </pre>
     */
    public lnrpc.Rpc.FeeReportResponse feeReport(lnrpc.Rpc.FeeReportRequest request) {
      return blockingUnaryCall(
          getChannel(), getFeeReportMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `updatechanpolicy`
     *UpdateChannelPolicy allows the caller to update the fee schedule and
     *channel policies for all channels globally, or a particular channel.
     * </pre>
     */
    public lnrpc.Rpc.PolicyUpdateResponse updateChannelPolicy(lnrpc.Rpc.PolicyUpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateChannelPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `fwdinghistory`
     *ForwardingHistory allows the caller to query the htlcswitch for a record of
     *all HTLCs forwarded within the target time range, and integer offset
     *within that time range, for a maximum number of events. If no maximum number
     *of events is specified, up to 100 events will be returned. If no time-range
     *is specified, then events will be returned in the order that they occured.
     *A list of forwarding events are returned. The size of each forwarding event
     *is 40 bytes, and the max message size able to be returned in gRPC is 4 MiB.
     *As a result each message can only contain 50k entries. Each response has
     *the index offset of the last entry. The index offset can be provided to the
     *request to allow the caller to skip a series of records.
     * </pre>
     */
    public lnrpc.Rpc.ForwardingHistoryResponse forwardingHistory(lnrpc.Rpc.ForwardingHistoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getForwardingHistoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `exportchanbackup`
     *ExportChannelBackup attempts to return an encrypted static channel backup
     *for the target channel identified by it channel point. The backup is
     *encrypted with a key generated from the aezeed seed of the user. The
     *returned backup can either be restored using the RestoreChannelBackup
     *method once lnd is running, or via the InitWallet and UnlockWallet methods
     *from the WalletUnlocker service.
     * </pre>
     */
    public lnrpc.Rpc.ChannelBackup exportChannelBackup(lnrpc.Rpc.ExportChannelBackupRequest request) {
      return blockingUnaryCall(
          getChannel(), getExportChannelBackupMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *ExportAllChannelBackups returns static channel backups for all existing
     *channels known to lnd. A set of regular singular static channel backups for
     *each channel are returned. Additionally, a multi-channel backup is returned
     *as well, which contains a single encrypted blob containing the backups of
     *each channel.
     * </pre>
     */
    public lnrpc.Rpc.ChanBackupSnapshot exportAllChannelBackups(lnrpc.Rpc.ChanBackupExportRequest request) {
      return blockingUnaryCall(
          getChannel(), getExportAllChannelBackupsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *VerifyChanBackup allows a caller to verify the integrity of a channel backup
     *snapshot. This method will accept either a packed Single or a packed Multi.
     *Specifying both will result in an error.
     * </pre>
     */
    public lnrpc.Rpc.VerifyChanBackupResponse verifyChanBackup(lnrpc.Rpc.ChanBackupSnapshot request) {
      return blockingUnaryCall(
          getChannel(), getVerifyChanBackupMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `restorechanbackup`
     *RestoreChannelBackups accepts a set of singular channel backups, or a
     *single encrypted multi-chan backup and attempts to recover any funds
     *remaining within the channel. If we are able to unpack the backup, then the
     *new channel will be shown under listchannels, as well as pending channels.
     * </pre>
     */
    public lnrpc.Rpc.RestoreBackupResponse restoreChannelBackups(lnrpc.Rpc.RestoreChanBackupRequest request) {
      return blockingUnaryCall(
          getChannel(), getRestoreChannelBackupsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SubscribeChannelBackups allows a client to sub-subscribe to the most up to
     *date information concerning the state of all channel backups. Each time a
     *new channel is added, we return the new set of channels, along with a
     *multi-chan backup containing the backup info for all channels. Each time a
     *channel is closed, we send a new update, which contains new new chan back
     *ups, but the updated set of encrypted multi-chan backups with the closed
     *channel(s) removed.
     * </pre>
     */
    public java.util.Iterator<lnrpc.Rpc.ChanBackupSnapshot> subscribeChannelBackups(
        lnrpc.Rpc.ChannelBackupSubscription request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeChannelBackupsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `bakemacaroon`
     *BakeMacaroon allows the creation of a new macaroon with custom read and
     *write permissions. No first-party caveats are added since this can be done
     *offline.
     * </pre>
     */
    public lnrpc.Rpc.BakeMacaroonResponse bakeMacaroon(lnrpc.Rpc.BakeMacaroonRequest request) {
      return blockingUnaryCall(
          getChannel(), getBakeMacaroonMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `listmacaroonids`
     *ListMacaroonIDs returns all root key IDs that are in use.
     * </pre>
     */
    public lnrpc.Rpc.ListMacaroonIDsResponse listMacaroonIDs(lnrpc.Rpc.ListMacaroonIDsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListMacaroonIDsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `deletemacaroonid`
     *DeleteMacaroonID deletes the specified macaroon ID and invalidates all
     *macaroons derived from that ID.
     * </pre>
     */
    public lnrpc.Rpc.DeleteMacaroonIDResponse deleteMacaroonID(lnrpc.Rpc.DeleteMacaroonIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMacaroonIDMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * lncli: `listpermissions`
     *ListPermissions lists all RPC method URIs and their required macaroon
     *permissions to access them.
     * </pre>
     */
    public lnrpc.Rpc.ListPermissionsResponse listPermissions(lnrpc.Rpc.ListPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Lightning is the main RPC server of the daemon.
   * </pre>
   */
  public static final class LightningFutureStub extends io.grpc.stub.AbstractStub<LightningFutureStub> {
    private LightningFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightningFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightningFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightningFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * lncli: `walletbalance`
     *WalletBalance returns total unspent outputs(confirmed and unconfirmed), all
     *confirmed unspent outputs and all unconfirmed unspent outputs under control
     *of the wallet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.WalletBalanceResponse> walletBalance(
        lnrpc.Rpc.WalletBalanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWalletBalanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `channelbalance`
     *ChannelBalance returns a report on the total funds across all open channels,
     *categorized in local/remote, pending local/remote and unsettled local/remote
     *balances.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ChannelBalanceResponse> channelBalance(
        lnrpc.Rpc.ChannelBalanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChannelBalanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `listchaintxns`
     *GetTransactions returns a list describing all the known transactions
     *relevant to the wallet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.TransactionDetails> getTransactions(
        lnrpc.Rpc.GetTransactionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `estimatefee`
     *EstimateFee asks the chain backend to estimate the fee rate and total fees
     *for a transaction that pays to multiple specified outputs.
     *When using REST, the `AddrToAmount` map type can be set by appending
     *`&amp;AddrToAmount[&lt;address&gt;]=&lt;amount_to_send&gt;` to the URL. Unfortunately this
     *map type doesn't appear in the REST API documentation because of a bug in
     *the grpc-gateway library.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.EstimateFeeResponse> estimateFee(
        lnrpc.Rpc.EstimateFeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEstimateFeeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `sendcoins`
     *SendCoins executes a request to send coins to a particular address. Unlike
     *SendMany, this RPC call only allows creating a single output at a time. If
     *neither target_conf, or sat_per_vbyte are set, then the internal wallet will
     *consult its fee model to determine a fee for the default confirmation
     *target.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.SendCoinsResponse> sendCoins(
        lnrpc.Rpc.SendCoinsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendCoinsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `listunspent`
     *Deprecated, use walletrpc.ListUnspent instead.
     *ListUnspent returns a list of all utxos spendable by the wallet with a
     *number of confirmations between the specified minimum and maximum.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ListUnspentResponse> listUnspent(
        lnrpc.Rpc.ListUnspentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListUnspentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `sendmany`
     *SendMany handles a request for a transaction that creates multiple specified
     *outputs in parallel. If neither target_conf, or sat_per_vbyte are set, then
     *the internal wallet will consult its fee model to determine a fee for the
     *default confirmation target.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.SendManyResponse> sendMany(
        lnrpc.Rpc.SendManyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendManyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `newaddress`
     *NewAddress creates a new address under control of the local wallet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.NewAddressResponse> newAddress(
        lnrpc.Rpc.NewAddressRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getNewAddressMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `signmessage`
     *SignMessage signs a message with this node's private key. The returned
     *signature string is `zbase32` encoded and pubkey recoverable, meaning that
     *only the message digest and signature are needed for verification.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.SignMessageResponse> signMessage(
        lnrpc.Rpc.SignMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSignMessageMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `verifymessage`
     *VerifyMessage verifies a signature over a msg. The signature must be
     *zbase32 encoded and signed by an active node in the resident node's
     *channel database. In addition to returning the validity of the signature,
     *VerifyMessage also returns the recovered pubkey from the signature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.VerifyMessageResponse> verifyMessage(
        lnrpc.Rpc.VerifyMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVerifyMessageMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `connect`
     *ConnectPeer attempts to establish a connection to a remote peer. This is at
     *the networking level, and is used for communication between nodes. This is
     *distinct from establishing a channel with a peer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ConnectPeerResponse> connectPeer(
        lnrpc.Rpc.ConnectPeerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getConnectPeerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `disconnect`
     *DisconnectPeer attempts to disconnect one peer from another identified by a
     *given pubKey. In the case that we currently have a pending or active channel
     *with the target peer, then this action will be not be allowed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.DisconnectPeerResponse> disconnectPeer(
        lnrpc.Rpc.DisconnectPeerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDisconnectPeerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `listpeers`
     *ListPeers returns a verbose listing of all currently active peers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ListPeersResponse> listPeers(
        lnrpc.Rpc.ListPeersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListPeersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `getinfo`
     *GetInfo returns general information concerning the lightning node including
     *it's identity pubkey, alias, the chains it is connected to, and information
     *concerning the number of open+pending channels.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.GetInfoResponse> getInfo(
        lnrpc.Rpc.GetInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     ** lncli: `getrecoveryinfo`
     *GetRecoveryInfo returns information concerning the recovery mode including
     *whether it's in a recovery mode, whether the recovery is finished, and the
     *progress made so far.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.GetRecoveryInfoResponse> getRecoveryInfo(
        lnrpc.Rpc.GetRecoveryInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRecoveryInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `pendingchannels`
     *PendingChannels returns a list of all the channels that are currently
     *considered "pending". A channel is pending if it has finished the funding
     *workflow and is waiting for confirmations for the funding txn, or is in the
     *process of closure, either initiated cooperatively or non-cooperatively.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.PendingChannelsResponse> pendingChannels(
        lnrpc.Rpc.PendingChannelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPendingChannelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `listchannels`
     *ListChannels returns a description of all the open channels that this node
     *is a participant in.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ListChannelsResponse> listChannels(
        lnrpc.Rpc.ListChannelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListChannelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `closedchannels`
     *ClosedChannels returns a description of all the closed channels that
     *this node was a participant in.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ClosedChannelsResponse> closedChannels(
        lnrpc.Rpc.ClosedChannelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getClosedChannelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *OpenChannelSync is a synchronous version of the OpenChannel RPC call. This
     *call is meant to be consumed by clients to the REST proxy. As with all
     *other sync calls, all byte slices are intended to be populated as hex
     *encoded strings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ChannelPoint> openChannelSync(
        lnrpc.Rpc.OpenChannelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOpenChannelSyncMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *FundingStateStep is an advanced funding related call that allows the caller
     *to either execute some preparatory steps for a funding workflow, or
     *manually progress a funding workflow. The primary way a funding flow is
     *identified is via its pending channel ID. As an example, this method can be
     *used to specify that we're expecting a funding flow for a particular
     *pending channel ID, for which we need to use specific parameters.
     *Alternatively, this can be used to interactively drive PSBT signing for
     *funding for partially complete funding transactions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.FundingStateStepResp> fundingStateStep(
        lnrpc.Rpc.FundingTransitionMsg request) {
      return futureUnaryCall(
          getChannel().newCall(getFundingStateStepMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `abandonchannel`
     *AbandonChannel removes all channel state from the database except for a
     *close summary. This method can be used to get rid of permanently unusable
     *channels due to bugs fixed in newer versions of lnd. This method can also be
     *used to remove externally funded channels where the funding transaction was
     *never broadcast. Only available for non-externally funded channels in dev
     *build.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.AbandonChannelResponse> abandonChannel(
        lnrpc.Rpc.AbandonChannelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAbandonChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *SendPaymentSync is the synchronous non-streaming version of SendPayment.
     *This RPC is intended to be consumed by clients of the REST proxy.
     *Additionally, this RPC expects the destination's public key and the payment
     *hash (if any) to be encoded as hex strings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.SendResponse> sendPaymentSync(
        lnrpc.Rpc.SendRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendPaymentSyncMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *SendToRouteSync is a synchronous version of SendToRoute. It Will block
     *until the payment either fails or succeeds.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.SendResponse> sendToRouteSync(
        lnrpc.Rpc.SendToRouteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendToRouteSyncMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `addinvoice`
     *AddInvoice attempts to add a new invoice to the invoice database. Any
     *duplicated invoices are rejected, therefore all invoices *must* have a
     *unique payment preimage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.AddInvoiceResponse> addInvoice(
        lnrpc.Rpc.Invoice request) {
      return futureUnaryCall(
          getChannel().newCall(getAddInvoiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `listinvoices`
     *ListInvoices returns a list of all the invoices currently stored within the
     *database. Any active debug invoices are ignored. It has full support for
     *paginated responses, allowing users to query for specific invoices through
     *their add_index. This can be done by using either the first_index_offset or
     *last_index_offset fields included in the response as the index_offset of the
     *next request. By default, the first 100 invoices created will be returned.
     *Backwards pagination is also supported through the Reversed flag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ListInvoiceResponse> listInvoices(
        lnrpc.Rpc.ListInvoiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInvoicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `lookupinvoice`
     *LookupInvoice attempts to look up an invoice according to its payment hash.
     *The passed payment hash *must* be exactly 32 bytes, if not, an error is
     *returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.Invoice> lookupInvoice(
        lnrpc.Rpc.PaymentHash request) {
      return futureUnaryCall(
          getChannel().newCall(getLookupInvoiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `decodepayreq`
     *DecodePayReq takes an encoded payment request string and attempts to decode
     *it, returning a full description of the conditions encoded within the
     *payment request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.PayReq> decodePayReq(
        lnrpc.Rpc.PayReqString request) {
      return futureUnaryCall(
          getChannel().newCall(getDecodePayReqMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `listpayments`
     *ListPayments returns a list of all outgoing payments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ListPaymentsResponse> listPayments(
        lnrpc.Rpc.ListPaymentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListPaymentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *DeleteAllPayments deletes all outgoing payments from DB.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.DeleteAllPaymentsResponse> deleteAllPayments(
        lnrpc.Rpc.DeleteAllPaymentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAllPaymentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `describegraph`
     *DescribeGraph returns a description of the latest graph state from the
     *point of view of the node. The graph information is partitioned into two
     *components: all the nodes/vertexes, and all the edges that connect the
     *vertexes themselves. As this is a directed graph, the edges also contain
     *the node directional specific routing policy which includes: the time lock
     *delta, fee information, etc.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ChannelGraph> describeGraph(
        lnrpc.Rpc.ChannelGraphRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDescribeGraphMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `getnodemetrics`
     *GetNodeMetrics returns node metrics calculated from the graph. Currently
     *the only supported metric is betweenness centrality of individual nodes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.NodeMetricsResponse> getNodeMetrics(
        lnrpc.Rpc.NodeMetricsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNodeMetricsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `getchaninfo`
     *GetChanInfo returns the latest authenticated network announcement for the
     *given channel identified by its channel ID: an 8-byte integer which
     *uniquely identifies the location of transaction's funding output within the
     *blockchain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ChannelEdge> getChanInfo(
        lnrpc.Rpc.ChanInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetChanInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `getnodeinfo`
     *GetNodeInfo returns the latest advertised, aggregated, and authenticated
     *channel information for the specified node identified by its public key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.NodeInfo> getNodeInfo(
        lnrpc.Rpc.NodeInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNodeInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `queryroutes`
     *QueryRoutes attempts to query the daemon's Channel Router for a possible
     *route to a target destination capable of carrying a specific amount of
     *satoshis. The returned route contains the full details required to craft and
     *send an HTLC, also including the necessary information that should be
     *present within the Sphinx packet encapsulated within the HTLC.
     *When using REST, the `dest_custom_records` map type can be set by appending
     *`&amp;dest_custom_records[&lt;record_number&gt;]=&lt;record_data_base64_url_encoded&gt;`
     *to the URL. Unfortunately this map type doesn't appear in the REST API
     *documentation because of a bug in the grpc-gateway library.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.QueryRoutesResponse> queryRoutes(
        lnrpc.Rpc.QueryRoutesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryRoutesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `getnetworkinfo`
     *GetNetworkInfo returns some basic stats about the known channel graph from
     *the point of view of the node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.NetworkInfo> getNetworkInfo(
        lnrpc.Rpc.NetworkInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNetworkInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `stop`
     *StopDaemon will send a shutdown request to the interrupt handler, triggering
     *a graceful shutdown of the daemon.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.StopResponse> stopDaemon(
        lnrpc.Rpc.StopRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStopDaemonMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `debuglevel`
     *DebugLevel allows a caller to programmatically set the logging verbosity of
     *lnd. The logging can be targeted according to a coarse daemon-wide logging
     *level, or in a granular fashion to specify the logging for a target
     *sub-system.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.DebugLevelResponse> debugLevel(
        lnrpc.Rpc.DebugLevelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDebugLevelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `feereport`
     *FeeReport allows the caller to obtain a report detailing the current fee
     *schedule enforced by the node globally for each channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.FeeReportResponse> feeReport(
        lnrpc.Rpc.FeeReportRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFeeReportMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `updatechanpolicy`
     *UpdateChannelPolicy allows the caller to update the fee schedule and
     *channel policies for all channels globally, or a particular channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.PolicyUpdateResponse> updateChannelPolicy(
        lnrpc.Rpc.PolicyUpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateChannelPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `fwdinghistory`
     *ForwardingHistory allows the caller to query the htlcswitch for a record of
     *all HTLCs forwarded within the target time range, and integer offset
     *within that time range, for a maximum number of events. If no maximum number
     *of events is specified, up to 100 events will be returned. If no time-range
     *is specified, then events will be returned in the order that they occured.
     *A list of forwarding events are returned. The size of each forwarding event
     *is 40 bytes, and the max message size able to be returned in gRPC is 4 MiB.
     *As a result each message can only contain 50k entries. Each response has
     *the index offset of the last entry. The index offset can be provided to the
     *request to allow the caller to skip a series of records.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ForwardingHistoryResponse> forwardingHistory(
        lnrpc.Rpc.ForwardingHistoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getForwardingHistoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `exportchanbackup`
     *ExportChannelBackup attempts to return an encrypted static channel backup
     *for the target channel identified by it channel point. The backup is
     *encrypted with a key generated from the aezeed seed of the user. The
     *returned backup can either be restored using the RestoreChannelBackup
     *method once lnd is running, or via the InitWallet and UnlockWallet methods
     *from the WalletUnlocker service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ChannelBackup> exportChannelBackup(
        lnrpc.Rpc.ExportChannelBackupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExportChannelBackupMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *ExportAllChannelBackups returns static channel backups for all existing
     *channels known to lnd. A set of regular singular static channel backups for
     *each channel are returned. Additionally, a multi-channel backup is returned
     *as well, which contains a single encrypted blob containing the backups of
     *each channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ChanBackupSnapshot> exportAllChannelBackups(
        lnrpc.Rpc.ChanBackupExportRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExportAllChannelBackupsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *VerifyChanBackup allows a caller to verify the integrity of a channel backup
     *snapshot. This method will accept either a packed Single or a packed Multi.
     *Specifying both will result in an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.VerifyChanBackupResponse> verifyChanBackup(
        lnrpc.Rpc.ChanBackupSnapshot request) {
      return futureUnaryCall(
          getChannel().newCall(getVerifyChanBackupMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `restorechanbackup`
     *RestoreChannelBackups accepts a set of singular channel backups, or a
     *single encrypted multi-chan backup and attempts to recover any funds
     *remaining within the channel. If we are able to unpack the backup, then the
     *new channel will be shown under listchannels, as well as pending channels.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.RestoreBackupResponse> restoreChannelBackups(
        lnrpc.Rpc.RestoreChanBackupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRestoreChannelBackupsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `bakemacaroon`
     *BakeMacaroon allows the creation of a new macaroon with custom read and
     *write permissions. No first-party caveats are added since this can be done
     *offline.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.BakeMacaroonResponse> bakeMacaroon(
        lnrpc.Rpc.BakeMacaroonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBakeMacaroonMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `listmacaroonids`
     *ListMacaroonIDs returns all root key IDs that are in use.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ListMacaroonIDsResponse> listMacaroonIDs(
        lnrpc.Rpc.ListMacaroonIDsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListMacaroonIDsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `deletemacaroonid`
     *DeleteMacaroonID deletes the specified macaroon ID and invalidates all
     *macaroons derived from that ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.DeleteMacaroonIDResponse> deleteMacaroonID(
        lnrpc.Rpc.DeleteMacaroonIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMacaroonIDMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * lncli: `listpermissions`
     *ListPermissions lists all RPC method URIs and their required macaroon
     *permissions to access them.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lnrpc.Rpc.ListPermissionsResponse> listPermissions(
        lnrpc.Rpc.ListPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WALLET_BALANCE = 0;
  private static final int METHODID_CHANNEL_BALANCE = 1;
  private static final int METHODID_GET_TRANSACTIONS = 2;
  private static final int METHODID_ESTIMATE_FEE = 3;
  private static final int METHODID_SEND_COINS = 4;
  private static final int METHODID_LIST_UNSPENT = 5;
  private static final int METHODID_SUBSCRIBE_TRANSACTIONS = 6;
  private static final int METHODID_SEND_MANY = 7;
  private static final int METHODID_NEW_ADDRESS = 8;
  private static final int METHODID_SIGN_MESSAGE = 9;
  private static final int METHODID_VERIFY_MESSAGE = 10;
  private static final int METHODID_CONNECT_PEER = 11;
  private static final int METHODID_DISCONNECT_PEER = 12;
  private static final int METHODID_LIST_PEERS = 13;
  private static final int METHODID_SUBSCRIBE_PEER_EVENTS = 14;
  private static final int METHODID_GET_INFO = 15;
  private static final int METHODID_GET_RECOVERY_INFO = 16;
  private static final int METHODID_PENDING_CHANNELS = 17;
  private static final int METHODID_LIST_CHANNELS = 18;
  private static final int METHODID_SUBSCRIBE_CHANNEL_EVENTS = 19;
  private static final int METHODID_CLOSED_CHANNELS = 20;
  private static final int METHODID_OPEN_CHANNEL_SYNC = 21;
  private static final int METHODID_OPEN_CHANNEL = 22;
  private static final int METHODID_FUNDING_STATE_STEP = 23;
  private static final int METHODID_CLOSE_CHANNEL = 24;
  private static final int METHODID_ABANDON_CHANNEL = 25;
  private static final int METHODID_SEND_PAYMENT_SYNC = 26;
  private static final int METHODID_SEND_TO_ROUTE_SYNC = 27;
  private static final int METHODID_ADD_INVOICE = 28;
  private static final int METHODID_LIST_INVOICES = 29;
  private static final int METHODID_LOOKUP_INVOICE = 30;
  private static final int METHODID_SUBSCRIBE_INVOICES = 31;
  private static final int METHODID_DECODE_PAY_REQ = 32;
  private static final int METHODID_LIST_PAYMENTS = 33;
  private static final int METHODID_DELETE_ALL_PAYMENTS = 34;
  private static final int METHODID_DESCRIBE_GRAPH = 35;
  private static final int METHODID_GET_NODE_METRICS = 36;
  private static final int METHODID_GET_CHAN_INFO = 37;
  private static final int METHODID_GET_NODE_INFO = 38;
  private static final int METHODID_QUERY_ROUTES = 39;
  private static final int METHODID_GET_NETWORK_INFO = 40;
  private static final int METHODID_STOP_DAEMON = 41;
  private static final int METHODID_SUBSCRIBE_CHANNEL_GRAPH = 42;
  private static final int METHODID_DEBUG_LEVEL = 43;
  private static final int METHODID_FEE_REPORT = 44;
  private static final int METHODID_UPDATE_CHANNEL_POLICY = 45;
  private static final int METHODID_FORWARDING_HISTORY = 46;
  private static final int METHODID_EXPORT_CHANNEL_BACKUP = 47;
  private static final int METHODID_EXPORT_ALL_CHANNEL_BACKUPS = 48;
  private static final int METHODID_VERIFY_CHAN_BACKUP = 49;
  private static final int METHODID_RESTORE_CHANNEL_BACKUPS = 50;
  private static final int METHODID_SUBSCRIBE_CHANNEL_BACKUPS = 51;
  private static final int METHODID_BAKE_MACAROON = 52;
  private static final int METHODID_LIST_MACAROON_IDS = 53;
  private static final int METHODID_DELETE_MACAROON_ID = 54;
  private static final int METHODID_LIST_PERMISSIONS = 55;
  private static final int METHODID_CHANNEL_ACCEPTOR = 56;
  private static final int METHODID_SEND_PAYMENT = 57;
  private static final int METHODID_SEND_TO_ROUTE = 58;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightningImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightningImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WALLET_BALANCE:
          serviceImpl.walletBalance((lnrpc.Rpc.WalletBalanceRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.WalletBalanceResponse>) responseObserver);
          break;
        case METHODID_CHANNEL_BALANCE:
          serviceImpl.channelBalance((lnrpc.Rpc.ChannelBalanceRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelBalanceResponse>) responseObserver);
          break;
        case METHODID_GET_TRANSACTIONS:
          serviceImpl.getTransactions((lnrpc.Rpc.GetTransactionsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.TransactionDetails>) responseObserver);
          break;
        case METHODID_ESTIMATE_FEE:
          serviceImpl.estimateFee((lnrpc.Rpc.EstimateFeeRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.EstimateFeeResponse>) responseObserver);
          break;
        case METHODID_SEND_COINS:
          serviceImpl.sendCoins((lnrpc.Rpc.SendCoinsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.SendCoinsResponse>) responseObserver);
          break;
        case METHODID_LIST_UNSPENT:
          serviceImpl.listUnspent((lnrpc.Rpc.ListUnspentRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ListUnspentResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_TRANSACTIONS:
          serviceImpl.subscribeTransactions((lnrpc.Rpc.GetTransactionsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.Transaction>) responseObserver);
          break;
        case METHODID_SEND_MANY:
          serviceImpl.sendMany((lnrpc.Rpc.SendManyRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.SendManyResponse>) responseObserver);
          break;
        case METHODID_NEW_ADDRESS:
          serviceImpl.newAddress((lnrpc.Rpc.NewAddressRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.NewAddressResponse>) responseObserver);
          break;
        case METHODID_SIGN_MESSAGE:
          serviceImpl.signMessage((lnrpc.Rpc.SignMessageRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.SignMessageResponse>) responseObserver);
          break;
        case METHODID_VERIFY_MESSAGE:
          serviceImpl.verifyMessage((lnrpc.Rpc.VerifyMessageRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.VerifyMessageResponse>) responseObserver);
          break;
        case METHODID_CONNECT_PEER:
          serviceImpl.connectPeer((lnrpc.Rpc.ConnectPeerRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ConnectPeerResponse>) responseObserver);
          break;
        case METHODID_DISCONNECT_PEER:
          serviceImpl.disconnectPeer((lnrpc.Rpc.DisconnectPeerRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.DisconnectPeerResponse>) responseObserver);
          break;
        case METHODID_LIST_PEERS:
          serviceImpl.listPeers((lnrpc.Rpc.ListPeersRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPeersResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_PEER_EVENTS:
          serviceImpl.subscribePeerEvents((lnrpc.Rpc.PeerEventSubscription) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.PeerEvent>) responseObserver);
          break;
        case METHODID_GET_INFO:
          serviceImpl.getInfo((lnrpc.Rpc.GetInfoRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.GetInfoResponse>) responseObserver);
          break;
        case METHODID_GET_RECOVERY_INFO:
          serviceImpl.getRecoveryInfo((lnrpc.Rpc.GetRecoveryInfoRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.GetRecoveryInfoResponse>) responseObserver);
          break;
        case METHODID_PENDING_CHANNELS:
          serviceImpl.pendingChannels((lnrpc.Rpc.PendingChannelsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.PendingChannelsResponse>) responseObserver);
          break;
        case METHODID_LIST_CHANNELS:
          serviceImpl.listChannels((lnrpc.Rpc.ListChannelsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ListChannelsResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_CHANNEL_EVENTS:
          serviceImpl.subscribeChannelEvents((lnrpc.Rpc.ChannelEventSubscription) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelEventUpdate>) responseObserver);
          break;
        case METHODID_CLOSED_CHANNELS:
          serviceImpl.closedChannels((lnrpc.Rpc.ClosedChannelsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ClosedChannelsResponse>) responseObserver);
          break;
        case METHODID_OPEN_CHANNEL_SYNC:
          serviceImpl.openChannelSync((lnrpc.Rpc.OpenChannelRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelPoint>) responseObserver);
          break;
        case METHODID_OPEN_CHANNEL:
          serviceImpl.openChannel((lnrpc.Rpc.OpenChannelRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.OpenStatusUpdate>) responseObserver);
          break;
        case METHODID_FUNDING_STATE_STEP:
          serviceImpl.fundingStateStep((lnrpc.Rpc.FundingTransitionMsg) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.FundingStateStepResp>) responseObserver);
          break;
        case METHODID_CLOSE_CHANNEL:
          serviceImpl.closeChannel((lnrpc.Rpc.CloseChannelRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.CloseStatusUpdate>) responseObserver);
          break;
        case METHODID_ABANDON_CHANNEL:
          serviceImpl.abandonChannel((lnrpc.Rpc.AbandonChannelRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.AbandonChannelResponse>) responseObserver);
          break;
        case METHODID_SEND_PAYMENT_SYNC:
          serviceImpl.sendPaymentSync((lnrpc.Rpc.SendRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse>) responseObserver);
          break;
        case METHODID_SEND_TO_ROUTE_SYNC:
          serviceImpl.sendToRouteSync((lnrpc.Rpc.SendToRouteRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse>) responseObserver);
          break;
        case METHODID_ADD_INVOICE:
          serviceImpl.addInvoice((lnrpc.Rpc.Invoice) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.AddInvoiceResponse>) responseObserver);
          break;
        case METHODID_LIST_INVOICES:
          serviceImpl.listInvoices((lnrpc.Rpc.ListInvoiceRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ListInvoiceResponse>) responseObserver);
          break;
        case METHODID_LOOKUP_INVOICE:
          serviceImpl.lookupInvoice((lnrpc.Rpc.PaymentHash) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.Invoice>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_INVOICES:
          serviceImpl.subscribeInvoices((lnrpc.Rpc.InvoiceSubscription) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.Invoice>) responseObserver);
          break;
        case METHODID_DECODE_PAY_REQ:
          serviceImpl.decodePayReq((lnrpc.Rpc.PayReqString) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.PayReq>) responseObserver);
          break;
        case METHODID_LIST_PAYMENTS:
          serviceImpl.listPayments((lnrpc.Rpc.ListPaymentsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPaymentsResponse>) responseObserver);
          break;
        case METHODID_DELETE_ALL_PAYMENTS:
          serviceImpl.deleteAllPayments((lnrpc.Rpc.DeleteAllPaymentsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.DeleteAllPaymentsResponse>) responseObserver);
          break;
        case METHODID_DESCRIBE_GRAPH:
          serviceImpl.describeGraph((lnrpc.Rpc.ChannelGraphRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelGraph>) responseObserver);
          break;
        case METHODID_GET_NODE_METRICS:
          serviceImpl.getNodeMetrics((lnrpc.Rpc.NodeMetricsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.NodeMetricsResponse>) responseObserver);
          break;
        case METHODID_GET_CHAN_INFO:
          serviceImpl.getChanInfo((lnrpc.Rpc.ChanInfoRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelEdge>) responseObserver);
          break;
        case METHODID_GET_NODE_INFO:
          serviceImpl.getNodeInfo((lnrpc.Rpc.NodeInfoRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.NodeInfo>) responseObserver);
          break;
        case METHODID_QUERY_ROUTES:
          serviceImpl.queryRoutes((lnrpc.Rpc.QueryRoutesRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.QueryRoutesResponse>) responseObserver);
          break;
        case METHODID_GET_NETWORK_INFO:
          serviceImpl.getNetworkInfo((lnrpc.Rpc.NetworkInfoRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.NetworkInfo>) responseObserver);
          break;
        case METHODID_STOP_DAEMON:
          serviceImpl.stopDaemon((lnrpc.Rpc.StopRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.StopResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_CHANNEL_GRAPH:
          serviceImpl.subscribeChannelGraph((lnrpc.Rpc.GraphTopologySubscription) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.GraphTopologyUpdate>) responseObserver);
          break;
        case METHODID_DEBUG_LEVEL:
          serviceImpl.debugLevel((lnrpc.Rpc.DebugLevelRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.DebugLevelResponse>) responseObserver);
          break;
        case METHODID_FEE_REPORT:
          serviceImpl.feeReport((lnrpc.Rpc.FeeReportRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.FeeReportResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CHANNEL_POLICY:
          serviceImpl.updateChannelPolicy((lnrpc.Rpc.PolicyUpdateRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.PolicyUpdateResponse>) responseObserver);
          break;
        case METHODID_FORWARDING_HISTORY:
          serviceImpl.forwardingHistory((lnrpc.Rpc.ForwardingHistoryRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ForwardingHistoryResponse>) responseObserver);
          break;
        case METHODID_EXPORT_CHANNEL_BACKUP:
          serviceImpl.exportChannelBackup((lnrpc.Rpc.ExportChannelBackupRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelBackup>) responseObserver);
          break;
        case METHODID_EXPORT_ALL_CHANNEL_BACKUPS:
          serviceImpl.exportAllChannelBackups((lnrpc.Rpc.ChanBackupExportRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChanBackupSnapshot>) responseObserver);
          break;
        case METHODID_VERIFY_CHAN_BACKUP:
          serviceImpl.verifyChanBackup((lnrpc.Rpc.ChanBackupSnapshot) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.VerifyChanBackupResponse>) responseObserver);
          break;
        case METHODID_RESTORE_CHANNEL_BACKUPS:
          serviceImpl.restoreChannelBackups((lnrpc.Rpc.RestoreChanBackupRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.RestoreBackupResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_CHANNEL_BACKUPS:
          serviceImpl.subscribeChannelBackups((lnrpc.Rpc.ChannelBackupSubscription) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChanBackupSnapshot>) responseObserver);
          break;
        case METHODID_BAKE_MACAROON:
          serviceImpl.bakeMacaroon((lnrpc.Rpc.BakeMacaroonRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.BakeMacaroonResponse>) responseObserver);
          break;
        case METHODID_LIST_MACAROON_IDS:
          serviceImpl.listMacaroonIDs((lnrpc.Rpc.ListMacaroonIDsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ListMacaroonIDsResponse>) responseObserver);
          break;
        case METHODID_DELETE_MACAROON_ID:
          serviceImpl.deleteMacaroonID((lnrpc.Rpc.DeleteMacaroonIDRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.DeleteMacaroonIDResponse>) responseObserver);
          break;
        case METHODID_LIST_PERMISSIONS:
          serviceImpl.listPermissions((lnrpc.Rpc.ListPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ListPermissionsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHANNEL_ACCEPTOR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.channelAcceptor(
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.ChannelAcceptRequest>) responseObserver);
        case METHODID_SEND_PAYMENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendPayment(
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse>) responseObserver);
        case METHODID_SEND_TO_ROUTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendToRoute(
              (io.grpc.stub.StreamObserver<lnrpc.Rpc.SendResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightningBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightningBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return lnrpc.Rpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Lightning");
    }
  }

  private static final class LightningFileDescriptorSupplier
      extends LightningBaseDescriptorSupplier {
    LightningFileDescriptorSupplier() {}
  }

  private static final class LightningMethodDescriptorSupplier
      extends LightningBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightningMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LightningGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightningFileDescriptorSupplier())
              .addMethod(getWalletBalanceMethod())
              .addMethod(getChannelBalanceMethod())
              .addMethod(getGetTransactionsMethod())
              .addMethod(getEstimateFeeMethod())
              .addMethod(getSendCoinsMethod())
              .addMethod(getListUnspentMethod())
              .addMethod(getSubscribeTransactionsMethod())
              .addMethod(getSendManyMethod())
              .addMethod(getNewAddressMethod())
              .addMethod(getSignMessageMethod())
              .addMethod(getVerifyMessageMethod())
              .addMethod(getConnectPeerMethod())
              .addMethod(getDisconnectPeerMethod())
              .addMethod(getListPeersMethod())
              .addMethod(getSubscribePeerEventsMethod())
              .addMethod(getGetInfoMethod())
              .addMethod(getGetRecoveryInfoMethod())
              .addMethod(getPendingChannelsMethod())
              .addMethod(getListChannelsMethod())
              .addMethod(getSubscribeChannelEventsMethod())
              .addMethod(getClosedChannelsMethod())
              .addMethod(getOpenChannelSyncMethod())
              .addMethod(getOpenChannelMethod())
              .addMethod(getFundingStateStepMethod())
              .addMethod(getChannelAcceptorMethod())
              .addMethod(getCloseChannelMethod())
              .addMethod(getAbandonChannelMethod())
              .addMethod(getSendPaymentMethod())
              .addMethod(getSendPaymentSyncMethod())
              .addMethod(getSendToRouteMethod())
              .addMethod(getSendToRouteSyncMethod())
              .addMethod(getAddInvoiceMethod())
              .addMethod(getListInvoicesMethod())
              .addMethod(getLookupInvoiceMethod())
              .addMethod(getSubscribeInvoicesMethod())
              .addMethod(getDecodePayReqMethod())
              .addMethod(getListPaymentsMethod())
              .addMethod(getDeleteAllPaymentsMethod())
              .addMethod(getDescribeGraphMethod())
              .addMethod(getGetNodeMetricsMethod())
              .addMethod(getGetChanInfoMethod())
              .addMethod(getGetNodeInfoMethod())
              .addMethod(getQueryRoutesMethod())
              .addMethod(getGetNetworkInfoMethod())
              .addMethod(getStopDaemonMethod())
              .addMethod(getSubscribeChannelGraphMethod())
              .addMethod(getDebugLevelMethod())
              .addMethod(getFeeReportMethod())
              .addMethod(getUpdateChannelPolicyMethod())
              .addMethod(getForwardingHistoryMethod())
              .addMethod(getExportChannelBackupMethod())
              .addMethod(getExportAllChannelBackupsMethod())
              .addMethod(getVerifyChanBackupMethod())
              .addMethod(getRestoreChannelBackupsMethod())
              .addMethod(getSubscribeChannelBackupsMethod())
              .addMethod(getBakeMacaroonMethod())
              .addMethod(getListMacaroonIDsMethod())
              .addMethod(getDeleteMacaroonIDMethod())
              .addMethod(getListPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
