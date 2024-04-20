package org.ic4j.docutrack;

import java.lang.Long;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class File_statusPendingValue {
  @Name("alias")
  @Field(Type.TEXT)
  public String alias;

  @Name("requested_at")
  @Field(Type.NAT64)
  public Long fieldrequested_at;
}
