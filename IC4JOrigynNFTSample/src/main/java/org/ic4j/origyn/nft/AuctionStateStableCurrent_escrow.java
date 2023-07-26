package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class AuctionStateStableCurrent_escrow {
  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("seller")
  @Field(Type.VARIANT)
  public Account seller;

  @Name("buyer")
  @Field(Type.VARIANT)
  public Account buyer;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;
}
