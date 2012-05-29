package com.fastsql.sql.command.expression;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;

public class LogicalIdExpression implements LogicalField{
	
	public LogicalComparisonExpression extractExpression(Class modelo){
		String id = SqlReflectionUtil.getIdFieldName(modelo);
		return new LogicalComparisonExpression(id);
	}

	@Override
	public Build extractExpression() {
		// TODO Auto-generated method stub
		return null;
	}

}
