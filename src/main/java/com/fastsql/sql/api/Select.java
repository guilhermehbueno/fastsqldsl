package com.fastsql.sql.api;

public interface Select<T> extends Build{
	
	From from(String predicate);

}
