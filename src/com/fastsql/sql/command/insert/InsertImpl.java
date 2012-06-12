package com.fastsql.sql.command.insert;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.api.Insert;
import com.fastsql.sql.builder.LogicalEnum;
import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;
import com.fastsql.sql.util.GoogleMySql;

public class InsertImpl implements Insert{
	
	private final StringBuilder builder;
	private final ResultMode mode;
	private Object entidade;
	
	public InsertImpl(String nomeEntidade, ResultMode mode) {
		this.mode = mode;
		this.builder= new StringBuilder(" INSERT INTO "+nomeEntidade);
	}
	
	public InsertImpl(Object entidade, ResultMode mode) throws Exception {
		this.mode = mode;
		this.entidade = entidade;
		Class modelo = entidade.getClass();
		SqlReflectionUtil.gerarIdParaEntidade(entidade);
		String atributos = SqlReflectionUtil.extractAttributesWithValuesFrom(entidade, LogicalEnum.EQUALS);
		String nomeEntidade = SqlReflectionUtil.extractEntityName(modelo);
		this.builder= new StringBuilder(" INSERT INTO "+nomeEntidade+" SET "+atributos);
	}

	@Override
	public String toSql() {
		String sql = builder.toString();
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
	public Object execute() {
		String sql = builder.toString();
		try {
			System.out.println("InsertImpl: "+sql);
			this.mode.insert(sql);
			return entidade;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
