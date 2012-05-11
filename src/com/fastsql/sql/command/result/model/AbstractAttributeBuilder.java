package com.fastsql.sql.command.result.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AbstractAttributeBuilder {
	
	public static List<AbstractAttribute> extractAttributesFrom(Object modelo, AbstractModel abstractModel){
		List<AbstractAttribute> attributes = new ArrayList<AbstractAttribute>();
		Field [] fields = modelo.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			AbstractAttribute attribute = extractAttributeFrom(field, abstractModel);
			attributes.add(attribute);
			field.setAccessible(false);
		}
		return attributes;
	}
	
	
	public static AbstractAttribute extractAttributeFrom(Field field, AbstractModel abstractModel){
		AssociationType associationType = AssociationType.discoverCorrectAssociationOf(field);
		AbstractAttribute attribute = new AbstractAttribute(field, associationType, abstractModel);
		return attribute;
	}
	
	
	

}
