package com.fastsql.sql.configuration;

import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.configuration.exception.ConfigurationException;

public class Configuration {
	
	private String host;
	private String username;
	private String password;
	private String driver;
	
	private String resultModeClassName;
	private String statisticsModeClassName;
	private String cacheModeClassName;
	private  ResultMode resultMode;
	
	public ResultMode getResultMode() throws ConfigurationException {
		try{
		this.resultMode = (ResultMode) Class.forName(this.resultModeClassName).newInstance();
		}catch (Exception e) {
			throw new ConfigurationException("Erro ao instanciar Configuration", e);
		}
		return resultMode;
	}
	
	public void validateConfiguration()  throws ConfigurationException{
		throw new ConfigurationException("Configuração não é válida pelos seguintes motivos:");
	}


	public void setResultModeClassName(String resultModeClassName) {
		this.resultModeClassName = resultModeClassName;
	}


	public void setStatisticsModeClassName(String statisticsModeClassName) {
		this.statisticsModeClassName = statisticsModeClassName;
	}


	public void setCacheModeClassName(String cacheModeClassName) {
		this.cacheModeClassName = cacheModeClassName;
	}
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResultModeClassName() {
		return resultModeClassName;
	}

	public String getStatisticsModeClassName() {
		return statisticsModeClassName;
	}

	public String getCacheModeClassName() {
		return cacheModeClassName;
	}

	public void setResultMode(ResultMode resultMode) {
		this.resultMode = resultMode;
	}
}
