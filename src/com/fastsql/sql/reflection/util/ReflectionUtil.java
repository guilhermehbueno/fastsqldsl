package com.fastsql.sql.reflection.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtil{
	
	
	public static String getNomeDoTipoParametrizadoByClass(Class clazz) throws Exception{
		String tipoParametrizado = null;
		Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            for (Type t : pt.getActualTypeArguments()) {
                tipoParametrizado = t.toString();
            }
        }
        
        tipoParametrizado=tipoParametrizado.replaceAll("class", "").trim();
        return tipoParametrizado;
	}
	
	public static <T> T getObjetoDoTipoParametrizadoByClass(T modelo) throws Exception{
		String nomeDaClasse = getNomeDoTipoParametrizadoByClass(modelo.getClass());
		Class clazz = Class.forName(nomeDaClasse);
		return (T) clazz.newInstance();
	}
	
}
