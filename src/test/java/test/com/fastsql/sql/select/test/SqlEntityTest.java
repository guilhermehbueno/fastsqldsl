package com.fastsql.sql.select.test;

import org.junit.Assert;
import org.junit.Test;

import com.fastsql.sql.api.From;
import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Menu;
import com.fastsql.sql.command.result.mode.HsqlDBResultMode;
import com.fastsql.sql.command.result.mode.ResultMode;

public class SqlEntityTest {
	
	@Test
	public void simpleTest() throws Exception{
		ResultMode resulMode = new HsqlDBResultMode();
		From from =  SqlTool.getInstance(resulMode).select(Menu.class);
		Assert.assertNotNull(from);
		String sql =from.toSql();
		Assert.assertNotNull(null);
		Assert.assertNotNull(sql);
		System.out.println(sql);
	}
	

}
