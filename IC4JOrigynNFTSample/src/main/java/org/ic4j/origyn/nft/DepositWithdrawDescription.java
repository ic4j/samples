package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class DepositWithdrawDescription {
  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("withdraw_to")
  @Field(Type.VARIANT)
  public Account fieldwithdraw_to;

  @Name("buyer")
  @Field(Type.VARIANT)
  public Account buyer;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;
}
