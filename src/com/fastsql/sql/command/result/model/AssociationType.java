package com.fastsql.sql.command.result.model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.expression.Expression;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;
import org.apache.log4j.Logger;

import static com.fastsql.sql.expression.LogicalComparisonExpression.*;

/**
 * This enum is responsible for recovery values from different associations types.
 * @author Guilherme
 */
//TODO: In the future is need create a interface that will represents a generic resultSet from differente Data Bases. Today supports only resultSets from google.
public enum AssociationType {
	
	DEFAULT {
		@Override
		public Object extractFieldValue(Object modelo, Field field, ResultSet resultSet) throws SQLException {
			log.info("DEFAULT: ");
			Object value = null;
			field.setAccessible(true);
			Column col = field.getAnnotation(Column.class);
			if(col!=null){
				value = resultSet.getObject(col.name());
			}
			field.setAccessible(false);
			return value;
		}
	},
	
	ONE_TO_ONE {
		@Override
		public Object extractFieldValue(Object modelo, Field field, ResultSet resultSet) throws Exception {
			log.info("ONE_TO_ONE: ");
			Object value = null;
			field.setAccessible(true);
			JoinColumn join = field.getAnnotation(JoinColumn.class);
			if(join!=null){
				value = resultSet.getObject(join.referencedColumnName());
				if(value==null){
					return null;
				}
				
				
				 Object result = SqlTool.getInstance()
										.select(field.getType())
										.where(id(field.getType()).equals(value.toString()))
										.execute(field.getType().newInstance()).getUniqueResult();
				
				log.info("Result: "+result);
				value = result;
			}
			field.setAccessible(false);
			return value;
		}
	},
	
	ONE_TO_MANY{
		@Override
		public Object extractFieldValue(Object modelo, Field field, ResultSet resultSet) throws Exception{
			log.info("ONE_TO_MANY: ");
			Object value = null;
			field.setAccessible(true);
			JoinColumn join = field.getAnnotation(JoinColumn.class);
			if(join!=null){
				String nomeColunaId = SqlReflectionUtil.getIdFieldName(modelo.getClass());
				value = resultSet.getObject(nomeColunaId);
				if(value==null){
					return null;
				}
				
				String tipoParametrizado = null;
				Type type = field.getGenericType();
		        if (type instanceof ParameterizedType) {
		            ParameterizedType pt = (ParameterizedType) type;
		            for (Type t : pt.getActualTypeArguments()) {
		                tipoParametrizado = t.toString();
		            }
		        }
		        
		        log.info("Construindo: "+tipoParametrizado);
		        tipoParametrizado=tipoParametrizado.replaceAll("class", "").trim();
		        log.info("Construindo: "+tipoParametrizado);
		        Object instanciaTipoParametrizado = Class.forName(tipoParametrizado).newInstance();
				
				List<? extends Object> result =  SqlTool.getInstance()
																.select(" * ")
																.from(join.table())
																.where(attribute(join.referencedColumnName()).equals(value.toString()))
																.execute(instanciaTipoParametrizado).getResult();
				value = result;
				
			}
			field.setAccessible(false);
			return value;
		}
	},
	
	
	MANY_TO_ONE {
		@Override
		public Object extractFieldValue(Object modelo, Field field, ResultSet resultSet) throws SQLException {
			log.info("MANY_TO_ONE: ");
			Object value = null;
			field.setAccessible(true);
			JoinColumn join = field.getAnnotation(JoinColumn.class);
			if(join!=null){
				value = resultSet.getObject(join.referencedColumnName());
			}
			field.setAccessible(false);
			return value;
		}
	},
	
	MANY_TO_MANY {
		@Override
		public Object extractFieldValue(Object modelo, Field field, ResultSet resultSet) throws SQLException {
			log.info("MANY_TO_MANY: ");
			Object value = null;
			field.setAccessible(true);
			JoinColumn join = field.getAnnotation(JoinColumn.class);
			if(join!=null){
				value = resultSet.getObject(join.referencedColumnName());
			}
			field.setAccessible(false);
			return value;
		}
	},
	
	ENUMERATED{
		@Override
		public Object extractFieldValue(Object modelo, Field field, ResultSet resultSet) throws Exception {
			log.info("ENUMERATED: ");
			Object value = null;
			field.setAccessible(true);
			Column coluna = field.getAnnotation(Column.class);
			if(coluna!=null){
				value = resultSet.getObject(coluna.name());
				if(value==null){
					return null;
				}
				
				log.info("[ENUMERATED]" +value);
				log.info("[field.isEnumConstant()]" +field.isEnumConstant());
				value = Enum.valueOf((Class<Enum>) field.getType(),value.toString());
				log.info("[field.isEnumConstant()]" +value);
			}
			field.setAccessible(false);
			return value;
		}
	}
	;
	
	public abstract Object extractFieldValue(Object modelo, Field field, ResultSet resultSet)  throws Exception ;
	
	public static AssociationType discoverCorrectAssociationOf(Field field){
		if(field.isAnnotationPresent(Column.class)&&!field.isAnnotationPresent(Enumerated.class)){
			return DEFAULT;
		}
		
		if(field.isAnnotationPresent(OneToOne.class)){
			return ONE_TO_ONE;
		}
		
		if(field.isAnnotationPresent(OneToMany.class)){
			return ONE_TO_MANY;
		}
		
		if(field.isAnnotationPresent(ManyToOne.class)){
			return MANY_TO_ONE;
		}
		
		if(field.isAnnotationPresent(ManyToMany.class)){
			return MANY_TO_ONE;
		}
		
		if(field.isAnnotationPresent(Enumerated.class)){
			return ENUMERATED;
		}
		
		return DEFAULT;
	}
	
	private static Logger log = Logger.getLogger(AssociationType.class);
	
}
