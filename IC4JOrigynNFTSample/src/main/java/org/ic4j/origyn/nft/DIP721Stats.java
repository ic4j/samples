package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class DIP721Stats {
  @Name("cycles")
  @Field(Type.NAT)
  public BigInteger cycles;

  @Name("total_transactions")
  @Field(Type.NAT)
  public BigInteger fieldtotal_transactions;

  @Name("total_unique_holders")
  @Field(Type.NAT)
  public BigInteger fieldtotal_unique_holders;

  @Name("total_supply")
  @Field(Type.NAT)
  public BigInteger fieldtotal_supply;
}
