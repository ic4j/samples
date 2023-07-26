package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum ICTokenSpecStandard {
  ICRC1,

  EXTFungible,

  DIP20,

  Other,

  Ledger;

  @Name("Other")
  @Field(Type.VARIANT)
  public CandyShared otherValue;
}
