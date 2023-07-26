package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.lang.Object;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class HttpRequest {
  @Name("url")
  @Field(Type.TEXT)
  public String url;

  @Name("method")
  @Field(Type.TEXT)
  public String method;

  @Name("body")
  @Field(Type.NAT8)
  public Byte[] body;

  @Name("headers")
  @Field(Type.RESERVED)
  public Object[] headers;
}
