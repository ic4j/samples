package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.Long;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class TokenMetadata {
  @Name("transferred_at")
  @Field(Type.NAT64)
  public Optional<Long> fieldtransferred_at;

  @Name("transferred_by")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldtransferred_by;

  @Name("owner")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> owner;

  @Name("operator")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> operator;

  @Name("approved_at")
  @Field(Type.NAT64)
  public Optional<Long> fieldapproved_at;

  @Name("approved_by")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldapproved_by;

  @Name("properties")
  @Field(Type.RECORD)
  public TokenMetadataProperties[] properties;

  @Name("is_burned")
  @Field(Type.BOOL)
  public Boolean fieldis_burned;

  @Name("token_identifier")
  @Field(Type.NAT)
  public BigInteger fieldtoken_identifier;

  @Name("burned_at")
  @Field(Type.NAT64)
  public Optional<Long> fieldburned_at;

  @Name("burned_by")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldburned_by;

  @Name("minted_at")
  @Field(Type.NAT64)
  public Long fieldminted_at;

  @Name("minted_by")
  @Field(Type.PRINCIPAL)
  public Principal fieldminted_by;
}
