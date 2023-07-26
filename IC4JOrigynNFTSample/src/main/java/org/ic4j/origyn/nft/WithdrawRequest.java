package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum WithdrawRequest {
  reject,

  sale,

  deposit,

  escrow;

  @Name("reject")
  @Field(Type.RECORD)
  public RejectDescription rejectValue;

  @Name("sale")
  @Field(Type.RECORD)
  public WithdrawDescription saleValue;

  @Name("deposit")
  @Field(Type.RECORD)
  public DepositWithdrawDescription depositValue;

  @Name("escrow")
  @Field(Type.RECORD)
  public WithdrawDescription escrowValue;
}
