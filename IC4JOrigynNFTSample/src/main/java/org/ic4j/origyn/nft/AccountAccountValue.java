package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class AccountAccountValue {
  @Name("owner")
  @Field(Type.PRINCIPAL)
  public Principal owner;

  @Name("sub_account")
  @Field(Type.VEC)
  public Optional<Byte[]> fieldsub_account;
}
