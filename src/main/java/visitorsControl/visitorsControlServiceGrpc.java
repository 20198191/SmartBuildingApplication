package visitorsControl;

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
    comments = "Source: visitorsControlService.proto")
public final class visitorsControlServiceGrpc {

  private visitorsControlServiceGrpc() {}

  public static final String SERVICE_NAME = "visitorsControl.visitorsControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<visitorsControl.VisitorRequest,
      visitorsControl.GuestBookServiceResponse> getRegisterVisitorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerVisitor",
      requestType = visitorsControl.VisitorRequest.class,
      responseType = visitorsControl.GuestBookServiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<visitorsControl.VisitorRequest,
      visitorsControl.GuestBookServiceResponse> getRegisterVisitorMethod() {
    io.grpc.MethodDescriptor<visitorsControl.VisitorRequest, visitorsControl.GuestBookServiceResponse> getRegisterVisitorMethod;
    if ((getRegisterVisitorMethod = visitorsControlServiceGrpc.getRegisterVisitorMethod) == null) {
      synchronized (visitorsControlServiceGrpc.class) {
        if ((getRegisterVisitorMethod = visitorsControlServiceGrpc.getRegisterVisitorMethod) == null) {
          visitorsControlServiceGrpc.getRegisterVisitorMethod = getRegisterVisitorMethod = 
              io.grpc.MethodDescriptor.<visitorsControl.VisitorRequest, visitorsControl.GuestBookServiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "visitorsControl.visitorsControlService", "registerVisitor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  visitorsControl.VisitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  visitorsControl.GuestBookServiceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new visitorsControlServiceMethodDescriptorSupplier("registerVisitor"))
                  .build();
          }
        }
     }
     return getRegisterVisitorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static visitorsControlServiceStub newStub(io.grpc.Channel channel) {
    return new visitorsControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static visitorsControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new visitorsControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static visitorsControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new visitorsControlServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class visitorsControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void registerVisitor(visitorsControl.VisitorRequest request,
        io.grpc.stub.StreamObserver<visitorsControl.GuestBookServiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterVisitorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterVisitorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                visitorsControl.VisitorRequest,
                visitorsControl.GuestBookServiceResponse>(
                  this, METHODID_REGISTER_VISITOR)))
          .build();
    }
  }

  /**
   */
  public static final class visitorsControlServiceStub extends io.grpc.stub.AbstractStub<visitorsControlServiceStub> {
    private visitorsControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private visitorsControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected visitorsControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new visitorsControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void registerVisitor(visitorsControl.VisitorRequest request,
        io.grpc.stub.StreamObserver<visitorsControl.GuestBookServiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterVisitorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class visitorsControlServiceBlockingStub extends io.grpc.stub.AbstractStub<visitorsControlServiceBlockingStub> {
    private visitorsControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private visitorsControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected visitorsControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new visitorsControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public visitorsControl.GuestBookServiceResponse registerVisitor(visitorsControl.VisitorRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterVisitorMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class visitorsControlServiceFutureStub extends io.grpc.stub.AbstractStub<visitorsControlServiceFutureStub> {
    private visitorsControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private visitorsControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected visitorsControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new visitorsControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<visitorsControl.GuestBookServiceResponse> registerVisitor(
        visitorsControl.VisitorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterVisitorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_VISITOR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final visitorsControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(visitorsControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_VISITOR:
          serviceImpl.registerVisitor((visitorsControl.VisitorRequest) request,
              (io.grpc.stub.StreamObserver<visitorsControl.GuestBookServiceResponse>) responseObserver);
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

  private static abstract class visitorsControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    visitorsControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return visitorsControl.visitorsControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("visitorsControlService");
    }
  }

  private static final class visitorsControlServiceFileDescriptorSupplier
      extends visitorsControlServiceBaseDescriptorSupplier {
    visitorsControlServiceFileDescriptorSupplier() {}
  }

  private static final class visitorsControlServiceMethodDescriptorSupplier
      extends visitorsControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    visitorsControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (visitorsControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new visitorsControlServiceFileDescriptorSupplier())
              .addMethod(getRegisterVisitorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
