package lightsControl;

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
    comments = "Source: lightsControlService.proto")
public final class lightsControlServiceGrpc {

  private lightsControlServiceGrpc() {}

  public static final String SERVICE_NAME = "lightsControl.lightsControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<lightsControl.LightRequest,
      lightsControl.LightResponse> getReadRoomLightStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readRoomLightStatus",
      requestType = lightsControl.LightRequest.class,
      responseType = lightsControl.LightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<lightsControl.LightRequest,
      lightsControl.LightResponse> getReadRoomLightStatusMethod() {
    io.grpc.MethodDescriptor<lightsControl.LightRequest, lightsControl.LightResponse> getReadRoomLightStatusMethod;
    if ((getReadRoomLightStatusMethod = lightsControlServiceGrpc.getReadRoomLightStatusMethod) == null) {
      synchronized (lightsControlServiceGrpc.class) {
        if ((getReadRoomLightStatusMethod = lightsControlServiceGrpc.getReadRoomLightStatusMethod) == null) {
          lightsControlServiceGrpc.getReadRoomLightStatusMethod = getReadRoomLightStatusMethod = 
              io.grpc.MethodDescriptor.<lightsControl.LightRequest, lightsControl.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lightsControl.lightsControlService", "readRoomLightStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lightsControl.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lightsControl.LightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new lightsControlServiceMethodDescriptorSupplier("readRoomLightStatus"))
                  .build();
          }
        }
     }
     return getReadRoomLightStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static lightsControlServiceStub newStub(io.grpc.Channel channel) {
    return new lightsControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static lightsControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new lightsControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static lightsControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new lightsControlServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class lightsControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Bidirectional Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lightsControl.LightRequest> readRoomLightStatus(
        io.grpc.stub.StreamObserver<lightsControl.LightResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getReadRoomLightStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReadRoomLightStatusMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                lightsControl.LightRequest,
                lightsControl.LightResponse>(
                  this, METHODID_READ_ROOM_LIGHT_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class lightsControlServiceStub extends io.grpc.stub.AbstractStub<lightsControlServiceStub> {
    private lightsControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightsControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightsControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightsControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bidirectional Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lightsControl.LightRequest> readRoomLightStatus(
        io.grpc.stub.StreamObserver<lightsControl.LightResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getReadRoomLightStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class lightsControlServiceBlockingStub extends io.grpc.stub.AbstractStub<lightsControlServiceBlockingStub> {
    private lightsControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightsControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightsControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightsControlServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class lightsControlServiceFutureStub extends io.grpc.stub.AbstractStub<lightsControlServiceFutureStub> {
    private lightsControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightsControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightsControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightsControlServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_READ_ROOM_LIGHT_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final lightsControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(lightsControlServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_READ_ROOM_LIGHT_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.readRoomLightStatus(
              (io.grpc.stub.StreamObserver<lightsControl.LightResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class lightsControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    lightsControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return lightsControl.lightsControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("lightsControlService");
    }
  }

  private static final class lightsControlServiceFileDescriptorSupplier
      extends lightsControlServiceBaseDescriptorSupplier {
    lightsControlServiceFileDescriptorSupplier() {}
  }

  private static final class lightsControlServiceMethodDescriptorSupplier
      extends lightsControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    lightsControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (lightsControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new lightsControlServiceFileDescriptorSupplier())
              .addMethod(getReadRoomLightStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
