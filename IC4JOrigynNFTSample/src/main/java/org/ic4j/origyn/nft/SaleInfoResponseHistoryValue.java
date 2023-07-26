package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class SaleInfoResponseHistoryValue {
  @Name("eof")
  @Field(Type.BOOL)
  public Boolean eof;

  @Name("records")
  @Field(Type.OPT)
  public Optional<SaleStatusStable>[] records;

  @Name("count")
  @Field(Type.NAT)
  public BigInteger count;
}
