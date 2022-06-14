package org.ic4j.bitcoin;

import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.Waiter;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.agent.annotations.ResponseClass;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public interface BitcoinProxy {
	
	@UPDATE
	@Name("get_balance")
	@Waiter(timeout = 30)
	@ResponseClass(GetBalanceResponse.class)
	public CompletableFuture<GetBalanceResponse> getBalance(@Argument(Type.RECORD)GetBalanceRequest balanceRequest);
	
	@UPDATE
	@Name("get_utxos")
	@Waiter(timeout = 30)
	@ResponseClass(GetUtxosResponse.class)
	public CompletableFuture<GetUtxosResponse> getUtxos(@Argument(Type.RECORD)GetUtxosRequest utxosRequest);
	
	@UPDATE
	@Name("send_transaction")
	@Waiter(timeout = 30)
	@ResponseClass(SendTransactionResponse.class)
	public CompletableFuture<SendTransactionResponse> sendTransaction(@Argument(Type.RECORD)SendTransactionRequest transactionRequest);	

}
