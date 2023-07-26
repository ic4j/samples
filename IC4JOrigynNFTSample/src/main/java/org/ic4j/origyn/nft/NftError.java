package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum NftError {
  UnauthorizedOperator,

  SelfTransfer,

  TokenNotFound,

  UnauthorizedOwner,

  TxNotFound,

  SelfApprove,

  OperatorNotFound,

  ExistedNFT,

  OwnerNotFound,

  Other;

  @Name("Other")
  @Field(Type.TEXT)
  public String otherValue;
}
