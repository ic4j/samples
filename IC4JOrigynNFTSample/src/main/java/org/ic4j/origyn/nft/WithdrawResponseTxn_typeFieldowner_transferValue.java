package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class WithdrawResponseTxn_typeFieldowner_transferValue {
  @Name("to")
  @Field(Type.VARIANT)
  public Account to;

  @Name("from")
  @Field(Type.VARIANT)
  public Account from;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensible;
}
