package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum TokenSpec {
  ic,

  extensible;

  @Name("ic")
  @Field(Type.RECORD)
  public ICTokenSpec icValue;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensibleValue;
}
