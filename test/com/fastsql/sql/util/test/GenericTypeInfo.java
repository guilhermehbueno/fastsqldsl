package com.fastsql.sql.util.test;

import java.lang.reflect.Type;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import com.fastsql.sql.builder.model.Usuario;
 
public class GenericTypeInfo {
    java.util.List<Usuario> fooList = new ArrayList<Usuario>();
 
    public static void main(String[] args) throws Exception {
        Field field = GenericTypeInfo.class.getDeclaredField("fooList");
 
        Type type = field.getGenericType();
        System.out.println("type: " + type);
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            System.out.println("pt: "+pt);
            System.out.println("raw type: " + pt.getRawType());
            System.out.println("owner type: " + pt.getOwnerType());
            System.out.println("actual type args:");
            for (Type t : pt.getActualTypeArguments()) {
                System.out.println("=>    " + t);
            }
        }
 
        System.out.println();
 
        Object obj = field.get(new GenericTypeInfo());
        System.out.println("obj: " + obj);
        System.out.println("obj class: " + obj.getClass());
    }
 
}