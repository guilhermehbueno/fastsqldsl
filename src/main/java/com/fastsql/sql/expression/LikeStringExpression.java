package com.fastsql.sql.expression;

public class LikeStringExpression implements PredicateExpression{
	
	public LikeStringExpression() {
		super();
	}

	public String getValue(String expression) {
		return "'"+expression+"'";
	}

}
