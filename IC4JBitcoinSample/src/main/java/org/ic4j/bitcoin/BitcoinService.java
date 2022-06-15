package org.ic4j.bitcoin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.ic4j.agent.Agent;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.types.Principal;

public final class BitcoinService {
	static final String PROPERTIES_FILE_NAME = "bitcoin.properties";

	static Properties env;

	String bitcoinCanister;

	Agent agent;

	BitcoinProxy bitcoinProxy;

	static {
		InputStream propInputStream = BitcoinService.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

		env = new Properties();
		try {
			env.load(propInputStream);

		} catch (IOException e) {
			throw new BitcoinError(e);
		}
	}

	public static BitcoinService create(Agent agent) throws BitcoinError {
		return create(agent, env);
	}

	public static BitcoinService create(Agent agent, Properties env) throws BitcoinError {

		BitcoinService bitcoinService = new BitcoinService();

		bitcoinService.bitcoinCanister = env.getProperty("bitcoin.canister");

		bitcoinService.agent = agent;

		bitcoinService.bitcoinProxy = ProxyBuilder.create(agent, Principal.fromString(bitcoinService.bitcoinCanister))
				.getProxy(BitcoinProxy.class);

		return bitcoinService;
	}

	public CompletableFuture<Long> getBalance(GetBalanceRequest balanceRequest) {

		CompletableFuture<Long> response = new CompletableFuture<Long>();

		bitcoinProxy.getBalance(balanceRequest).whenComplete((balanceResponse, ex) -> {
			if (ex == null) {
				if (balanceResponse != null) {
					if (balanceResponse == GetBalanceResponse.Ok)
						response.complete(balanceResponse.okValue);
					else if (balanceResponse == GetBalanceResponse.Err)
						if (balanceResponse.errValue.isPresent())
							response.completeExceptionally(new BitcoinError(balanceResponse.errValue.get()));
						else
							response.completeExceptionally(new BitcoinError("Unknown Error"));
					else
						response.completeExceptionally(new BitcoinError("Unknown Error"));
				} else {
					response.completeExceptionally(new BitcoinError("Empty Response"));
				}
			} else
				response.completeExceptionally(new BitcoinError(ex));

		});

		return response;

	}

	public CompletableFuture<UtxosValue> getUtxos(GetUtxosRequest utxosRequest) {
		
		CompletableFuture<UtxosValue> response = new CompletableFuture<UtxosValue>();

		bitcoinProxy.getUtxos(utxosRequest).whenComplete((utxosResponse, ex) -> {
			if (ex == null) {
				if (utxosResponse != null) {
					if (utxosResponse == GetUtxosResponse.Ok)
						response.complete(utxosResponse.okValue);
					else if (utxosResponse == GetUtxosResponse.Err)
						if (utxosResponse.errValue.isPresent())
							response.completeExceptionally(new BitcoinError(utxosResponse.errValue.get()));
						else
							response.completeExceptionally(new BitcoinError("Unknown Error"));
					else
						response.completeExceptionally(new BitcoinError("Unknown Error"));
				} else {
					response.completeExceptionally(new BitcoinError("Empty Response"));
				}
			} else
				response.completeExceptionally(new BitcoinError(ex));

		});
		
		return response;
	}

	public CompletableFuture<Void> sendTransaction(SendTransactionRequest sendTransactionRequest) {
		CompletableFuture<Void> response = new CompletableFuture<Void>();

		bitcoinProxy.sendTransaction(sendTransactionRequest).whenComplete((sendTransactionResponse, ex) -> {
			if (ex == null) {
				if (sendTransactionResponse != null) {
					if (sendTransactionResponse == SendTransactionResponse.Ok)
						response.complete(null);
					else if (sendTransactionResponse == SendTransactionResponse.Err)
						if (sendTransactionResponse.errValue.isPresent())
							response.completeExceptionally(new BitcoinError(sendTransactionResponse.errValue.get()));
						else
							response.completeExceptionally(new BitcoinError("Unknown Error"));
					else
						response.completeExceptionally(new BitcoinError("Unknown Error"));
				} else {
					response.completeExceptionally(new BitcoinError("Empty Response"));
				}
			} else
				response.completeExceptionally(new BitcoinError(ex));

		});

		return response;
	}

}
