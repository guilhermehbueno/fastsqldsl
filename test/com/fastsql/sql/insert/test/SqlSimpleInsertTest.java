package com.fastsql.sql.insert.test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Menu;
import com.fastsql.sql.builder.model.MenuStatusEnum;
import com.fastsql.sql.builder.model.MenuTipoEnum;
import com.fastsql.sql.builder.model.Usuario;

public class SqlSimpleInsertTest {

	//@Test
	public void testSimpleInsert() throws Exception {
		Usuario user = new Usuario();
		user.setId("teste");
		user.setNome("guilherme");
		user.setSobrenome("bueno");
		String sql = SqlTool.insert(user).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}
	
	@Test
	public void testSimpleAssociationInsert() throws Exception {
		Menu menu = new Menu();
		menu.setId(UUID.randomUUID().toString());
		menu.setLabel("Teste de menu");
		menu.setLink("link ");
		menu.setPai(2);
		menu.setStatus(MenuStatusEnum.ATIVO);
		menu.setTipo(MenuTipoEnum.SUPERIOR);
		
		String sql = SqlTool.insert(menu).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}

}
