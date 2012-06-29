package com.fastsql.sql.util;

import java.sql.ResultSet;


public interface SqlCommands {
	
	public ResultSet select(String select) throws Exception;
	public boolean update(String update) throws Exception;
	public boolean delete(String delete) throws Exception;
	public boolean insert(String update) throws Exception;

}
