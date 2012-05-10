package com.fastsql.sql.command.result.model;

import java.lang.reflect.Field;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.google.cloud.sql.jdbc.ResultSet;

/**
 * This enum is responsible for recovery values from different associations types.
 * @author Guilherme
 *
 */
//TODO: In the future is need create a interface that will represents a generic resultSet from differente Data Bases. Today supports only resultSets from google.
public enum AssociationType {
	
	DEFAULT {
		@Override
		public Object extractFieldValue(Field field, ResultSet resultSet) throws SQLException {
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
		public Object extractFieldValue(Field field, ResultSet resultSet) throws SQLException {
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
	MANY_TO_ONE {
		@Override
		public Object extractFieldValue(Field field, ResultSet resultSet) throws SQLException {
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
		public Object extractFieldValue(Field field, ResultSet resultSet) throws SQLException {
			Object value = null;
			field.setAccessible(true);
			JoinColumn join = field.getAnnotation(JoinColumn.class);
			if(join!=null){
				value = resultSet.getObject(join.referencedColumnName());
			}
			field.setAccessible(false);
			return value;
		}
	};
	
	public abstract Object extractFieldValue(Field field, ResultSet resultSet)  throws SQLException ;
	
	public static AssociationType discoverCorrectAssociationOf(Field field){
		if(field.isAnnotationPresent(Column.class)){
			return DEFAULT;
		}
		
		if(field.isAnnotationPresent(OneToOne.class)){
			return ONE_TO_ONE;
		}
		
		if(field.isAnnotationPresent(ManyToOne.class)){
			return MANY_TO_ONE;
		}
		
		if(field.isAnnotationPresent(ManyToMany.class)){
			return MANY_TO_ONE;
		}
		return DEFAULT;
	}
}
