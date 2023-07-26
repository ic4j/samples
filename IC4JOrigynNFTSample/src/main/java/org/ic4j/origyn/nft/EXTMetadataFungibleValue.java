package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class EXTMetadataFungibleValue {
  @Name("decimals")
  @Field(Type.NAT8)
  public Byte decimals;

  @Name("metadata")
  @Field(Type.VEC)
  public Optional<Byte[]> metadata;

  @Name("name")
  @Field(Type.TEXT)
  public String name;

  @Name("symbol")
  @Field(Type.TEXT)
  public String symbol;
}
