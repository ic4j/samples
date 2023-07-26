package org.ic4j.origyn.nft;

import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class AuctionConfig {
  @Name("start_price")
  @Field(Type.NAT)
  public BigInteger fieldstart_price;

  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("reserve")
  @Field(Type.NAT)
  public Optional<BigInteger> reserve;

  @Name("start_date")
  @Field(Type.INT)
  public BigInteger fieldstart_date;

  @Name("min_increase")
  @Field(Type.VARIANT)
  public AuctionConfigMin_increase fieldmin_increase;

  @Name("allow_list")
  @Field(Type.VEC)
  public Optional<Principal[]> fieldallow_list;

  @Name("buy_now")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldbuy_now;

  @Name("ending")
  @Field(Type.VARIANT)
  public AuctionConfigEnding ending;
}
