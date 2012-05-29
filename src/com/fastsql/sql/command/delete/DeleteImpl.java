package com.fastsql.sql.command.delete;

import com.fastsql.sql.api.BuildExpression;
import com.fastsql.sql.api.Delete;
import com.fastsql.sql.api.Execute;
import com.fastsql.sql.builder.LogicalEnum;
import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;
import com.fastsql.sql.util.GoogleMySql;

public class DeleteImpl implements Delete{
	
	private final StringBuilder builder;
	private final ResultMode mode;
	
	public DeleteImpl(String nomeEntidade, ResultMode mode) {
		super();
		this.builder = new StringBuilder(" DELETE FROM "+nomeEntidade);
		this.mode = mode;
	}
	
	public DeleteImpl(Object entidade, ResultMode mode) throws Exception {
		this.mode = mode;
		Class modelo = entidade.getClass();
		SqlReflectionUtil.gerarIdParaEntidade(entidade);
		String atributos = SqlReflectionUtil.extractAttributesWithValuesFrom(entidade, LogicalEnum.EQUALS);
		String nomeEntidade = SqlReflectionUtil.extractEntityName(modelo);
		this.builder= new StringBuilder(" DELETE FROM "+nomeEntidade);
	}

	@Override
	public void execute() {
		try {
			this.mode.delete(toSql());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toSql() {
		String sql = builder.toString();
		System.out.println("DeleteImpl: "+sql);
		if(!sql.contains("WHERE")){
			throw new IllegalStateException("Não habilitado delete sem cláusula where");
		}
		return sql;
	}

	@Override
	public Execute where(BuildExpression expression) {
		builder.append(" WHERE ").append(expression.build());
		return this;
	}
}
