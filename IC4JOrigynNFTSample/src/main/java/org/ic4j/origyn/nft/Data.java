package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.Byte;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Short;
import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public enum Data {
  Int,

  Map,

  Nat,

  Set,

  Nat16,

  Nat32,

  Nat64,

  Blob,

  Bool,

  Int8,

  Ints,

  Nat8,

  Nats,

  Text,

  Bytes,

  Int16,

  Int32,

  Int64,

  Option,

  Floats,

  Float,

  Principal,

  Array,

  Class;

  @Name("Int")
  @Field(Type.INT)
  public BigInteger intValue;

  @Name("Map")
  @Field(Type.RECORD)
  public DataMapValue[] mapValue;

  @Name("Nat")
  @Field(Type.NAT)
  public BigInteger natValue;

  @Name("Set")
  @Field(Type.RESERVED)
  public Object[] setValue;

  @Name("Nat16")
  @Field(Type.NAT16)
  public Short nat16Value;

  @Name("Nat32")
  @Field(Type.NAT32)
  public Integer nat32Value;

  @Name("Nat64")
  @Field(Type.NAT64)
  public Long nat64Value;

  @Name("Blob")
  @Field(Type.NAT8)
  public Byte[] blobValue;

  @Name("Bool")
  @Field(Type.BOOL)
  public Boolean boolValue;

  @Name("Int8")
  @Field(Type.INT8)
  public Byte int8Value;

  @Name("Ints")
  @Field(Type.INT)
  public BigInteger[] intsValue;

  @Name("Nat8")
  @Field(Type.NAT8)
  public Byte nat8Value;

  @Name("Nats")
  @Field(Type.NAT)
  public BigInteger[] natsValue;

  @Name("Text")
  @Field(Type.TEXT)
  public String textValue;

  @Name("Bytes")
  @Field(Type.NAT8)
  public Byte[] bytesValue;

  @Name("Int16")
  @Field(Type.INT16)
  public Short int16Value;

  @Name("Int32")
  @Field(Type.INT32)
  public Integer int32Value;

  @Name("Int64")
  @Field(Type.INT64)
  public Long int64Value;

  @Name("Option")
  @Field(Type.RESERVED)
  public Optional<Object> optionValue;

  @Name("Floats")
  @Field(Type.FLOAT64)
  public Double[] floatsValue;

  @Name("Float")
  @Field(Type.FLOAT64)
  public Double floatValue;

  @Name("Principal")
  @Field(Type.PRINCIPAL)
  public Principal principalValue;

  @Name("Array")
  @Field(Type.RESERVED)
  public Object[] arrayValue;

  @Name("Class")
  @Field(Type.RECORD)
  public PropertyShared[] classValue;
}
