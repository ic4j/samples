package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Stage_library_batch_nft_origynResponse {
  ok,

  err;

  @Name("ok")
  @Field(Type.RECORD)
  public StageLibraryResponse okValue;

  @Name("err")
  @Field(Type.RECORD)
  public OrigynError errValue;
}
