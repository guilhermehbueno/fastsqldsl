package com.fastsql.sql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fastsql.sql.configuration.Configuration;
import com.fastsql.sql.configuration.ConfigurationContext;
public class GenericSqlCommands {
	

	private final Connection conn;
	
	public GenericSqlCommands() throws Exception {
		super();
		
		Configuration config = ConfigurationContext.getConfiguration();
		//Class.forName(config.getDriver());  
		conn = (Connection) DriverManager.getConnection(config.getHost()+"?user="+config.getUsername()+"&password="+config.getPassword());
	}

	public ResultSet select(String select) throws Exception{
		ResultSet resultSet=null;
		try{
			 PreparedStatement stmt = conn.prepareStatement(select);
			 stmt.execute();
			 resultSet =stmt.getResultSet();
		}catch (Exception e) {
			throw e;
		}
		return resultSet;
	}
	
	public boolean update(String update) throws Exception{
		try{
			 PreparedStatement stmt = conn.prepareStatement(update);
			 return stmt.execute();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public boolean delete(String delete) throws Exception{
		try{
			 PreparedStatement stmt = conn.prepareStatement(delete);
			 return  stmt.execute();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public boolean insert(String update) throws Exception{
		try{
			 PreparedStatement stmt = conn.prepareStatement(update);
			 return stmt.execute();
		}catch (Exception e) {
			throw e;
		}
	}


}
