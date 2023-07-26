package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class EscrowRequest {
  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("deposit")
  @Field(Type.RECORD)
  public DepositDetail deposit;

  @Name("lock_to_date")
  @Field(Type.INT)
  public Optional<BigInteger> fieldlock_to_date;
}
