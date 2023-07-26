package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum DIP721TokensMetadata {
  Ok,

  Err;

  @Name("Ok")
  @Field(Type.RECORD)
  public TokenMetadata[] okValue;

  @Name("Err")
  @Field(Type.VARIANT)
  public NftError errValue;
}
