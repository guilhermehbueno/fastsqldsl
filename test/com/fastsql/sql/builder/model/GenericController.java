package com.fastsql.sql.builder.model;

import java.lang.reflect.ParameterizedType;

import com.fastsql.sql.builder.SqlTool;

public abstract class GenericController<T>{
	
	public void save(T obj) {
		try {
			String sql = SqlTool.getInstance().insert(obj).toSql();
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public String getTipo(){
		Class clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz.getSimpleName();
	}

}
