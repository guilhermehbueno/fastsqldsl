package com.fastsql.sql.command.result;

public interface QueryResult {

	public <T> Result<T> getResult(String sql, T retorno);
}
