package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum BidResponseTxn_type {
  escrow_deposit,

  canister_network_updated,

  escrow_withdraw,

  canister_managers_updated,

  auction_bid,

  burn,

  data,

  sale_ended,

  mint,

  royalty_paid,

  extensible,

  owner_transfer,

  sale_opened,

  canister_owner_updated,

  sale_withdraw,

  deposit_withdraw;

  @Name("escrow_deposit")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldescrow_depositValue fieldescrow_depositValue;

  @Name("canister_network_updated")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldcanister_network_updatedValue fieldcanister_network_updatedValue;

  @Name("escrow_withdraw")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldescrow_withdrawValue fieldescrow_withdrawValue;

  @Name("canister_managers_updated")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldcanister_managers_updatedValue fieldcanister_managers_updatedValue;

  @Name("auction_bid")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldauction_bidValue fieldauction_bidValue;

  @Name("burn")
  @Field(Type.RECORD)
  public BidResponseTxn_typeBurnValue burnValue;

  @Name("data")
  @Field(Type.RECORD)
  public BidResponseTxn_typeDataValue dataValue;

  @Name("sale_ended")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldsale_endedValue fieldsale_endedValue;

  @Name("mint")
  @Field(Type.RECORD)
  public BidResponseTxn_typeMintValue mintValue;

  @Name("royalty_paid")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldroyalty_paidValue fieldroyalty_paidValue;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensibleValue;

  @Name("owner_transfer")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldowner_transferValue fieldowner_transferValue;

  @Name("sale_opened")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldsale_openedValue fieldsale_openedValue;

  @Name("canister_owner_updated")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldcanister_owner_updatedValue fieldcanister_owner_updatedValue;

  @Name("sale_withdraw")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFieldsale_withdrawValue fieldsale_withdrawValue;

  @Name("deposit_withdraw")
  @Field(Type.RECORD)
  public BidResponseTxn_typeFielddeposit_withdrawValue fielddeposit_withdrawValue;
}
