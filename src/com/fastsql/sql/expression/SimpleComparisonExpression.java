package com.fastsql.sql.expression;

import java.util.List;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.api.BuildExpression;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.mode.ResultMode;


public class SimpleComparisonExpression implements BuildExpression{
	
	private final StringBuilder builder;
	private final String AND = " AND ";
	private final String OR = " OR ";
	
	private int expressionCount=0;
	
	private SimpleComparisonExpression(String expression) {
		super();
		this.builder = new StringBuilder(expression);
	}

	public static SimpleComparisonExpression expression(String expression){
		return new SimpleComparisonExpression(expression);
	}
	
	public SimpleComparisonExpression and(String expression){
		preparaExpression(AND, expression);
		return this;
	}
	
	public SimpleComparisonExpression and(String key, String value){
		preparaExpression(AND, key+"'"+value+"'");
		return this;
	}
	
	
	public SimpleComparisonExpression or(String expression){
		preparaExpression(OR, expression);
		return this;
	}
	
	public SimpleComparisonExpression or(String key, String value){
		preparaExpression(OR, key+"'"+value+"'");
		return this;
	}
	
	
	private void preparaExpression(String operador, String expression){
		if(expressionCount>0){
			this.builder.append(operador).append(expression);
		}
		expressionCount++;
	}

	@Override
	public String build() {
		return this.builder.toString();
	}

	@Override
	public <T> Result<T> build(T retorno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Result<T> build(T retorno, ResultMode mode) {
		// TODO Auto-generated method stub
		return null;
	}

}
