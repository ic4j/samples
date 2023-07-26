package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.lang.Short;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class HTTPResponse {
  @Name("body")
  @Field(Type.NAT8)
  public Byte[] body;

  @Name("headers")
  @Field(Type.RECORD)
  public HeaderField[] headers;

  @Name("streaming_strategy")
  @Field(Type.VARIANT)
  public Optional<StreamingStrategy> fieldstreaming_strategy;

  @Name("status_code")
  @Field(Type.NAT16)
  public Short fieldstatus_code;
}
