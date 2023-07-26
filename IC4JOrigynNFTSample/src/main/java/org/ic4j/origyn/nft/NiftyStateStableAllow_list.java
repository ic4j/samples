package org.ic4j.origyn.nft;

import java.lang.Boolean;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class NiftyStateStableAllow_list {
  @Name("0")
  @Field(Type.PRINCIPAL)
  public Principal field0;

  @Name("1")
  @Field(Type.BOOL)
  public Boolean field1;
}
