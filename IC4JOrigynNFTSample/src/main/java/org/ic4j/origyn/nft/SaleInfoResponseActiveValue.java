package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class SaleInfoResponseActiveValue {
  @Name("eof")
  @Field(Type.BOOL)
  public Boolean eof;

  @Name("records")
  @Field(Type.RECORD)
  public SaleInfoResponseActiveValueRecords[] records;

  @Name("count")
  @Field(Type.NAT)
  public BigInteger count;
}
