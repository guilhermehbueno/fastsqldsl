package com.fastsql.sql.builder.test;

import com.fastsql.sql.builder.model.test.Usuario;

public class ObjectComparisonExpressionTest {
	
	public void testObjectSelectExpression(){
		Usuario usuario = new Usuario();
		//Id id = Id.class.newInstance();
		//List<Usuario> users = SqlTool.select(all()).byExample(usuario).exclude(id)).list();
		//SqlTool.select(all()).byExample(usuario).exclude(usuario.getId()).getUniqueResult();
	}
	
	
	public static String all(){
		return " * ";
	}

}
