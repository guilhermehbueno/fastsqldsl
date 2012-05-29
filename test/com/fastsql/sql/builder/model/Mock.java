package com.fastsql.sql.builder.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Mock {

    public static <T> T mock(Class clazz) {
	T instance = null;
	try {
	    instance = (T) clazz.newInstance();
	    Field[] campos = clazz.getDeclaredFields();
	    for (Field field : campos) {
		field.setAccessible(true);
		try {
		    if (field.getType().equals(List.class)) {
			System.out.println("O campo: " + field.getName() + " do tipo:" + field.getType()
				+ " não pode ser mockado");
		    } else if (field.getType().equals(Integer.class)) {
			field.set(instance, mockInteger(clazz));
		    } else {
			field.set(instance,
				"[MOCK_" + field.getName() + "_" + UUID.randomUUID().toString().substring(0, 8) + "]");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		field.setAccessible(false);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return instance;
    }

    public static <T> List<T> mock(Class clazz, int size) {
	List<T> beans = new ArrayList<T>();
	if (clazz.equals(String.class)) {
	    beans = (List<T>) mockString(clazz, size);
	    return beans;
	}
	for (int i = 0; i < size; i++) {
	    beans.add((T) mock(clazz));
	}
	return beans;
    }

    private static String mockString(Class clazz) {
	return mockString(clazz, 1).get(0);
    }

    private static Integer mockInteger(Class clazz) {
	return 5;
    }

    private static List<String> mockString(Class clazz, int size) {
	List<String> result = new ArrayList<String>();
	for (int i = 0; i < size; i++) {
	    result.add("[MOCK_" + UUID.randomUUID().toString().substring(0, 8) + "]");
	}
	return result;
    }

    public static void main(String[] args) {
	System.out.println(mock(String.class));
    }

}
