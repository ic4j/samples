package org.ic4j.docutrack;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Get_users_response {
  permission_error,

  users;

  @Name("users")
  @Field(Type.RECORD)
  public User[] usersValue;
}
