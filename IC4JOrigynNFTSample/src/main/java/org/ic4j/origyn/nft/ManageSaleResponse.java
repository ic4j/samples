package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.Object;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum ManageSaleResponse {
  bid,

  escrow_deposit,

  withdraw,

  end_sale,

  refresh_offers,

  distribute_sale,

  open_sale;

  @Name("bid")
  @Field(Type.RECORD)
  public BidResponse bidValue;

  @Name("escrow_deposit")
  @Field(Type.RECORD)
  public EscrowResponse fieldescrow_depositValue;

  @Name("withdraw")
  @Field(Type.RECORD)
  public WithdrawResponse withdrawValue;

  @Name("end_sale")
  @Field(Type.RECORD)
  public EndSaleResponse fieldend_saleValue;

  @Name("refresh_offers")
  @Field(Type.RESERVED)
  public Object[] fieldrefresh_offersValue;

  @Name("distribute_sale")
  @Field(Type.VARIANT)
  public Result[] fielddistribute_saleValue;

  @Name("open_sale")
  @Field(Type.BOOL)
  public Boolean fieldopen_saleValue;
}
