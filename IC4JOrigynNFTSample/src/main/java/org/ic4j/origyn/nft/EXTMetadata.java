package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum EXTMetadata {
  fungible,

  nonfungible;

  @Name("fungible")
  @Field(Type.RECORD)
  public EXTMetadataFungibleValue fungibleValue;

  @Name("nonfungible")
  @Field(Type.RECORD)
  public EXTMetadataNonfungibleValue nonfungibleValue;
}
