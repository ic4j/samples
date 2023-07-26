package org.ic4j.origyn.nft;

import java.lang.Boolean;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Collection_update_batch_nft_origynResponse {
  ok,

  err;

  @Name("ok")
  @Field(Type.BOOL)
  public Boolean okValue;

  @Name("err")
  @Field(Type.RECORD)
  public OrigynError errValue;
}
