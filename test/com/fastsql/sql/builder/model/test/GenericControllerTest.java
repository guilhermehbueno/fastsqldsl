package com.fastsql.sql.builder.model.test;

import org.junit.Test;

import com.fastsql.sql.builder.model.MenuController;

public class GenericControllerTest {

	@Test
	public void test() {
		MenuController menuController = new MenuController();
		System.out.println(menuController.getTipo());
	}

}
