package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum EXTMetadataResult {
  ok,

  err;

  @Name("ok")
  @Field(Type.VARIANT)
  public EXTMetadata okValue;

  @Name("err")
  @Field(Type.VARIANT)
  public EXTCommonError errValue;
}
