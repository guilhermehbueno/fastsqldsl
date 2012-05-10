package com.fastsql.sql.command.expression;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.builder.LogicalEnum;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.mode.ResultMode;

import static com.fastsql.sql.command.expression.Expression.*;

public class LogicalComparisonExpression implements Build {
	
	private final StringBuilder builder;

	private LogicalComparisonExpression(String atributo) {
		super();
		this.builder = new StringBuilder(atributo);
	}
	
	public static LogicalComparisonExpression attribute(String atributo){
		return new LogicalComparisonExpression(atributo);
	}
	
	public LogicalComparisonExpression isNull(){
		this.builder.append(" ").append(" is null");
		return this;
	}
	
	public LogicalComparisonExpression isNotNull(){
		this.builder.append(" ").append(" is not null");
		return this;
	}
	
	public LogicalComparisonExpression and(Expression atributo){
		this.builder.append(" ").append(LogicalEnum.AND.eval(atributo));
		return this;
	}
	
	public LogicalComparisonExpression and(String atributo){
		this.builder.append(" ").append(LogicalEnum.AND.eval(atributo));
		return this;
	}
	
	public LogicalComparisonExpression or(String atributo){
		this.builder.append(" ").append(LogicalEnum.OR.eval(atributo));
		return this;
	}
	
	public LogicalComparisonExpression equals(String atributo){
		this.builder.append(LogicalEnum.EQUALS.eval(likeString(atributo)));
		return this;
	}
	
	public LogicalComparisonExpression equals(Expression atributo){
		this.builder.append(LogicalEnum.EQUALS.eval(atributo));
		return this;
	}
	
	public LogicalComparisonExpression differentFrom(Expression atributo){
		this.builder.append(LogicalEnum.DIFFERENT.eval(atributo));
		return this;
	}
	
	public LogicalComparisonExpression differentFrom(String atributo){
		this.builder.append(LogicalEnum.DIFFERENT.eval(likeString(atributo)));
		return this;
	}

	@Override
	public String build() {
		return this.builder.toString();
	}

	@Override
	public <T> Result<T> build(T retorno) {
		return null;
	}

	@Override
	public <T> Result<T> build(T retorno, ResultMode mode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
