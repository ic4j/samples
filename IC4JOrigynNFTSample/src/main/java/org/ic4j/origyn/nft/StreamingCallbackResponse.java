package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class StreamingCallbackResponse {
  @Name("token")
  @Field(Type.RECORD)
  public Optional<StreamingCallbackToken> token;

  @Name("body")
  @Field(Type.NAT8)
  public Byte[] body;
}
