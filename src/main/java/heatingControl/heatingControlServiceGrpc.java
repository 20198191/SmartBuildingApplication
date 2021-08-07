package heatingControl;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: heatingControlService.proto")
public final class heatingControlServiceGrpc {

  private heatingControlServiceGrpc() {}

  public static final String SERVICE_NAME = "heatingControl.heatingControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<heatingControl.HeatingRequest,
      heatingControl.HeatingResponse> getChangeHeatingStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeHeatingStatus",
      requestType = heatingControl.HeatingRequest.class,
      responseType = heatingControl.HeatingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<heatingControl.HeatingRequest,
      heatingControl.HeatingResponse> getChangeHeatingStatusMethod() {
    io.grpc.MethodDescriptor<heatingControl.HeatingRequest, heatingControl.HeatingResponse> getChangeHeatingStatusMethod;
    if ((getChangeHeatingStatusMethod = heatingControlServiceGrpc.getChangeHeatingStatusMethod) == null) {
      synchronized (heatingControlServiceGrpc.class) {
        if ((getChangeHeatingStatusMethod = heatingControlServiceGrpc.getChangeHeatingStatusMethod) == null) {
          heatingControlServiceGrpc.getChangeHeatingStatusMethod = getChangeHeatingStatusMethod = 
              io.grpc.MethodDescriptor.<heatingControl.HeatingRequest, heatingControl.HeatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "heatingControl.heatingControlService", "changeHeatingStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  heatingControl.HeatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  heatingControl.HeatingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new heatingControlServiceMethodDescriptorSupplier("changeHeatingStatus"))
                  .build();
          }
        }
     }
     return getChangeHeatingStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static heatingControlServiceStub newStub(io.grpc.Channel channel) {
    return new heatingControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static heatingControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new heatingControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static heatingControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new heatingControlServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class heatingControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Client Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<heatingControl.HeatingRequest> changeHeatingStatus(
        io.grpc.stub.StreamObserver<heatingControl.HeatingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChangeHeatingStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getChangeHeatingStatusMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                heatingControl.HeatingRequest,
                heatingControl.HeatingResponse>(
                  this, METHODID_CHANGE_HEATING_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class heatingControlServiceStub extends io.grpc.stub.AbstractStub<heatingControlServiceStub> {
    private heatingControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private heatingControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected heatingControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new heatingControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<heatingControl.HeatingRequest> changeHeatingStatus(
        io.grpc.stub.StreamObserver<heatingControl.HeatingResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getChangeHeatingStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class heatingControlServiceBlockingStub extends io.grpc.stub.AbstractStub<heatingControlServiceBlockingStub> {
    private heatingControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private heatingControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected heatingControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new heatingControlServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class heatingControlServiceFutureStub extends io.grpc.stub.AbstractStub<heatingControlServiceFutureStub> {
    private heatingControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private heatingControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected heatingControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new heatingControlServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHANGE_HEATING_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final heatingControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(heatingControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHANGE_HEATING_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.changeHeatingStatus(
              (io.grpc.stub.StreamObserver<heatingControl.HeatingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class heatingControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    heatingControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return heatingControl.heatingControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("heatingControlService");
    }
  }

  private static final class heatingControlServiceFileDescriptorSupplier
      extends heatingControlServiceBaseDescriptorSupplier {
    heatingControlServiceFileDescriptorSupplier() {}
  }

  private static final class heatingControlServiceMethodDescriptorSupplier
      extends heatingControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    heatingControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (heatingControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new heatingControlServiceFileDescriptorSupplier())
              .addMethod(getChangeHeatingStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
