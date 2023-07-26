package org.ic4j.origyn.nft;

import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum SaleInfoResponse {
  status,

  active,

  deposit_info,

  history;

  @Name("status")
  @Field(Type.RECORD)
  public Optional<SaleStatusStable> statusValue;

  @Name("active")
  @Field(Type.RECORD)
  public SaleInfoResponseActiveValue activeValue;

  @Name("deposit_info")
  @Field(Type.RECORD)
  public SubAccountInfo fielddeposit_infoValue;

  @Name("history")
  @Field(Type.RECORD)
  public SaleInfoResponseHistoryValue historyValue;
}
