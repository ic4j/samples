package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum AuctionConfigEnding {
  waitForQuiet,

  date;

  @Name("waitForQuiet")
  @Field(Type.RECORD)
  public AuctionConfigEndingWaitForQuietValue waitForQuietValue;

  @Name("date")
  @Field(Type.INT)
  public BigInteger dateValue;
}
