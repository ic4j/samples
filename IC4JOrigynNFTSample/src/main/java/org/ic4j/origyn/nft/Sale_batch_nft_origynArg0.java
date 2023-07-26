package org.ic4j.origyn.nft;

import java.lang.Object;
import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Sale_batch_nft_origynArg0 {
  bid,

  escrow_deposit,

  withdraw,

  end_sale,

  refresh_offers,

  distribute_sale,

  open_sale;

  @Name("bid")
  @Field(Type.RECORD)
  public BidRequest bidValue;

  @Name("escrow_deposit")
  @Field(Type.RECORD)
  public EscrowRequest fieldescrow_depositValue;

  @Name("withdraw")
  @Field(Type.VARIANT)
  public WithdrawRequest withdrawValue;

  @Name("end_sale")
  @Field(Type.TEXT)
  public String fieldend_saleValue;

  @Name("refresh_offers")
  @Field(Type.RESERVED)
  public Optional<Object> fieldrefresh_offersValue;

  @Name("distribute_sale")
  @Field(Type.RECORD)
  public DistributeSaleRequest fielddistribute_saleValue;

  @Name("open_sale")
  @Field(Type.TEXT)
  public String fieldopen_saleValue;
}
