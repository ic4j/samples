package org.ic4j.origyn.nft;

import java.lang.Byte;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class SubAccountInfoAccount {
  @Name("principal")
  @Field(Type.PRINCIPAL)
  public Principal principal;

  @Name("sub_account")
  @Field(Type.NAT8)
  public Byte[] fieldsub_account;
}
