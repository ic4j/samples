package org.ic4j.origyn.nft;

import java.lang.Object;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class SalesConfig {
  @Name("broker_id")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldbroker_id;

  @Name("pricing")
  @Field(Type.VARIANT)
  public PricingConfig pricing;

  @Name("escrow_receipt")
  @Field(Type.RESERVED)
  public Optional<Object> fieldescrow_receipt;
}
