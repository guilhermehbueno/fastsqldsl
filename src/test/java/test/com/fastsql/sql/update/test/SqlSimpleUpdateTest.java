package com.fastsql.sql.update.test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Menu;
import com.fastsql.sql.builder.model.MenuStatusEnum;
import com.fastsql.sql.builder.model.MenuTipoEnum;
import com.fastsql.sql.builder.model.Usuario;
import com.fastsql.sql.command.result.mode.HsqlDBResultMode;
import com.fastsql.sql.command.result.mode.ResultMode;

public class SqlSimpleUpdateTest {

	@Test
	public void testSimpleUpdate() throws Exception {
		ResultMode resulMode = new HsqlDBResultMode();
		Usuario user = new Usuario();
		user.setIdUsuario("teste");
		user.setNome("guilherme");
		String sql = SqlTool.getInstance(resulMode).update(user).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}
	
	@Test
	public void testSimpleAssociationUpdate() throws Exception {
		ResultMode resulMode = new HsqlDBResultMode();
		Menu menu = new Menu();
		menu.setId(UUID.randomUUID().toString());
		menu.setLabel("Teste de menu");
		menu.setLink("link ");
		menu.setPai(2);
		menu.setStatus(MenuStatusEnum.ATIVO);
		menu.setTipo(MenuTipoEnum.SUPERIOR);
		
		String sql = SqlTool.getInstance(resulMode).update(menu).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}

}
