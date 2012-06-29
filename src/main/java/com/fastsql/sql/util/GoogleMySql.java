package com.fastsql.sql.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.appengine.api.rdbms.AppEngineDriver;
import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.PreparedStatement;
import com.google.cloud.sql.jdbc.ResultSet;

public class GoogleMySql implements SqlCommands{
	
	private final Connection conn;
	
	public GoogleMySql() throws SQLException {
		super();
		DriverManager.registerDriver(new AppEngineDriver());
		conn = (Connection) DriverManager.getConnection("jdbc:google:rdbms://naovotenelesql:naovotenelesql/teste");
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
