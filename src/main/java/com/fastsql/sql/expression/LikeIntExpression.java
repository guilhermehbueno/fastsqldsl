package com.fastsql.sql.expression;

public class LikeIntExpression implements PredicateExpression{

	public LikeIntExpression() {
		super();
	}

	public String getValue(String expression) {
		return expression;
	}
}
