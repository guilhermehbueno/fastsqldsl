package com.fastsql.sql.select.test;

import org.junit.Assert;
import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.test.Usuario;

public class SqlEntityTest {
	
	@Test
	public void simpleTest(){
		SqlTool tool = SqlTool.getInstance();
		String sql = tool.select(Usuario.class).build();
		Assert.assertNotNull(sql);
		System.out.println(sql);
	}

}
