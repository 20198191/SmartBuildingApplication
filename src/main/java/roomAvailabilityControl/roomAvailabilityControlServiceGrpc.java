package roomAvailabilityControl;

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
    comments = "Source: roomAvailabilityControlService.proto")
public final class roomAvailabilityControlServiceGrpc {

  private roomAvailabilityControlServiceGrpc() {}

  public static final String SERVICE_NAME = "roomAvailabilityControl.roomAvailabilityControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<roomAvailabilityControl.EmptyRequest,
      roomAvailabilityControl.RoomResponse> getGetRoomStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRoomStatus",
      requestType = roomAvailabilityControl.EmptyRequest.class,
      responseType = roomAvailabilityControl.RoomResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<roomAvailabilityControl.EmptyRequest,
      roomAvailabilityControl.RoomResponse> getGetRoomStatusMethod() {
    io.grpc.MethodDescriptor<roomAvailabilityControl.EmptyRequest, roomAvailabilityControl.RoomResponse> getGetRoomStatusMethod;
    if ((getGetRoomStatusMethod = roomAvailabilityControlServiceGrpc.getGetRoomStatusMethod) == null) {
      synchronized (roomAvailabilityControlServiceGrpc.class) {
        if ((getGetRoomStatusMethod = roomAvailabilityControlServiceGrpc.getGetRoomStatusMethod) == null) {
          roomAvailabilityControlServiceGrpc.getGetRoomStatusMethod = getGetRoomStatusMethod = 
              io.grpc.MethodDescriptor.<roomAvailabilityControl.EmptyRequest, roomAvailabilityControl.RoomResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "roomAvailabilityControl.roomAvailabilityControlService", "getRoomStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  roomAvailabilityControl.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  roomAvailabilityControl.RoomResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new roomAvailabilityControlServiceMethodDescriptorSupplier("getRoomStatus"))
                  .build();
          }
        }
     }
     return getGetRoomStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static roomAvailabilityControlServiceStub newStub(io.grpc.Channel channel) {
    return new roomAvailabilityControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static roomAvailabilityControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new roomAvailabilityControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static roomAvailabilityControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new roomAvailabilityControlServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class roomAvailabilityControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Server Streaming RPC
     * </pre>
     */
    public void getRoomStatus(roomAvailabilityControl.EmptyRequest request,
        io.grpc.stub.StreamObserver<roomAvailabilityControl.RoomResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRoomStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRoomStatusMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                roomAvailabilityControl.EmptyRequest,
                roomAvailabilityControl.RoomResponse>(
                  this, METHODID_GET_ROOM_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class roomAvailabilityControlServiceStub extends io.grpc.stub.AbstractStub<roomAvailabilityControlServiceStub> {
    private roomAvailabilityControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private roomAvailabilityControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected roomAvailabilityControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new roomAvailabilityControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming RPC
     * </pre>
     */
    public void getRoomStatus(roomAvailabilityControl.EmptyRequest request,
        io.grpc.stub.StreamObserver<roomAvailabilityControl.RoomResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetRoomStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class roomAvailabilityControlServiceBlockingStub extends io.grpc.stub.AbstractStub<roomAvailabilityControlServiceBlockingStub> {
    private roomAvailabilityControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private roomAvailabilityControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected roomAvailabilityControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new roomAvailabilityControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming RPC
     * </pre>
     */
    public java.util.Iterator<roomAvailabilityControl.RoomResponse> getRoomStatus(
        roomAvailabilityControl.EmptyRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetRoomStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class roomAvailabilityControlServiceFutureStub extends io.grpc.stub.AbstractStub<roomAvailabilityControlServiceFutureStub> {
    private roomAvailabilityControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private roomAvailabilityControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected roomAvailabilityControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new roomAvailabilityControlServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_ROOM_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final roomAvailabilityControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(roomAvailabilityControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ROOM_STATUS:
          serviceImpl.getRoomStatus((roomAvailabilityControl.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<roomAvailabilityControl.RoomResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class roomAvailabilityControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    roomAvailabilityControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return roomAvailabilityControl.roomAvailabilityControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("roomAvailabilityControlService");
    }
  }

  private static final class roomAvailabilityControlServiceFileDescriptorSupplier
      extends roomAvailabilityControlServiceBaseDescriptorSupplier {
    roomAvailabilityControlServiceFileDescriptorSupplier() {}
  }

  private static final class roomAvailabilityControlServiceMethodDescriptorSupplier
      extends roomAvailabilityControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    roomAvailabilityControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (roomAvailabilityControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new roomAvailabilityControlServiceFileDescriptorSupplier())
              .addMethod(getGetRoomStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
