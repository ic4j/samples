package org.ic4j.origyn.nft;

import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class SaleInfoResponseActiveValueRecords {
  @Name("0")
  @Field(Type.TEXT)
  public String field0;

  @Name("1")
  @Field(Type.RECORD)
  public Optional<SaleStatusStable> field1;
}
