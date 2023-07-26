package org.ic4j.origyn.nft;

import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public enum OwnerOfResponse {
  Ok,

  Err;

  @Name("Ok")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> okValue;

  @Name("Err")
  @Field(Type.VARIANT)
  public NftError errValue;
}
