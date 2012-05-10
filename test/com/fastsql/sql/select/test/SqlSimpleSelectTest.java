package com.fastsql.sql.select.test;

import static org.junit.Assert.*;
import static com.fastsql.sql.builder.SqlTerms.*;
import org.junit.Test;
import com.fastsql.sql.builder.SqlTool;
import static com.fastsql.sql.command.expression.LogicalComparisonExpression.attribute;

public class SqlSimpleSelectTest {

	@Test
	public void testSelect() {
		String sql = SqlTool.getInstance().select(" * ").from("nome_tabela").where(expression("teste='teste'").and("teste='teste'").or("value='value'")).build();
		String sqlLogical = SqlTool.getInstance().select(" * ").from("nome_tabela").where(attribute("teste").equals("teste").and("teste").equals("teste").or("value").equals("value")).build();
		assertNotNull(sql);
		assertNotNull(sqlLogical);
		System.out.println(sql);
		System.out.println(sqlLogical);
	}
	
	@Test
	public void testSelectWithWhere() {
		String sql = SqlTool.getInstance().select("atributos").from("nome_tabela").where(expression("teste='teste'").and("teste='teste'").or("value='value'")).build();
		assertNotNull(sql);
		System.out.println(sql);
	}
	
	@Test
	public void testSelectWithInnerJoin() {
		String sql = SqlTool.getInstance().select("atributos").from("nome_tabela").innerJoin("tabela").on(expression("teste='teste'").and("teste='teste'").or("value='value'")).build();
		assertNotNull(sql);
		System.out.println(sql);
	}
	
	@Test
	public void testSelectWithLeftOuterJoin() {
		String sql = SqlTool
						.getInstance()
						.select("atributos")
						.from("nome_tabela")
						.leftOuterJoin("tabela").on(expression("teste='teste'")	.and("teste='teste'").or("value='value'"))
						.where(expression("teste='teste'").and("teste='teste'").or("value='value'")).build();
		assertNotNull(sql);
		System.out.println(sql);
		
		
		String sqlLogical = SqlTool.getInstance().select("atributos").from("nome_tabela").leftOuterJoin("outra_tabela").on(attribute("nome").equals("teste")).where(attribute("tal").differentFrom("este")).build();
		System.out.println("sqlLogical: "+ sqlLogical);
	}
	
	@Test
	public void testSelectWithRightOuterJoin() {
		String sql = SqlTool.getInstance().select("atributos").from("nome_tabela").rightOuterJoin("tabela").on(expression("teste='teste'").and("teste='teste'").or("value='value'")).build();
		assertNotNull(sql);
		System.out.println(sql);
	}	
}
