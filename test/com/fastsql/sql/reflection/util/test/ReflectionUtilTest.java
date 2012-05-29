package com.fastsql.sql.reflection.util.test;

import static org.junit.Assert.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fastsql.sql.builder.model.MenuController;
import com.fastsql.sql.reflection.util.ReflectionUtil;

public class ReflectionUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetInstance() throws Exception {
		
	}

	@Test
	public void testGetNomeDoTipoParametrizadoByClass() throws Exception {
		MenuController controller = new MenuController();
		String nome = ReflectionUtil.getNomeDoTipoParametrizadoByClass(controller.getClass());
		System.out.println(nome);
	}

	@Test
	public void testGetObjetoDoTipoParametrizadoByClass() throws Exception {
		MenuController controller = new MenuController();
		Object tipo = ReflectionUtil.getObjetoDoTipoParametrizadoByClass(controller);
		System.out.println(tipo);
	}

}
