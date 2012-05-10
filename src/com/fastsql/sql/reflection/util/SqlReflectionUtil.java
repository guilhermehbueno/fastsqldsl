package com.fastsql.sql.reflection.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import com.fastsql.sql.builder.LogicalEnum;
import com.fastsql.sql.command.expression.Expression;

public class SqlReflectionUtil {
	
	public static String extractAttributesFrom(Class modelo){
		List<String> atributos = new ArrayList<String>();
		Field [] campos = modelo.getDeclaredFields();
		for (Field field : campos) {
			field.setAccessible(true);
			Column col = field.getAnnotation(Column.class);
			if(col!=null){
				atributos.add(col.name());
			}
			field.setAccessible(false);
		}
		//TODO: FALTA RECUPERAR O ID
		return StringUtils.join(atributos, ", ");
	}
	
	public static String extractAttributesWithValuesFrom(Object entidade, LogicalEnum logicalEnum) throws Exception{
		Class modelo = entidade.getClass();
		List<String> atributos = new ArrayList<String>();
		Field [] campos = modelo.getDeclaredFields();
		for (Field field : campos) {
			field.setAccessible(true);
			Column col = field.getAnnotation(Column.class);
			String value = getValorFormatado(field, entidade, logicalEnum);
			if(value==null){
				continue;
			}
			
			if(col!=null){
				atributos.add(col.name()+" "+value);
			}
			field.setAccessible(false);
		}
		//TODO: FALTA RECUPERAR O ID
		return StringUtils.join(atributos, ", ");
	}
	
	private static String getValorFormatado(Field campo, Object entidade, LogicalEnum logicalEnum) throws Exception{
		Object valor = campo.get(entidade);
		Class tipoCampo = campo.getType();
		Expression expr = null;
		if(tipoCampo.isPrimitive()){
			expr = Expression.likeInt(valor.toString());
		}else{
			expr = Expression.likeString(valor.toString());
		}
		return logicalEnum.eval(expr);
	}
	
	
	public static String extractEntityName(Class modelo){
		boolean isEntity = modelo.isAnnotationPresent(Entity.class);
		String nome = null;
		if(isEntity){
			Entity entity = (Entity) modelo.getAnnotation(Entity.class);
			if(entity!=null){
				nome = entity.name().toLowerCase();
			}
		}
		
		if(nome==null){
			nome = modelo.getSimpleName();
		}
		return nome;
	}
	
	public static List<String> extractListAttributesFrom(Class modelo){
		List<String> atributos = new ArrayList<String>();
		Field [] campos = modelo.getDeclaredFields();
		//TODO: ERRO AQUI
		for (Field field : campos) {
			field.setAccessible(true);
			Column col = field.getAnnotation(Column.class);
			if(col!=null){
				atributos.add(col.name());
			}
			field.setAccessible(false);
		}
		return atributos;
	}
	
	public static String getIdFieldName(Class modelo){
		Field campo = extractFieldWithAnnotation(modelo, Id.class);
		Column column = campo.getAnnotation(Column.class);
		return column.name();
	}
	
	public static Field extractFieldWithAnnotation(Class modelo, Class annotation){
		Field campo = null;
		Field [] campos = modelo.getDeclaredFields();
		for (Field field : campos) {
			field.setAccessible(true);
			if(field.isAnnotationPresent(annotation)){
				campo = field;
			}
			field.setAccessible(false);
		}
		return campo;
	}
}
