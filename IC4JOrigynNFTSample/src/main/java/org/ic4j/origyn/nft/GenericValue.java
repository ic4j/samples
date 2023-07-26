package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.Byte;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Short;
import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public enum GenericValue {
  Nat64Content,

  Nat32Content,

  BoolContent,

  Nat8Content,

  Int64Content,

  IntContent,

  NatContent,

  Nat16Content,

  Int32Content,

  Int8Content,

  FloatContent,

  Int16Content,

  BlobContent,

  NestedContent,

  Principal,

  TextContent;

  @Name("Nat64Content")
  @Field(Type.NAT64)
  public Long nat64ContentValue;

  @Name("Nat32Content")
  @Field(Type.NAT32)
  public Integer nat32ContentValue;

  @Name("BoolContent")
  @Field(Type.BOOL)
  public Boolean boolContentValue;

  @Name("Nat8Content")
  @Field(Type.NAT8)
  public Byte nat8ContentValue;

  @Name("Int64Content")
  @Field(Type.INT64)
  public Long int64ContentValue;

  @Name("IntContent")
  @Field(Type.INT)
  public BigInteger intContentValue;

  @Name("NatContent")
  @Field(Type.NAT)
  public BigInteger natContentValue;

  @Name("Nat16Content")
  @Field(Type.NAT16)
  public Short nat16ContentValue;

  @Name("Int32Content")
  @Field(Type.INT32)
  public Integer int32ContentValue;

  @Name("Int8Content")
  @Field(Type.INT8)
  public Byte int8ContentValue;

  @Name("FloatContent")
  @Field(Type.FLOAT64)
  public Double floatContentValue;

  @Name("Int16Content")
  @Field(Type.INT16)
  public Short int16ContentValue;

  @Name("BlobContent")
  @Field(Type.NAT8)
  public Byte[] blobContentValue;

  @Name("NestedContent")
  @Field(Type.RECORD)
  public GenericValueNestedContentValue[] nestedContentValue;

  @Name("Principal")
  @Field(Type.PRINCIPAL)
  public Principal principalValue;

  @Name("TextContent")
  @Field(Type.TEXT)
  public String textContentValue;
}
