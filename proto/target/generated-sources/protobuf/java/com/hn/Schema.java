// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema.proto

package com.hn;

public final class Schema {
  private Schema() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hn_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hn_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014schema.proto\022\006com.hn\"<\n\004User\022\020\n\010fullNa" +
      "me\030\001 \001(\t\022\020\n\010username\030\002 \001(\t\022\020\n\010itemType\030\003" +
      " \001(\t26\n\013UserService\022\'\n\007getUser\022\014.com.hn." +
      "User\032\014.com.hn.User\"\000B\002P\001b\006proto3"
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
    internal_static_com_hn_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_hn_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hn_User_descriptor,
        new java.lang.String[] { "FullName", "Username", "ItemType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
