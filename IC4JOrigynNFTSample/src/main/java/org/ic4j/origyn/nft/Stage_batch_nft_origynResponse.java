package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Stage_batch_nft_origynResponse {
  ok,

  err;

  @Name("ok")
  @Field(Type.TEXT)
  public String okValue;

  @Name("err")
  @Field(Type.RECORD)
  public OrigynError errValue;
}
