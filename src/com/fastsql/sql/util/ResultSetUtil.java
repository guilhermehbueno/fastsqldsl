package com.fastsql.sql.util;

import java.util.ArrayList;
import java.util.List;

import com.fastsql.sql.command.result.model.AbstractModel;
import com.google.cloud.sql.jdbc.ResultSet;

public class ResultSetUtil {
	
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
		System.out.println("ResultSetUtil getEntity: "+model);
		model.build(set);
		System.out.println("ResultSetUtil getEntity: "+model);
		model.toModel(modelo);
		System.out.println("ResultSetUtil getEntity: "+modelo);
		return (T) modelo;
	}
}
