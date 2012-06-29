package com.fastsql.sql.builder;

import com.fastsql.sql.command.entity.EntityExpression;

public class SqlEntityTool{
	
	public static <T extends EntityExpression> T select(EntityExpression predicateExpression){
		return (T) predicateExpression;
	}

}
