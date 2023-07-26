package org.ic4j.origyn.nft;

import java.lang.Object;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class NiftyStateStable {
  @Name("status")
  @Field(Type.VARIANT)
  public NiftyStateStableStatus status;

  @Name("min_bid")
  @Field(Type.NAT)
  public BigInteger fieldmin_bid;

  @Name("winner")
  @Field(Type.RESERVED)
  public Optional<Object> winner;

  @Name("end_date")
  @Field(Type.INT)
  public BigInteger fieldend_date;

  @Name("allow_list")
  @Field(Type.VEC)
  public Optional<NiftyStateStableAllow_list[]> fieldallow_list;

  @Name("current_broker_id")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldcurrent_broker_id;

  @Name("config")
  @Field(Type.VARIANT)
  public PricingConfig config;
}
