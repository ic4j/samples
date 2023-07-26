package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class WithdrawResponseTxn_typeFieldcanister_network_updatedValue {
  @Name("network")
  @Field(Type.PRINCIPAL)
  public Principal network;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensible;
}
