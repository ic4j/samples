package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum History_batch_nft_origynResponse {
  ok,

  err;

  @Name("ok")
  @Field(Type.RECORD)
  public History_batch_nft_origynResponseOkValue[] okValue;

  @Name("err")
  @Field(Type.RECORD)
  public OrigynError errValue;
}
