package com.fastsql.sql.properties.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtil {
	
	private static final Properties properties;
	private static final Set<String> propertiesJaCarregados;
	
	static{
		properties = new Properties();
		propertiesJaCarregados = new HashSet<String>() ;
		System.out.println("Executou o bloco estatico...");
			try {
				loadProperties("configuration.properties");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void loadProperties(Map<String,String> propriedades){
		properties.putAll(properties);
	}
	
	
	public static boolean loadProperties(String propertyFileName) throws Exception{
		if(propertiesJaCarregados.contains(propertyFileName)){
			return true;
		}
		
		if(propertyFileName == null){
			throw new IllegalArgumentException("O nome do arquivo a ser carregado não pode ser null");
		}
		
		InputStream input = PropertiesUtil.class.getClass().getClassLoader().getSystemResourceAsStream(propertyFileName);
		if(input==null){
			throw new Exception("Não foi encontrado o arquivo : "+propertyFileName);
		}
		
		try {
			properties.load(input);
			propertiesJaCarregados.add(propertyFileName);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static String getProperty(String propertyName){
		if(propertyName == null){
			throw new IllegalArgumentException("O nome da propriedade a ser carregada não pode ser null");
		}

		String valor = properties.getProperty(propertyName);
		return valor;
	}

}
