package org.ic4j.origyn.nft;

import java.lang.Long;
import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class CanisterLogMessagesData {
  @Name("data")
  @Field(Type.VARIANT)
  public Data data;

  @Name("timeNanos")
  @Field(Type.NAT64)
  public Long timeNanos;

  @Name("message")
  @Field(Type.TEXT)
  public String message;

  @Name("caller")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> caller;
}
