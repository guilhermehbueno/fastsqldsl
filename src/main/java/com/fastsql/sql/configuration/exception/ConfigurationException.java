package com.fastsql.sql.configuration.exception;

public class ConfigurationException extends Exception{

	private static final long serialVersionUID = 5072539002000453027L;

	public ConfigurationException() {
		super();
	}

	public ConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConfigurationException(String message) {
		super(message);
	}

	public ConfigurationException(Throwable cause) {
		super(cause);
	}

}
