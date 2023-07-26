package org.ic4j.origyn.nft;

import java.lang.Boolean;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum DIP721BoolResult {
  Ok,

  Err;

  @Name("Ok")
  @Field(Type.BOOL)
  public Boolean okValue;

  @Name("Err")
  @Field(Type.VARIANT)
  public NftError errValue;
}
