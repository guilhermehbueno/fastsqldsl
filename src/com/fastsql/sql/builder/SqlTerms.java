package com.fastsql.sql.builder;

import com.fastsql.sql.command.expression.Expression;
import com.fastsql.sql.command.expression.LogicalComparisonExpression;
import com.fastsql.sql.command.expression.SimpleComparisonExpression;

public class SqlTerms {
	
	public static LogicalComparisonExpression attribute(String expression){
		return LogicalComparisonExpression.attribute(expression);
	}
	
	public static SimpleComparisonExpression expression(String expression){
		return SimpleComparisonExpression.expression(expression);
	}
	
	public static SimpleComparisonExpression and(String expression){
		return SimpleComparisonExpression.expression(expression);
	}
	
	public static SimpleComparisonExpression or(String expression){
		return SimpleComparisonExpression.expression(expression);
	}

	public static Expression likeInt(String expression) {
		return Expression.likeInt(expression);
	}
}
