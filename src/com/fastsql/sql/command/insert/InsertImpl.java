package com.fastsql.sql.command.insert;

import java.util.List;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.api.Insert;
import com.fastsql.sql.builder.LogicalEnum;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;
import com.fastsql.sql.util.GoogleMySql;
import com.fastsql.sql.util.ResultSetUtil;
import com.google.cloud.sql.jdbc.ResultSet;

public class InsertImpl implements Insert{
	
	private final StringBuilder builder;
	
	public InsertImpl(String nomeEntidade) {
		this.builder= new StringBuilder(" INSERT INTO "+nomeEntidade);
	}
	
	public InsertImpl(Object entidade) throws Exception {
		Class modelo = entidade.getClass();
		String atributos = SqlReflectionUtil.extractAttributesWithValuesFrom(entidade, LogicalEnum.EQUALS);
		atributos = atributos.replaceAll(",", " AND ");
		String nomeEntidade = SqlReflectionUtil.extractEntityName(modelo);
		this.builder= new StringBuilder(" INSERT INTO "+nomeEntidade+" SET "+atributos);
	}

	@Override
	public String build() {
		return builder.toString();
	}


	@Override
	public <T> Result<T> build(T retorno) {
		String sql = builder.toString();
		GoogleMySql google;
		List<T> result = null;
		try {
			google = new GoogleMySql();
			ResultSet resultSet = google.select(sql);
			result = ResultSetUtil.extractEntityFrom(resultSet, retorno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result<T>(result);
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
	public <T> Result<T> build(T retorno, ResultMode mode) {
		// TODO Auto-generated method stub
		return null;
	}

}
