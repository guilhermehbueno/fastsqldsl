package com.fastsql.sql.select.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

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
	
	@Test
	public void test() throws Exception {
		Menu menu = new Menu();
		menu.setId(UUID.randomUUID().toString());
		menu.setLabel("TESTE");
		menu.setLink("GUI");
		menu.setStatus(MenuStatusEnum.ATIVO);
		menu.setTipo(MenuTipoEnum.SUPERIOR);
		
		SqlTool.getInstance().insert(menu).execute();
		
		
		List<Menu> menus = SqlTool.getInstance().select(menu.getClass()).execute(new Menu()).getResult(); 
		assertNotNull(menus);
		assertTrue(menus.size()>0);
		for (Menu menu1 : menus) {
			System.out.println(menu1);
		}
	}
}
