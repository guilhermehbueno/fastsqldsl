package com.fastsql.sql.command.result.mode;

import java.sql.ResultSet;

import com.fastsql.sql.command.result.Result;

public class MySqlResultMode implements ResultMode{

	@Override
	public <T> Result<T> getResult(String sql, T retorno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet select(String select) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String update) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String delete) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(String update) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
