package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class NFTBackupChunk {
  @Name("sales_balances")
  @Field(Type.RECORD)
  public NFTBackupChunkSales_balances[] fieldsales_balances;

  @Name("offers")
  @Field(Type.RECORD)
  public NFTBackupChunkOffers[] offers;

  @Name("collection_data")
  @Field(Type.RECORD)
  public StableCollectionData fieldcollection_data;

  @Name("nft_ledgers")
  @Field(Type.RECORD)
  public NFTBackupChunkNft_ledgers[] fieldnft_ledgers;

  @Name("canister")
  @Field(Type.PRINCIPAL)
  public Principal canister;

  @Name("allocations")
  @Field(Type.RECORD)
  public NFTBackupChunkAllocations[] allocations;

  @Name("nft_sales")
  @Field(Type.RECORD)
  public NFTBackupChunkNft_sales[] fieldnft_sales;

  @Name("buckets")
  @Field(Type.RECORD)
  public NFTBackupChunkBuckets[] buckets;

  @Name("escrow_balances")
  @Field(Type.RECORD)
  public NFTBackupChunkEscrow_balances[] fieldescrow_balances;
}
