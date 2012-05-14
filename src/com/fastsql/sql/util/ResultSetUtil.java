package com.fastsql.sql.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fastsql.sql.command.result.model.AbstractModel;
import com.fastsql.sql.command.result.model.AssociationType;
import com.google.cloud.sql.jdbc.ResultSet;

public class ResultSetUtil {
	
	private static Logger log = Logger.getLogger(ResultSetUtil.class);
	
	public static <T> List<T> extractEntityFrom(ResultSet resultSet, T entity) throws Exception{
		List<T> entidades = new ArrayList<T>();
		while(resultSet.next()){
			T result = getEntity(resultSet, entity);
			entidades.add(result);
		}
		return entidades;
	}
	
	private static <T> T getEntity(ResultSet set, T entity) throws Exception{
		Class<? extends Object> classe = entity.getClass();
		Object modelo = classe.newInstance();
		AbstractModel model = AbstractModel.buildModelBy(modelo);
		log.info("ResultSetUtil getEntity: "+model);
		model.build(set);
		log.info("ResultSetUtil getEntity: "+model);
		model.toModel(modelo);
		log.info("ResultSetUtil getEntity: "+modelo);
		return (T) modelo;
	}
}
