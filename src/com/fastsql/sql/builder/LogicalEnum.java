package com.fastsql.sql.builder;

import com.fastsql.sql.expression.Expression;

public enum LogicalEnum {
	
	AND,
	OR,
	EQUALS{
		public String eval(Expression value){
			return " = "+value;
		}
	},
	DIFFERENT{
		public String eval(Expression value){
			return " <> "+value;
		}
	};
	
	public String eval(Expression value){
		return this.name()+" "+value;
	}
	
	public String eval(String value){
		return this.name()+" "+value;
	}

}
