package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class GovernanceRequestFieldupdate_system_varValue {
  @Name("key")
  @Field(Type.TEXT)
  public String key;

  @Name("val")
  @Field(Type.VARIANT)
  public CandyShared val;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;
}
