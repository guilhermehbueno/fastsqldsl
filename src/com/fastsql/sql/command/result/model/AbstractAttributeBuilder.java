package com.fastsql.sql.command.result.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AbstractAttributeBuilder {
	
	public static List<AbstractAttribute> extractAttributesFrom(Object modelo){
		List<AbstractAttribute> attributes = new ArrayList<AbstractAttribute>();
		Field [] fields = modelo.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			AbstractAttribute attribute = extractAttributeFrom(field);
			attributes.add(attribute);
			field.setAccessible(false);
		}
		return attributes;
	}
	
	
	public static AbstractAttribute extractAttributeFrom(Field field){
		AssociationType associationType = AssociationType.discoverCorrectAssociationOf(field);
		AbstractAttribute attribute = new AbstractAttribute(field, associationType);
		return attribute;
	}
	
	
	

}
