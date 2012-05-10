package com.fastsql.sql.insert.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.builder.model.test.Usuario;

public class SqlSimpleInsertTest {

	@Test
	public void testSimpleInsert() throws Exception {
		Usuario user = new Usuario();
		user.setId("teste");
		user.setNome("guilherme");
		user.setSobrenome("bueno");
		String sql = SqlTool.insert(user).build();
		assertNotNull(sql);
		System.out.println(sql);
	}

}
