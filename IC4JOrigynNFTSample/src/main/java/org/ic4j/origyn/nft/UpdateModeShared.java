package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum UpdateModeShared {
  Set,

  Lock,

  Next;

  @Name("Set")
  @Field(Type.VARIANT)
  public CandyShared setValue;

  @Name("Lock")
  @Field(Type.VARIANT)
  public CandyShared lockValue;

  @Name("Next")
  @Field(Type.RECORD)
  public UpdateShared[] nextValue;
}
