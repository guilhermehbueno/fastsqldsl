package com.fastsql.sql.api;

import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.mode.ResultMode;

public interface Build {
	
	String toSql();
	<T> Result<T> execute(T retorno);
	<T> Result<T> execute(ResultMode mode, T retorno);

}
