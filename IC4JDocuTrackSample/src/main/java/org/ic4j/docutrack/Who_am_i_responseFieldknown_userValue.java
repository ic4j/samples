package org.ic4j.docutrack;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Who_am_i_responseFieldknown_userValue {
  @Name("username")
  @Field(Type.TEXT)
  public String username;
}
