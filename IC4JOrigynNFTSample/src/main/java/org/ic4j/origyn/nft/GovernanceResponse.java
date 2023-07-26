package org.ic4j.origyn.nft;

import java.lang.Boolean;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum GovernanceResponse {
  update_system_var,

  clear_shared_wallets;

  @Name("update_system_var")
  @Field(Type.BOOL)
  public Boolean fieldupdate_system_varValue;

  @Name("clear_shared_wallets")
  @Field(Type.BOOL)
  public Boolean fieldclear_shared_walletsValue;
}
