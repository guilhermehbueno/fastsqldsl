package com.fastsql.sql.select.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Menu;
import com.fastsql.sql.builder.model.MenuStatusEnum;
import com.fastsql.sql.builder.model.MenuTipoEnum;
import com.fastsql.sql.builder.model.Mock;
import com.fastsql.sql.command.result.mode.HsqlDBResultMode;
import com.fastsql.sql.command.result.mode.ResultMode;

public class SqlSimpleSelectObjectTest {
	
	private static Menu menu;
	private static ResultMode resulMode;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		resulMode = new HsqlDBResultMode();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() throws Exception {
		menu = new Menu();
		List<Menu> menus = SqlTool.getInstance(resulMode).select(menu.getClass()).execute(new Menu()).getResult(); 
		assertNotNull(menus);
		assertTrue(menus.size()>0);
		for (Menu menu : menus) {
			System.out.println(menu);
		}
	}

}
