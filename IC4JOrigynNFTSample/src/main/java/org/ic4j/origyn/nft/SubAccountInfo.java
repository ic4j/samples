package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class SubAccountInfo {
  @Name("account_id")
  @Field(Type.NAT8)
  public Byte[] fieldaccount_id;

  @Name("principal")
  @Field(Type.PRINCIPAL)
  public Principal principal;

  @Name("account_id_text")
  @Field(Type.TEXT)
  public String fieldaccount_id_text;

  @Name("account")
  @Field(Type.RECORD)
  public SubAccountInfoAccount account;
}
