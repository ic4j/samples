package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class EndSaleResponseTxn_typeMintValueSale {
  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;
}
