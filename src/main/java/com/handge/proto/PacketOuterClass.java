// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Packet.proto

package com.handge.proto;

public final class PacketOuterClass {
  private PacketOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_handge_proto_Packet_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_handge_proto_Packet_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Packet.proto\022\020com.handge.proto\"^\n\006Pack" +
      "et\022\024\n\014ipPorto2Name\030\001 \001(\t\022\r\n\005srcIp\030\002 \001(\t\022" +
      "\017\n\007srcPort\030\003 \001(\r\022\r\n\005dstIp\030\004 \001(\t\022\017\n\007dstPo" +
      "rt\030\005 \001(\rB\002P\001b\006proto3"
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
    internal_static_com_handge_proto_Packet_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_handge_proto_Packet_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_handge_proto_Packet_descriptor,
        new java.lang.String[] { "IpPorto2Name", "SrcIp", "SrcPort", "DstIp", "DstPort", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}