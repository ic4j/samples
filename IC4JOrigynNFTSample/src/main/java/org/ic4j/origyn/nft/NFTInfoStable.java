package org.ic4j.origyn.nft;

import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class NFTInfoStable {
  @Name("metadata")
  @Field(Type.VARIANT)
  public CandyShared metadata;

  @Name("current_sale")
  @Field(Type.RECORD)
  public Optional<SaleStatusStable> fieldcurrent_sale;
}
