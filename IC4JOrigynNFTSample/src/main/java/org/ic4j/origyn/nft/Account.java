package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public enum Account {
  account_id,

  principal,

  extensible,

  account;

  @Name("account_id")
  @Field(Type.TEXT)
  public String fieldaccount_idValue;

  @Name("principal")
  @Field(Type.PRINCIPAL)
  public Principal principalValue;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensibleValue;

  @Name("account")
  @Field(Type.RECORD)
  public AccountAccountValue accountValue;
}
