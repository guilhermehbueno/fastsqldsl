package com.fastsql.sql.configuration;

import com.fastsql.sql.register.ConfigurationRegister;

public class ConfigurationContext {
	
	static {
		configuration = new ConfigurationRegister().loadAllConfigurations();
	}
	
	private static Configuration configuration;
	
	public static Configuration getConfiguration(){
		return configuration;
	}
}
