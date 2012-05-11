package com.fastsql.sql.command.result.model;

import java.lang.reflect.Field;
import java.sql.SQLException;

import com.google.cloud.sql.jdbc.ResultSet;

public class AbstractAttribute {
	
	private final Field field;
	private final AssociationType type;
	private final AbstractModel model;
	private Object value;
	
	public AbstractAttribute(Field field, AssociationType associationType, AbstractModel abstractModel) {
		super();
		this.field = field;
		this.type = associationType;
		this.model = abstractModel;
	}
	
	public AbstractAttribute(Field field, AbstractModel abstractModel) {
		this(field, AssociationType.DEFAULT, abstractModel);
	}

	public Object getValue(ResultSet resultSet) throws Exception {
		this.value = this.type.extractFieldValue(this.model.getModel(), this.field, resultSet);
		return value;
	} 
	
	public void setToObject(Object modelo) throws Exception{
		System.out.println(this.getClass().getSimpleName()+" Executando setToObject com o field: "+this.field.getName()+": "+this.value);
		boolean hasField = hasField(modelo, this.field);
		if(hasField){
			this.field.setAccessible(true);
			this.field.set(modelo, this.value);
			this.field.setAccessible(false);
		}
	}
	
	private boolean hasField(Object modelo, Field field){
		
		Field [] fields = modelo.getClass().getDeclaredFields();
		for (Field fieldFromModel : fields) {
			fieldFromModel.setAccessible(true);
			System.out.println(this.getClass().getSimpleName()+" fieldFromModel: "+fieldFromModel.getName());
			if(fieldFromModel.getName().equalsIgnoreCase(field.getName())){
				System.out.println(this.getClass().getSimpleName()+" Executando hasField: "+true);
				return true;
			}
			fieldFromModel.setAccessible(false);
		}
		System.out.println(this.getClass().getSimpleName()+" Executando hasField: "+false);
		return false;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AbstractAttribute [field=" + field + ", type=" + type
				+ ", value=" + value + "]";
	}
	
	
}