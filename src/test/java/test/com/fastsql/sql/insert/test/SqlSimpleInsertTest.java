package com.fastsql.sql.insert.test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.Endereco;
import com.fastsql.sql.builder.model.Menu;
import com.fastsql.sql.builder.model.MenuStatusEnum;
import com.fastsql.sql.builder.model.MenuTipoEnum;
import com.fastsql.sql.builder.model.Mock;
import com.fastsql.sql.builder.model.Usuario;

public class SqlSimpleInsertTest {

	@Test
	public void testSimpleInsert() throws Exception {
		Usuario user = new Usuario();
		user.setIdUsuario("teste");
		user.setNome("guilherme");
		String sql = SqlTool.getInstance().insert(user).toSql();
		assertNotNull(sql);
		System.out.println(sql);
		
		Endereco endereco = Mock.mock(Endereco.class);
		String sqlEndereco = SqlTool.getInstance().insert(endereco).toSql();
		System.out.println("sqlEndereco: "+sqlEndereco);
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
		
		String sql = SqlTool.getInstance().insert(menu).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}

}
