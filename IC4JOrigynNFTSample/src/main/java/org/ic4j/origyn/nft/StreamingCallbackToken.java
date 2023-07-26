package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class StreamingCallbackToken {
  @Name("key")
  @Field(Type.TEXT)
  public String key;

  @Name("index")
  @Field(Type.NAT)
  public BigInteger index;

  @Name("content_encoding")
  @Field(Type.TEXT)
  public String fieldcontent_encoding;
}
