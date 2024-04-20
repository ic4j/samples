package org.ic4j.docutrack;

import java.lang.Long;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Get_alias_info_responseOkValue {
  @Name("user")
  @Field(Type.RECORD)
  public User user;

  @Name("file_name")
  @Field(Type.TEXT)
  public String fieldfile_name;

  @Name("file_id")
  @Field(Type.NAT64)
  public Long fieldfile_id;
}
