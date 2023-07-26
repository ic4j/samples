package org.ic4j.origyn.nft;

import java.lang.Object;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class AuctionStateStable {
  @Name("status")
  @Field(Type.VARIANT)
  public AuctionStateStableStatus status;

  @Name("participants")
  @Field(Type.RECORD)
  public AuctionStateStableParticipants[] participants;

  @Name("current_bid_amount")
  @Field(Type.NAT)
  public BigInteger fieldcurrent_bid_amount;

  @Name("winner")
  @Field(Type.RESERVED)
  public Optional<Object> winner;

  @Name("end_date")
  @Field(Type.INT)
  public BigInteger fieldend_date;

  @Name("wait_for_quiet_count")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldwait_for_quiet_count;

  @Name("current_escrow")
  @Field(Type.RECORD)
  public Optional<EscrowReceipt> fieldcurrent_escrow;

  @Name("allow_list")
  @Field(Type.VEC)
  public Optional<AuctionStateStableAllow_list[]> fieldallow_list;

  @Name("current_broker_id")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldcurrent_broker_id;

  @Name("min_next_bid")
  @Field(Type.NAT)
  public BigInteger fieldmin_next_bid;

  @Name("config")
  @Field(Type.VARIANT)
  public PricingConfig config;
}
