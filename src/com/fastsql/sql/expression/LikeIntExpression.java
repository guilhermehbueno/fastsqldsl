package com.fastsql.sql.expression;

public class LikeIntExpression implements PredicateExpression{

	public LikeIntExpression() {
		super();
	}

	@Override
	public String getValue(String expression) {
		return expression;
	}
}
