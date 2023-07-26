package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum MarketTransferResult {
  ok,

  err;

  @Name("ok")
  @Field(Type.RECORD)
  public MarketTransferRequestReponse okValue;

  @Name("err")
  @Field(Type.RECORD)
  public OrigynError errValue;
}
