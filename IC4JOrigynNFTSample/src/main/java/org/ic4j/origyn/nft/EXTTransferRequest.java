package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.Byte;
import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class EXTTransferRequest {
  @Name("to")
  @Field(Type.VARIANT)
  public EXTUser to;

  @Name("token")
  @Field(Type.TEXT)
  public String token;

  @Name("notify")
  @Field(Type.BOOL)
  public Boolean notify;

  @Name("from")
  @Field(Type.VARIANT)
  public EXTUser from;

  @Name("memo")
  @Field(Type.NAT8)
  public Byte[] memo;

  @Name("subaccount")
  @Field(Type.RESERVED)
  public Optional<Object> subaccount;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;
}
