package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class MarketTransferRequestReponseTxn_typeDataValue {
  @Name("hash")
  @Field(Type.VEC)
  public Optional<Byte[]> hash;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensible;

  @Name("data_dapp")
  @Field(Type.TEXT)
  public Optional<String> fielddata_dapp;

  @Name("data_path")
  @Field(Type.TEXT)
  public Optional<String> fielddata_path;
}
