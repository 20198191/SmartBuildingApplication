// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: roomAvailabilityControlService.proto

package roomAvailabilityControl;

public final class roomAvailabilityControlServiceImpl {
  private roomAvailabilityControlServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_roomAvailabilityControl_EmptyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_roomAvailabilityControl_EmptyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_roomAvailabilityControl_RoomResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_roomAvailabilityControl_RoomResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n$roomAvailabilityControlService.proto\022\027" +
      "roomAvailabilityControl\"\016\n\014EmptyRequest\"" +
      "6\n\014RoomResponse\022\022\n\nroomNumber\030\001 \001(\005\022\022\n\nr" +
      "oomStatus\030\002 \001(\t2\203\001\n\036roomAvailabilityCont" +
      "rolService\022a\n\rgetRoomStatus\022%.roomAvaila" +
      "bilityControl.EmptyRequest\032%.roomAvailab" +
      "ilityControl.RoomResponse\"\0000\001B&B\"roomAva" +
      "ilabilityControlServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_roomAvailabilityControl_EmptyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_roomAvailabilityControl_EmptyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_roomAvailabilityControl_EmptyRequest_descriptor,
        new java.lang.String[] { });
    internal_static_roomAvailabilityControl_RoomResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_roomAvailabilityControl_RoomResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_roomAvailabilityControl_RoomResponse_descriptor,
        new java.lang.String[] { "RoomNumber", "RoomStatus", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}