package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum SaleInfoResponseStatusValueSale_type {
  nifty,

  auction,

  dutch;

  @Name("nifty")
  @Field(Type.RECORD)
  public NiftyStateStable niftyValue;

  @Name("auction")
  @Field(Type.RECORD)
  public AuctionStateStable auctionValue;

  @Name("dutch")
  @Field(Type.RECORD)
  public DutchStateStable dutchValue;
}
