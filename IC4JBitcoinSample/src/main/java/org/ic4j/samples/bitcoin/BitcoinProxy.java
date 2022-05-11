package org.ic4j.samples.bitcoin;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.Waiter;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Label;
import org.ic4j.candid.types.Type;

public interface BitcoinProxy {
	
	@UPDATE
	@Name("get_balance")
	@Waiter(timeout = 30)
	public CompletableFuture<Map<Label,Object>> getBalance(@Argument(Type.RECORD)GetBalanceRequest balanceRequest);
	
	@UPDATE
	@Name("get_utxos")
	@Waiter(timeout = 30)
	public CompletableFuture<Map<Label,Object>> getUtxos(@Argument(Type.RECORD)GetUtxosRequest utxosRequest);
	
	@UPDATE
	@Name("send_transaction")
	@Waiter(timeout = 30)
	public CompletableFuture<Map<Label,Object>> sendTransaction(@Argument(Type.RECORD)SendTransactionRequest transactionRequest);	

}
