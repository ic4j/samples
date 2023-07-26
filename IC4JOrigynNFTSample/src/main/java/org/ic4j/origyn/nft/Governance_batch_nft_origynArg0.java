package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Governance_batch_nft_origynArg0 {
  update_system_var,

  clear_shared_wallets;

  @Name("update_system_var")
  @Field(Type.RECORD)
  public GovernanceRequestFieldupdate_system_varValue fieldupdate_system_varValue;

  @Name("clear_shared_wallets")
  @Field(Type.TEXT)
  public String fieldclear_shared_walletsValue;
}
