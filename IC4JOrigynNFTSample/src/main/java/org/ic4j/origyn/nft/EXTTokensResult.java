package org.ic4j.origyn.nft;

import java.lang.Object;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum EXTTokensResult {
  ok,

  err;

  @Name("ok")
  @Field(Type.RESERVED)
  public Object[] okValue;

  @Name("err")
  @Field(Type.VARIANT)
  public EXTCommonError errValue;
}
