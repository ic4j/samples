package org.ic4j.docutrack;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Get_alias_info_response {
  Ok,

  Err;

  @Name("Ok")
  @Field(Type.RECORD)
  public Get_alias_info_responseOkValue okValue;

  @Name("Err")
  @Field(Type.VARIANT)
  public Get_alias_info_responseErrValue errValue;
}
