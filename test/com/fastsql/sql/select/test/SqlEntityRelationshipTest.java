package com.fastsql.sql.select.test;

import org.junit.Assert;
import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Menu;
import com.fastsql.sql.command.result.mode.HsqlDBResultMode;
import com.fastsql.sql.command.result.mode.ResultMode;

public class SqlEntityRelationshipTest {
	
	@Test
	public void testOneToManyJPAAnnotation() throws Exception{
		ResultMode resulMode = new HsqlDBResultMode();
		Menu menu = new Menu();
		menu = (Menu) SqlTool.getInstance(resulMode).select(Menu.class).execute(menu).getUniqueResult();
		Assert.assertNotNull(menu);
		Assert.assertNotNull(menu.getMenu());
		Assert.assertTrue(menu.getMenu().size()>0);
	}

}
