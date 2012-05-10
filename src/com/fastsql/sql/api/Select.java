package com.fastsql.sql.api;

public interface Select extends Build{
	
	From from(String predicate);

}
