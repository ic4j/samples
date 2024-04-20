package org.ic4j.docutrack;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Who_am_i_response {
  known_user,

  unknown_user;

  @Name("known_user")
  @Field(Type.RECORD)
  public Who_am_i_responseFieldknown_userValue fieldknown_userValue;
}
