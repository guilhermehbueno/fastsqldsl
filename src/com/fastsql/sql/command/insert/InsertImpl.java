package com.fastsql.sql.command.insert;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.api.Insert;
import com.fastsql.sql.builder.LogicalEnum;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;
import com.fastsql.sql.util.GoogleMySql;

public class InsertImpl implements Insert{
	
	private final StringBuilder builder;
	
	public InsertImpl(String nomeEntidade) {
		this.builder= new StringBuilder(" INSERT INTO "+nomeEntidade);
	}
	
	public InsertImpl(Object entidade) throws Exception {
		Class modelo = entidade.getClass();
		SqlReflectionUtil.gerarIdParaEntidade(entidade);
		String atributos = SqlReflectionUtil.extractAttributesWithValuesFrom(entidade, LogicalEnum.EQUALS);
		//atributos = atributos.replaceAll(",", " AND ");
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
	public void execute() {
		String sql = builder.toString();
		GoogleMySql google;
		try {
			System.out.println("UpdateImpl: "+sql);
			google = new GoogleMySql();
			google.insert(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
