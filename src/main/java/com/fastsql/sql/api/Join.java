package com.fastsql.sql.api;


public interface Join extends Build{
	From on(BuildExpression expression);
}
