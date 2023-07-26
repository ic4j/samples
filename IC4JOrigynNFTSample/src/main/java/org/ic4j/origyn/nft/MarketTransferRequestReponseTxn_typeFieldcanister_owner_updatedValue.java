package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class MarketTransferRequestReponseTxn_typeFieldcanister_owner_updatedValue {
  @Name("owner")
  @Field(Type.PRINCIPAL)
  public Principal owner;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensible;
}
