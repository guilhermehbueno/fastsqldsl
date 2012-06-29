package com.fastsql.sql.register;

import com.fastsql.sql.configuration.Configuration;
import com.fastsql.sql.properties.util.PropertiesUtil;

public class ConfigurationRegister {
	
	public Configuration loadAllConfigurations(){
		Configuration configuration = new Configuration();
		loadPersistenceXmlConfiguration(configuration);
		loadPropertiesConfiguration(configuration);
		return configuration;
	}
	
	public void loadPersistenceXmlConfiguration(Configuration configuration){
		//configuration.setResultModeClassName("com.fastsql.sql.command.result.mode.HsqlDBResultMode");
	}
	
	public void loadPropertiesConfiguration(Configuration configuration){
		String resultModeClassName = PropertiesUtil.getProperty("mode");
		String host = PropertiesUtil.getProperty("host");
		String username = PropertiesUtil.getProperty("username");
		String password = PropertiesUtil.getProperty("password");
		String driver = PropertiesUtil.getProperty("driver");
		
		configuration.setResultModeClassName(resultModeClassName);
		configuration.setHost(host);
		configuration.setUsername(username);
		configuration.setPassword(password);
		configuration.setDriver(driver);
	}
}
