package com.fastsql.sql.api;

import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.mode.ResultMode;


public interface Build {
	
	String build();
	<T> Result<T> build(T retorno);
	<T> Result<T> build(T retorno, ResultMode mode);
}
