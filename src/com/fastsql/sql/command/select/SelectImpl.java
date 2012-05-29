package com.fastsql.sql.command.select;

import org.apache.log4j.Logger;

import com.fastsql.sql.api.Build;
import com.fastsql.sql.api.BuildExpression;
import com.fastsql.sql.api.From;
import com.fastsql.sql.api.Join;
import com.fastsql.sql.api.Select;
import com.fastsql.sql.api.Where;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;

public class SelectImpl implements Select, From, Join, Where{
	
	private static Logger log = Logger.getLogger(SelectImpl.class);
	
	private final StringBuilder builder;
	private final ResultMode mode;
	
	@SuppressWarnings("unchecked")
	public SelectImpl(String atributo, ResultMode modeParam) throws Exception {
		//this.retorno =  ReflectionUtil.getObjetoDoTipoParametrizadoByClass(this.getClass());
		this.builder= new StringBuilder(" SELECT "+atributo);
		this.mode = modeParam;
	}
	
	public SelectImpl(Class modelo, ResultMode modeParam) throws Exception {
		//this.retorno =  ReflectionUtil.getObjetoDoTipoParametrizadoByClass(this.getClass());
		String atributos = SqlReflectionUtil.extractAttributesFrom(modelo);
		String nomeEntidade = SqlReflectionUtil.extractEntityName(modelo);
		this.builder= new StringBuilder(" SELECT "+atributos+" FROM "+nomeEntidade);
		this.mode = modeParam;
	}

	@Override
	public String toSql() {
		return builder.toString();
	}

	@Override
	public Build where(BuildExpression expression) {
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
	public From on(BuildExpression expression) {
		this.builder.append(" ON "+expression.build());
		return this;
	}

	@Override
	public <T> Result<T> execute(T retorno) {
		return  execute(this.mode, retorno);
		
	}

	@Override
	public <T> Result<T> execute(ResultMode mode, T retorno) {
		String sql = builder.toString();
		log.info("Sql: "+sql);
		log.info("Mode: "+mode);
		log.info("Retorno: "+retorno);
		return (Result<T>) mode.getResult(sql, retorno);
	}

}
