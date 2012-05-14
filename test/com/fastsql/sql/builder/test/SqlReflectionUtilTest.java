package com.fastsql.sql.builder.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.fastsql.sql.builder.LogicalEnum;
import com.fastsql.sql.builder.model.Usuario;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;

public class SqlReflectionUtilTest {

	@Test
	public void testExtractAttributesFrom() {
		Usuario user = new Usuario();
		user.setId("teste");
		user.setNome("guilherme");
		user.setSobrenome("bueno");
		String result = SqlReflectionUtil.extractAttributesFrom(user.getClass());
		assertNotNull(result);
		System.out.println("[1] - testExtractAttributesFrom = "+result);
	}

	@Test
	public void testExtractAttributesWithValuesFrom() throws Exception {
		Usuario user = new Usuario();
		user.setId("teste");
		user.setNome("guilherme");
		user.setSobrenome("bueno");
		String result = SqlReflectionUtil.extractAttributesWithValuesFrom(user, LogicalEnum.EQUALS);
		assertNotNull(result);
		System.out.println("[2] - testExtractAttributesWithValuesFrom = "+result);
	}

	@Test
	public void testExtractEntityName() {
		Usuario user = new Usuario();
		user.setId("teste");
		user.setNome("guilherme");
		user.setSobrenome("bueno");
		String result = SqlReflectionUtil.extractEntityName(user.getClass());
		assertNotNull(result);
		System.out.println("[3] - testExtractEntityName = "+result);
	}

	@Test
	public void testExtractListAttributesFrom() {
		Usuario user = new Usuario();
		user.setId("teste");
		user.setNome("guilherme");
		user.setSobrenome("bueno");
		List<String> result = SqlReflectionUtil.extractListAttributesFrom(user.getClass());
		assertNotNull(result);
		assertTrue(result.size()>0);
		System.out.println("[4] - testExtractListAttributesFrom = "+result);
	}

}
