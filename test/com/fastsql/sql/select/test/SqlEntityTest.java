package com.fastsql.sql.select.test;

import static com.fastsql.sql.expression.LogicalComparisonExpression.id;

import org.junit.Assert;
import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Usuario;

public class SqlEntityTest {
	
	@Test
	public void simpleTest() throws Exception{
		SqlTool tool = SqlTool.getInstance();
		String sql = tool.select(Usuario.class).where(id().equals("teste")).toSql();
		Assert.assertNotNull(sql);
		System.out.println(sql);
	}
	
	@Test
	public void newSimpleSelectTest(){
		/*Menu menu = new Menu();
		String id = "";
		SqlTool tool = SqlTool.getInstance();
		menu =SqlTool.getInstance()
				.select(menu.getClass())
				.where(id().equals(id))
				.build(menu)
				.getUniqueResult();*/
	}

}
