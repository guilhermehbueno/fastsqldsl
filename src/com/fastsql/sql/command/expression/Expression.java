package com.fastsql.sql.command.expression;

public class Expression {
	
	private final String initialExpression;
	private final PredicateExpression predicateExpression;
	
	private Expression(String initialExpression, PredicateExpression predicateExpressionParam) {
		this.initialExpression = initialExpression;
		this.predicateExpression = predicateExpressionParam;
	}


	public static Expression likeInt(String expression){
		return new Expression(expression, new LikeIntExpression());
	}
	
	public static Expression likeString(String expression){
		return new Expression(expression, new LikeStringExpression());
	}
	
	public String getValue(){
		return this.predicateExpression.getValue(this.initialExpression);
	}
	
	@Override
	public String toString() {
		return getValue();
	}

}
