package org.ic4j.origyn.nft;

import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class BalanceResponse {
  @Name("nfts")
  @Field(Type.TEXT)
  public String[] nfts;

  @Name("offers")
  @Field(Type.RECORD)
  public EscrowRecord[] offers;

  @Name("sales")
  @Field(Type.RECORD)
  public EscrowRecord[] sales;

  @Name("stake")
  @Field(Type.RECORD)
  public StakeRecord[] stake;

  @Name("multi_canister")
  @Field(Type.VEC)
  public Optional<Principal[]> fieldmulti_canister;

  @Name("escrow")
  @Field(Type.RECORD)
  public EscrowRecord[] escrow;
}
