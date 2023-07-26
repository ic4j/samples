package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum EXTBalanceResult {
  ok,

  err;

  @Name("ok")
  @Field(Type.NAT)
  public BigInteger okValue;

  @Name("err")
  @Field(Type.VARIANT)
  public EXTCommonError errValue;
}
