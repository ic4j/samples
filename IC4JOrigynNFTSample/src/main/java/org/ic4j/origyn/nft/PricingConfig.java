package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum PricingConfig {
  flat,

  extensible,

  instant,

  nifty,

  auction,

  dutch;

  @Name("flat")
  @Field(Type.RECORD)
  public PricingConfigFlatValue flatValue;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensibleValue;

  @Name("nifty")
  @Field(Type.RECORD)
  public NiftyConfig niftyValue;

  @Name("auction")
  @Field(Type.RECORD)
  public AuctionConfig auctionValue;

  @Name("dutch")
  @Field(Type.RECORD)
  public DutchConfig dutchValue;
}
