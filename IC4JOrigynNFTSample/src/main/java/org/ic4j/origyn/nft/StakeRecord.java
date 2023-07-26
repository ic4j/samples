package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class StakeRecord {
  @Name("staker")
  @Field(Type.VARIANT)
  public Account staker;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;
}
