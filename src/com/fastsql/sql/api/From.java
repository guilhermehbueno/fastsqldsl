package com.fastsql.sql.api;


public interface From extends Build{
	
	Build where(Build expression);
	Join innerJoin(String tableName);
	Join leftOuterJoin(String tableName);
	Join rightOuterJoin(String tableName);

}
