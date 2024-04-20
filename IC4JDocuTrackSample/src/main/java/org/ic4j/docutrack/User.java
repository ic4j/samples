package org.ic4j.docutrack;

import java.lang.Byte;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class User {
  @Name("username")
  @Field(Type.TEXT)
  public String username;

  @Name("public_key")
  @Field(Type.NAT8)
  public Byte[] fieldpublic_key;

  @Name("ic_principal")
  @Field(Type.PRINCIPAL)
  public Principal fieldic_principal;
}
