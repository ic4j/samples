package org.ic4j.origyn.nft;

import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class WithdrawResponseTxn_typeMintValue {
  @Name("to")
  @Field(Type.VARIANT)
  public Account to;

  @Name("from")
  @Field(Type.VARIANT)
  public Account from;

  @Name("sale")
  @Field(Type.RECORD)
  public Optional<WithdrawResponseTxn_typeMintValueSale> sale;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensible;
}
