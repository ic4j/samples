package org.ic4j.origyn.nft;

import java.lang.Object;
import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum SaleInfoRequest {
  status,

  active,

  deposit_info,

  history;

  @Name("status")
  @Field(Type.TEXT)
  public String statusValue;

  @Name("active")
  @Field(Type.RECORD)
  public Optional<SaleInfoRequestActiveValue> activeValue;

  @Name("deposit_info")
  @Field(Type.RESERVED)
  public Optional<Object> fielddeposit_infoValue;

  @Name("history")
  @Field(Type.RECORD)
  public Optional<SaleInfoRequestHistoryValue> historyValue;
}
