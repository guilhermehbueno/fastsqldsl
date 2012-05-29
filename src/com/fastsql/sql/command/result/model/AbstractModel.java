package com.fastsql.sql.command.result.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fastsql.sql.reflection.util.SqlReflectionUtil;

public class AbstractModel{
	private final String modelName;
	private final Object model;
	private final List<AbstractAttribute> modelAttributes;
	
	public static AbstractModel buildModelBy(Object modelo){
		AbstractModel model = new AbstractModel(modelo);
		init(model);
		return model;
	}
	
	private static void init(AbstractModel model){
		List<AbstractAttribute> attributes;
		attributes = AbstractAttributeBuilder.extractAttributesFrom(model.getModel(), model);
		for (AbstractAttribute abstractAttribute : attributes) {
			model.addAttribute(abstractAttribute);
		}
	}
	
	private AbstractModel(Object modelo) {
		super();
		if(modelo==null){
			throw new IllegalArgumentException("O modelo não pode ser nulo.");
		}
		this.model = modelo;
		this.modelName = SqlReflectionUtil.extractEntityName(modelo.getClass());
		this.modelAttributes = new ArrayList<AbstractAttribute>();
	}
	
	public void addAttribute(AbstractAttribute abstractAttribute){
		this.modelAttributes.add(abstractAttribute);
	}
	
	public List<AbstractAttribute> getModelAttributes() {
		return this.modelAttributes;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public Object getModel() {
		return model;
	}
	
	private void setValuesByField(Object model) throws Exception{
		for (AbstractAttribute attribute : this.modelAttributes) {
			attribute.setToObject(model);
		}
	}
	
	public boolean build(ResultSet resultSet){
		for (AbstractAttribute attribute : this.modelAttributes) {
			try {
				attribute.getValue(resultSet);
			} catch (Exception e) {
				//TODO: TRATAR PILHA DE ERROS E RETORNAR FALSE
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public void toModel(Object model){
		try {
			setValuesByField(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "AbstractModel [modelName=" + modelName + ", model=" + model
				+ ", modelAttributes=" + modelAttributes + "]";
	}
}
