package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class BalanceResponseOffers {
  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("seller")
  @Field(Type.VARIANT)
  public Account seller;

  @Name("lock_to_date")
  @Field(Type.INT)
  public Optional<BigInteger> fieldlock_to_date;

  @Name("buyer")
  @Field(Type.VARIANT)
  public Account buyer;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;

  @Name("sale_id")
  @Field(Type.TEXT)
  public Optional<String> fieldsale_id;

  @Name("account_hash")
  @Field(Type.VEC)
  public Optional<Byte[]> fieldaccount_hash;
}
