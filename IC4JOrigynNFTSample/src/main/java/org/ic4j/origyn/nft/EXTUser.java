package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public enum EXTUser {
  principal,

  address;

  @Name("principal")
  @Field(Type.PRINCIPAL)
  public Principal principalValue;

  @Name("address")
  @Field(Type.TEXT)
  public String addressValue;
}
