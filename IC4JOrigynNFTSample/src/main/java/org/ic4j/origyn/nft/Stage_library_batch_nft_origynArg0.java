package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Stage_library_batch_nft_origynArg0 {
  @Name("content")
  @Field(Type.NAT8)
  public Byte[] content;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("chunk")
  @Field(Type.NAT)
  public BigInteger chunk;

  @Name("filedata")
  @Field(Type.VARIANT)
  public CandyShared filedata;

  @Name("library_id")
  @Field(Type.TEXT)
  public String fieldlibrary_id;
}
