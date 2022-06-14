package org.ic4j.bitcoin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
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
		InputStream propInputStream = BitcoinService.class.getClassLoader()
				.getResourceAsStream(PROPERTIES_FILE_NAME);

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

		bitcoinService.bitcoinProxy = ProxyBuilder
				.create(agent, Principal.fromString(bitcoinService.bitcoinCanister))
				.getProxy(BitcoinProxy.class);

		return bitcoinService;
	}	
	
	public Long getBalance(GetBalanceRequest balanceRequest) throws BitcoinError
	{
		GetBalanceResponse balanceResponse;
		try {
			balanceResponse = bitcoinProxy.getBalance(balanceRequest).get();
	
		
		if(balanceResponse == GetBalanceResponse.Ok)
			return balanceResponse.okValue;
		else if(balanceResponse == GetBalanceResponse.Err)
			if(balanceResponse.errValue.isPresent())
			throw new BitcoinError(balanceResponse.errValue.get());
		
		throw new BitcoinError("Unknown Cause");
		
		} catch (InterruptedException | ExecutionException e) {
			throw new BitcoinError(e);
		}
	}
	
	public UtxosValue getUtxos(GetUtxosRequest utxosRequest) throws BitcoinError
	{
		GetUtxosResponse utxosResponse;
		try {
			utxosResponse = bitcoinProxy.getUtxos(utxosRequest).get();
		
		if(utxosResponse == GetUtxosResponse.Ok)
			return utxosResponse.okValue;
		else if(utxosResponse == GetUtxosResponse.Err)
			if(utxosResponse.errValue.isPresent())
			throw new BitcoinError(utxosResponse.errValue.get());
		
		throw new BitcoinError("Unknown Cause");
		
		} catch (InterruptedException | ExecutionException e) {
			throw new BitcoinError(e);
		}
	}	
	
	public void sendTransaction(SendTransactionRequest sendTransactionRequest) throws BitcoinError
	{
		SendTransactionResponse sendTransactionResponse;
		
		try {
			sendTransactionResponse = bitcoinProxy.sendTransaction(sendTransactionRequest).get();
		
		if(sendTransactionResponse == SendTransactionResponse.Ok)
			return;
		else if(sendTransactionResponse == SendTransactionResponse.Err)
			if(sendTransactionResponse.errValue.isPresent())
			throw new BitcoinError(sendTransactionResponse.errValue.get());
		
		throw new BitcoinError("Unknown Cause");
		
		} catch (InterruptedException | ExecutionException e) {
			throw new BitcoinError(e);
		}
	}	

}
