package com.fastsql.sql.command.expression;

public class LikeStringExpression implements PredicateExpression{
	
	public LikeStringExpression() {
		super();
	}

	@Override
	public String getValue(String expression) {
		return "'"+expression+"'";
	}

}
