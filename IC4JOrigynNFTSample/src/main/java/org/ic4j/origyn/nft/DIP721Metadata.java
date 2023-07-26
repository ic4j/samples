package org.ic4j.origyn.nft;

import java.lang.Long;
import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class DIP721Metadata {
  @Name("logo")
  @Field(Type.TEXT)
  public Optional<String> logo;

  @Name("name")
  @Field(Type.TEXT)
  public Optional<String> name;

  @Name("created_at")
  @Field(Type.NAT64)
  public Long fieldcreated_at;

  @Name("upgraded_at")
  @Field(Type.NAT64)
  public Long fieldupgraded_at;

  @Name("custodians")
  @Field(Type.PRINCIPAL)
  public Principal[] custodians;

  @Name("symbol")
  @Field(Type.TEXT)
  public Optional<String> symbol;
}
