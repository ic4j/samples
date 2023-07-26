package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Sale_info_batch_secure_nft_origynResponse {
  ok,

  err;

  @Name("ok")
  @Field(Type.VARIANT)
  public SaleInfoResponse okValue;

  @Name("err")
  @Field(Type.RECORD)
  public OrigynError errValue;
}
