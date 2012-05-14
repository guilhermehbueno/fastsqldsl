package com.fastsql.sql.select.test;

import org.junit.Assert;
import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Menu;

public class SqlEntityRelationshipTest {
	
	@Test
	public void testOneToManyJPAAnnotation(){
		Menu menu = new Menu();
		
		SqlTool tool = SqlTool.getInstance();
		menu = tool.select(Menu.class).build(menu).getUniqueResult();
		Assert.assertNotNull(menu);
		Assert.assertNotNull(menu.getMenu());
		Assert.assertTrue(menu.getMenu().size()>0);
	}

}
