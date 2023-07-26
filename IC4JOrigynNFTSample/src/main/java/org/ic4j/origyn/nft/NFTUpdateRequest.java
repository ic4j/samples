package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum NFTUpdateRequest {
  update,

  replace;

  @Name("update")
  @Field(Type.RECORD)
  public NFTUpdateRequestUpdateValue updateValue;

  @Name("replace")
  @Field(Type.RECORD)
  public NFTUpdateRequestReplaceValue replaceValue;
}
