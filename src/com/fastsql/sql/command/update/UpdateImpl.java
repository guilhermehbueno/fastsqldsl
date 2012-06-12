package com.fastsql.sql.command.update;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.api.BuildExpression;
import com.fastsql.sql.api.BuildUpdate;
import com.fastsql.sql.api.From;
import com.fastsql.sql.api.FromUpdate;
import com.fastsql.sql.api.Insert;
import com.fastsql.sql.api.Update;
import com.fastsql.sql.builder.LogicalEnum;
import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;
import com.fastsql.sql.util.GoogleMySql;

public class UpdateImpl  implements Update, FromUpdate{
	private final StringBuilder builder;
	private Object entidade;
	private final ResultMode mode;
	
	public UpdateImpl(String nomeEntidade, ResultMode mode) {
		this.mode = mode;
		this.builder= new StringBuilder(" UPDATE "+nomeEntidade);
	}
	
	public UpdateImpl(Object entidade, ResultMode mode) throws Exception {
		this.mode = mode;
		this.entidade = entidade;
		Class modelo = entidade.getClass();
		String atributos = SqlReflectionUtil.extractAttributesWithValuesFrom(entidade, LogicalEnum.EQUALS);
		//atributos = atributos.replaceAll(",", " AND ");
		String nomeEntidade = SqlReflectionUtil.extractEntityName(modelo);
		this.builder= new StringBuilder(" UPDATE "+nomeEntidade+" SET "+atributos);
		System.out.println("UpdateImpl: "+this.builder);
	}


	@Override
	public Object execute() {
		try {
			mode.update(toSql());
			return this.entidade;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String toSql() {
		String sql = this.builder.toString();
		System.out.println("Updade gerado: "+sql);
		return sql;
	}

	@Override
	public Insert set(Build expression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insert on(Build expression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insert values(Build expression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuildUpdate where(BuildExpression expression) {
		builder.append(" WHERE ").append(expression.build());
		return this;
	}
	
}
