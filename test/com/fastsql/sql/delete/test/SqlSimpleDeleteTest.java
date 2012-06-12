package com.fastsql.sql.delete.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Usuario;
import com.fastsql.sql.expression.LogicalComparisonExpression;

public class SqlSimpleDeleteTest {
	
	@Test
	public void simpleDeleteTest() throws Exception{
		Usuario user = new Usuario();
		user.setIdUsuario("teste");
		user.setNome("guilherme");
		String sql = SqlTool.getInstance().delete(user).where(LogicalComparisonExpression.id(user.getClass()).equals("123")).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}

}
