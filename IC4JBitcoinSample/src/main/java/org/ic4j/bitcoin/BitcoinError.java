package org.ic4j.bitcoin;


public class BitcoinError extends Error {

	Enum code;
	
	public BitcoinError(Exception cause) {
		super(cause);
	}
	
	public BitcoinError(Enum code) {
		this.code = code;
	}	

	public BitcoinError(String message) {
		super(message);
	}

	/**
	 * @return the code
	 */
	public Enum getCode() {
		return code;
	}	

}
