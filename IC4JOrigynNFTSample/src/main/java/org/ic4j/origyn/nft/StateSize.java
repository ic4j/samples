package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class StateSize {
  @Name("sales_balances")
  @Field(Type.NAT)
  public BigInteger fieldsales_balances;

  @Name("offers")
  @Field(Type.NAT)
  public BigInteger offers;

  @Name("nft_ledgers")
  @Field(Type.NAT)
  public BigInteger fieldnft_ledgers;

  @Name("allocations")
  @Field(Type.NAT)
  public BigInteger allocations;

  @Name("nft_sales")
  @Field(Type.NAT)
  public BigInteger fieldnft_sales;

  @Name("buckets")
  @Field(Type.NAT)
  public BigInteger buckets;

  @Name("escrow_balances")
  @Field(Type.NAT)
  public BigInteger fieldescrow_balances;
}
