package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.String;
import java.lang.Void;
import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.candid.annotations.Modes;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Mode;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;


public interface OrigynProxy {
  @Name("sale_info_batch_nft_origyn")
  @Modes(Mode.QUERY)
  SaleInfoResult[] sale_info_batch_nft_origyn(@Argument(Type.VARIANT) SaleInfoRequest[] arg0);

  @Name("metadata")
  @Modes(Mode.QUERY)
  DIP721Metadata metadata();

  @Name("transferFrom")
  CompletableFuture<DIP721NatResult> transferFrom(@Argument(Type.PRINCIPAL) Principal arg0,
      @Argument(Type.PRINCIPAL) Principal arg1, @Argument(Type.NAT) BigInteger arg2);

  @Name("transferDip721")
  CompletableFuture<DIP721NatResult> transferDip721(@Argument(Type.PRINCIPAL) Principal arg0,
      @Argument(Type.NAT) BigInteger arg1);

  @Name("share_wallet_nft_origyn")
  CompletableFuture<OwnerUpdateResult> share_wallet_nft_origyn(
      @Argument(Type.RECORD) ShareWalletRequest arg0);

  @Name("balance_of_secure_nft_origyn")
  CompletableFuture<BalanceResult> balance_of_secure_nft_origyn(
      @Argument(Type.VARIANT) Account arg0);

  @Name("stage_batch_nft_origyn")
  CompletableFuture<OrigynTextResult[]> stage_batch_nft_origyn(
      @Argument(Type.RECORD) Stage_batch_nft_origynArg0[] arg0);

  @Name("stage_nft_origyn")
  CompletableFuture<OrigynTextResult> stage_nft_origyn(
      @Argument(Type.RECORD) Stage_nft_origynArg0 arg0);

  @Name("dip721_stats")
  @Modes(Mode.QUERY)
  DIP721Stats dip721_stats();

  @Name("balance")
  @Modes(Mode.QUERY)
  EXTBalanceResult balance(@Argument(Type.RECORD) EXTBalanceRequest arg0);

  @Name("market_transfer_nft_origyn")
  CompletableFuture<MarketTransferResult> market_transfer_nft_origyn(
      @Argument(Type.RECORD) MarketTransferRequest arg0);

  @Name("dip721_operator_token_identifiers")
  @Modes(Mode.QUERY)
  DIP721TokensListMetadata dip721_operator_token_identifiers(
      @Argument(Type.PRINCIPAL) Principal arg0);

  @Name("http_request_streaming_callback")
  @Modes(Mode.QUERY)
  StreamingCallbackResponse http_request_streaming_callback(
      @Argument(Type.RECORD) StreamingCallbackToken arg0);

  @Name("bearer_batch_secure_nft_origyn")
  CompletableFuture<BearerResult[]> bearer_batch_secure_nft_origyn(
      @Argument(Type.TEXT) String[] arg0);

  @Name("governance_nft_origyn")
  CompletableFuture<GovernanceResult> governance_nft_origyn(
      @Argument(Type.VARIANT) GovernanceRequest arg0);

  @Name("sale_info_batch_secure_nft_origyn")
  CompletableFuture<SaleInfoResult[]> sale_info_batch_secure_nft_origyn(
      @Argument(Type.VARIANT) SaleInfoRequest[] arg0);

  @Name("dip721_custodians")
  @Modes(Mode.QUERY)
  Principal[] dip721_custodians();

  @Name("nft_batch_origyn")
  @Modes(Mode.QUERY)
  NFTInfoResult[] nft_batch_origyn(@Argument(Type.TEXT) String[] arg0);

  @Name("dip721_name")
  @Modes(Mode.QUERY)
  Optional<String> dip721_name();

  @Name("balanceEXT")
  @Modes(Mode.QUERY)
  EXTBalanceResult balanceEXT(@Argument(Type.RECORD) EXTBalanceRequest arg0);

  @Name("http_request")
  @Modes(Mode.QUERY)
  HTTPResponse http_request(@Argument(Type.RECORD) HttpRequest arg0);

  @Name("dip721_owner_of")
  @Modes(Mode.QUERY)
  OwnerOfResponse dip721_owner_of(@Argument(Type.NAT) BigInteger arg0);

  @Name("bearer_secure_nft_origyn")
  CompletableFuture<BearerResult> bearer_secure_nft_origyn(@Argument(Type.TEXT) String arg0);

  @Name("stage_library_nft_origyn")
  CompletableFuture<StageLibraryResult> stage_library_nft_origyn(
      @Argument(Type.RECORD) StageChunkArg arg0);

  @Name("get_halt")
  @Modes(Mode.QUERY)
  Boolean get_halt();

  @Name("governance_batch_nft_origyn")
  CompletableFuture<GovernanceResult[]> governance_batch_nft_origyn(
      @Argument(Type.VARIANT) GovernanceRequest[] arg0);

  @Name("nft_batch_secure_origyn")
  CompletableFuture<NFTInfoResult[]> nft_batch_secure_origyn(@Argument(Type.TEXT) String[] arg0);

  @Name("manage_storage_nft_origyn")
  CompletableFuture<ManageStorageResult> manage_storage_nft_origyn(
      @Argument(Type.VARIANT) ManageStorageRequest arg0);

  @Name("dip721_total_transactions")
  @Modes(Mode.QUERY)
  BigInteger dip721_total_transactions();

  @Name("getCanisterMetrics")
  @Modes(Mode.QUERY)
  Optional<CanisterMetrics> getCanisterMetrics(@Argument(Type.RECORD) GetMetricsParameters arg0);

  @Name("get_nat_as_token_id_origyn")
  @Modes(Mode.QUERY)
  String get_nat_as_token_id_origyn(@Argument(Type.NAT) BigInteger arg0);

  @Name("dip721_token_metadata")
  @Modes(Mode.QUERY)
  DIP721TokenMetadata dip721_token_metadata(@Argument(Type.NAT) BigInteger arg0);

  @Name("stage_library_batch_nft_origyn")
  CompletableFuture<StageLibraryResult[]> stage_library_batch_nft_origyn(
      @Argument(Type.RECORD) StageChunkArg[] arg0);

  @Name("storage_info_nft_origyn")
  @Modes(Mode.QUERY)
  StorageMetricsResult storage_info_nft_origyn();

  @Name("collection_secure_nft_origyn")
  CompletableFuture<CollectionResult> collection_secure_nft_origyn(
      @Argument(Type.VEC) Optional<Collection_secure_nft_origynArg0[]> arg0);

  @Name("storage_info_secure_nft_origyn")
  CompletableFuture<StorageMetricsResult> storage_info_secure_nft_origyn();

  @Name("operaterTokenMetadata")
  @Modes(Mode.QUERY)
  DIP721TokensMetadata operaterTokenMetadata(@Argument(Type.PRINCIPAL) Principal arg0);

  @Name("bearer_batch_nft_origyn")
  @Modes(Mode.QUERY)
  BearerResult[] bearer_batch_nft_origyn(@Argument(Type.TEXT) String[] arg0);

  @Name("collection_update_batch_nft_origyn")
  CompletableFuture<OrigynBoolResult[]> collection_update_batch_nft_origyn(
      @Argument(Type.VARIANT) ManageCollectionCommand[] arg0);

  @Name("dip721_balance_of")
  @Modes(Mode.QUERY)
  BigInteger dip721_balance_of(@Argument(Type.PRINCIPAL) Principal arg0);

  @Name("history_secure_nft_origyn")
  CompletableFuture<HistoryResult> history_secure_nft_origyn(@Argument(Type.TEXT) String arg0,
      @Argument(Type.NAT) Optional<BigInteger> arg1, @Argument(Type.NAT) Optional<BigInteger> arg2);

  @Name("ownerTokenMetadata")
  @Modes(Mode.QUERY)
  DIP721TokensMetadata ownerTokenMetadata(@Argument(Type.PRINCIPAL) Principal arg0);

  @Name("mint_batch_nft_origyn")
  CompletableFuture<OrigynTextResult[]> mint_batch_nft_origyn(
      @Argument(Type.RECORD) Mint_batch_nft_origynArg0[] arg0);

  @Name("transferEXT")
  CompletableFuture<EXTTransferResponse> transferEXT(
      @Argument(Type.RECORD) EXTTransferRequest arg0);

  @Name("set_data_harvester")
  CompletableFuture<Void> set_data_harvester(@Argument(Type.NAT) BigInteger arg0);

  @Name("state_size")
  @Modes(Mode.QUERY)
  StateSize state_size();

  @Name("dip721_owner_token_metadata")
  @Modes(Mode.QUERY)
  DIP721TokensMetadata dip721_owner_token_metadata(@Argument(Type.PRINCIPAL) Principal arg0);

  @Name("chunk_nft_origyn")
  @Modes(Mode.QUERY)
  ChunkResult chunk_nft_origyn(@Argument(Type.RECORD) ChunkRequest arg0);

  @Name("cycles")
  @Modes(Mode.QUERY)
  BigInteger cycles();

  @Name("balance_of_batch_nft_origyn")
  @Modes(Mode.QUERY)
  BalanceResult[] balance_of_batch_nft_origyn(@Argument(Type.VARIANT) Account[] arg0);

  @Name("http_access_key")
  CompletableFuture<OrigynTextResult> http_access_key();

  @Name("update_app_nft_origyn")
  CompletableFuture<NFTUpdateResult> update_app_nft_origyn(
      @Argument(Type.VARIANT) NFTUpdateRequest arg0);

  @Name("bearerEXT")
  @Modes(Mode.QUERY)
  EXTBearerResult bearerEXT(@Argument(Type.TEXT) String arg0);

  @Name("dip721_total_supply")
  @Modes(Mode.QUERY)
  BigInteger dip721_total_supply();

  @Name("get_token_id_as_nat_origyn")
  @Modes(Mode.QUERY)
  BigInteger get_token_id_as_nat_origyn(@Argument(Type.TEXT) String arg0);

  @Name("history_batch_secure_nft_origyn")
  CompletableFuture<HistoryResult[]> history_batch_secure_nft_origyn(
      @Argument(Type.RECORD) History_batch_secure_nft_origynArg0[] arg0);

  @Name("bearer")
  @Modes(Mode.QUERY)
  EXTBearerResult bearer(@Argument(Type.TEXT) String arg0);

  @Name("set_halt")
  CompletableFuture<Void> set_halt(@Argument(Type.BOOL) Boolean arg0);

  @Name("wallet_receive")
  CompletableFuture<BigInteger> wallet_receive();

  @Name("__advance_time")
  CompletableFuture<BigInteger> __advance_time(@Argument(Type.INT) BigInteger arg0);

  @Name("getCanisterLog")
  @Modes(Mode.QUERY)
  Optional<CanisterLogResponse> getCanisterLog(
      @Argument(Type.VARIANT) Optional<CanisterLogRequest> arg0);

  @Name("history_batch_nft_origyn")
  @Modes(Mode.QUERY)
  HistoryResult[] history_batch_nft_origyn(
      @Argument(Type.RECORD) History_batch_nft_origynArg0[] arg0);

  @Name("collection_update_nft_origyn")
  CompletableFuture<OrigynBoolResult> collection_update_nft_origyn(
      @Argument(Type.VARIANT) ManageCollectionCommand arg0);

  @Name("transferFromDip721")
  CompletableFuture<DIP721NatResult> transferFromDip721(@Argument(Type.PRINCIPAL) Principal arg0,
      @Argument(Type.PRINCIPAL) Principal arg1, @Argument(Type.NAT) BigInteger arg2);

  @Name("dip721_transfer_from")
  CompletableFuture<DIP721NatResult> dip721_transfer_from(@Argument(Type.PRINCIPAL) Principal arg0,
      @Argument(Type.PRINCIPAL) Principal arg1, @Argument(Type.NAT) BigInteger arg2);

  @Name("sale_info_secure_nft_origyn")
  CompletableFuture<SaleInfoResult> sale_info_secure_nft_origyn(
      @Argument(Type.VARIANT) SaleInfoRequest arg0);

  @Name("get_access_key")
  @Modes(Mode.QUERY)
  OrigynTextResult get_access_key();

  @Name("transfer")
  CompletableFuture<EXTTransferResponse> transfer(@Argument(Type.RECORD) EXTTransferRequest arg0);

  @Name("chunk_secure_nft_origyn")
  CompletableFuture<ChunkResult> chunk_secure_nft_origyn(@Argument(Type.RECORD) ChunkRequest arg0);

  @Name("sale_info_nft_origyn")
  @Modes(Mode.QUERY)
  SaleInfoResult sale_info_nft_origyn(@Argument(Type.VARIANT) SaleInfoRequest arg0);

  @Name("back_up")
  @Modes(Mode.QUERY)
  Back_upResponse back_up(@Argument(Type.NAT) BigInteger arg0);

  @Name("dip721_is_approved_for_all")
  @Modes(Mode.QUERY)
  DIP721BoolResult dip721_is_approved_for_all(@Argument(Type.PRINCIPAL) Principal arg0,
      @Argument(Type.PRINCIPAL) Principal arg1);

  @Name("metadataExt")
  @Modes(Mode.QUERY)
  EXTMetadataResult metadataExt(@Argument(Type.TEXT) String arg0);

  @Name("whoami")
  @Modes(Mode.QUERY)
  Principal whoami();

  @Name("bearer_nft_origyn")
  @Modes(Mode.QUERY)
  BearerResult bearer_nft_origyn(@Argument(Type.TEXT) String arg0);

  @Name("nftStreamingCallback")
  @Modes(Mode.QUERY)
  StreamingCallbackResponse nftStreamingCallback(
      @Argument(Type.RECORD) StreamingCallbackToken arg0);

  @Name("ownerOf")
  @Modes(Mode.QUERY)
  OwnerOfResponse ownerOf(@Argument(Type.NAT) BigInteger arg0);

  @Name("sale_batch_nft_origyn")
  CompletableFuture<ManageSaleResult[]> sale_batch_nft_origyn(
      @Argument(Type.VARIANT) ManageSaleRequest[] arg0);

  @Name("mint_nft_origyn")
  CompletableFuture<OrigynTextResult> mint_nft_origyn(@Argument(Type.TEXT) String arg0,
      @Argument(Type.VARIANT) Account arg1);

  @Name("balance_of_nft_origyn")
  @Modes(Mode.QUERY)
  BalanceResult balance_of_nft_origyn(@Argument(Type.VARIANT) Account arg0);

  @Name("market_transfer_batch_nft_origyn")
  CompletableFuture<MarketTransferResult[]> market_transfer_batch_nft_origyn(
      @Argument(Type.RECORD) MarketTransferRequest[] arg0);

  @Name("dip721_metadata")
  @Modes(Mode.QUERY)
  DIP721Metadata dip721_metadata();

  @Name("nft_origyn")
  @Modes(Mode.QUERY)
  NFTInfoResult nft_origyn(@Argument(Type.TEXT) String arg0);

  @Name("dip721_logo")
  @Modes(Mode.QUERY)
  Optional<String> dip721_logo();

  @Name("dip721_supported_interfaces")
  @Modes(Mode.QUERY)
  DIP721SupportedInterface[] dip721_supported_interfaces();

  @Name("dip721_operator_token_metadata")
  @Modes(Mode.QUERY)
  DIP721TokensMetadata dip721_operator_token_metadata(@Argument(Type.PRINCIPAL) Principal arg0);

  @Name("getEXTTokenIdentifier")
  @Modes(Mode.QUERY)
  String getEXTTokenIdentifier(@Argument(Type.TEXT) String arg0);

  @Name("canister_status")
  CompletableFuture<Canister_status> canister_status(
      @Argument(Type.RECORD) Canister_statusArg0 arg0);

  @Name("tokens_ext")
  @Modes(Mode.QUERY)
  EXTTokensResult tokens_ext(@Argument(Type.TEXT) String arg0);

  @Name("__set_time_mode")
  CompletableFuture<Boolean> __set_time_mode(@Argument(Type.VARIANT) __set_time_modeArg0 arg0);

  @Name("balance_of_secure_batch_nft_origyn")
  CompletableFuture<BalanceResult[]> balance_of_secure_batch_nft_origyn(
      @Argument(Type.VARIANT) Account[] arg0);

  @Name("__supports")
  @Modes(Mode.QUERY)
  __supportsResponse[] __supports();

  @Name("dip721_owner_token_identifiers")
  @Modes(Mode.QUERY)
  DIP721TokensListMetadata dip721_owner_token_identifiers(@Argument(Type.PRINCIPAL) Principal arg0);

  @Name("history_nft_origyn")
  @Modes(Mode.QUERY)
  HistoryResult history_nft_origyn(@Argument(Type.TEXT) String arg0,
      @Argument(Type.NAT) Optional<BigInteger> arg1, @Argument(Type.NAT) Optional<BigInteger> arg2);

  @Name("dip721_symbol")
  @Modes(Mode.QUERY)
  Optional<String> dip721_symbol();

  @Name("nft_secure_origyn")
  CompletableFuture<NFTInfoResult> nft_secure_origyn(@Argument(Type.TEXT) String arg0);

  @Name("collectCanisterMetrics")
  @Modes(Mode.QUERY)
  void collectCanisterMetrics();

  @Name("sale_nft_origyn")
  CompletableFuture<ManageSaleResult> sale_nft_origyn(
      @Argument(Type.VARIANT) ManageSaleRequest arg0);

  @Name("collection_nft_origyn")
  @Modes(Mode.QUERY)
  CollectionResult collection_nft_origyn(
      @Argument(Type.VEC) Optional<Collection_nft_origynArg0[]> arg0);

  @Name("dip721_transfer")
  CompletableFuture<DIP721NatResult> dip721_transfer(@Argument(Type.PRINCIPAL) Principal arg0,
      @Argument(Type.NAT) BigInteger arg1);
}
