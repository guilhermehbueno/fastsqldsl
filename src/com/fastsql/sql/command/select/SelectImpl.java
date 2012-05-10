package com.fastsql.sql.command.select;

import java.util.List;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.api.From;
import com.fastsql.sql.api.Join;
import com.fastsql.sql.api.Select;
import com.fastsql.sql.api.Where;
import com.fastsql.sql.command.expression.SimpleComparisonExpression;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;
import com.fastsql.sql.util.GoogleMySql;
import com.fastsql.sql.util.ResultSetUtil;
import com.google.cloud.sql.jdbc.ResultSet;

public class SelectImpl implements Select, From, Join, Where{
	
	private final StringBuilder builder;
	private final ResultMode mode;
	
	public SelectImpl(String atributo, ResultMode modeParam) {
		this.builder= new StringBuilder(" SELECT "+atributo);
		this.mode = modeParam;
	}
	
	public SelectImpl(Class modelo, ResultMode modeParam) {
		String atributos = SqlReflectionUtil.extractAttributesFrom(modelo);
		String nomeEntidade = SqlReflectionUtil.extractEntityName(modelo);
		this.builder= new StringBuilder(" SELECT "+atributos+" FROM "+nomeEntidade);
		this.mode = modeParam;
	}

	@Override
	public String build() {
		return builder.toString();
	}

	@Override
	public Build where(Build expression) {
		builder.append(" WHERE ").append(expression.build());
		return this;
	}

	@Override
	public Join innerJoin(String tableName) {
		this.builder.append(" INNER JOIN "+tableName);
		return this;
	}

	@Override
	public Join leftOuterJoin(String tableName) {
		this.builder.append(" LEFT OUTER JOIN "+tableName);
		return this;
	}

	@Override
	public Join rightOuterJoin(String tableName) {
		this.builder.append(" RIGHT OUTER JOIN "+tableName);
		return this;
	}

	@Override
	public From from(String predicate) {
		this.builder.append(" FROM "+predicate);
		return this;
	}

	@Override
	public From on(SimpleComparisonExpression expression) {
		this.builder.append(" ON "+expression.build());
		return this;
	}

	@Override
	public <T> Result<T> build(T retorno) {
		/*String sql = builder.toString();
		GoogleMySql google;
		List<T> result = null;
		try {
			google = new GoogleMySql();
			ResultSet resultSet = google.select(sql);
			result = ResultSetUtil.extractEntityFrom(resultSet, retorno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result<T>(result);*/
		return build(retorno, this.mode);
		
	}

	@Override
	public <T> Result<T> build(T retorno, ResultMode mode) {
		String sql = builder.toString();
		System.out.println("Sql: "+sql);
		System.out.println("Mode: "+mode);
		System.out.println("Retorno: "+retorno);
		return mode.getResult(sql, retorno);
	}

}
