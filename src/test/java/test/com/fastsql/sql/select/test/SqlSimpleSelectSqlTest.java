package com.fastsql.sql.select.test;

import static org.junit.Assert.*;
import static com.fastsql.sql.builder.SqlTerms.*;
import org.junit.Test;
import com.fastsql.sql.builder.SqlTool;

import static com.fastsql.sql.expression.LogicalComparisonExpression.attribute;

public class SqlSimpleSelectSqlTest {

	@Test
	public void testSelect() throws Exception {
		String sql = SqlTool.getInstance().select(" * ").from("nome_tabela").where(expression("teste='teste'").and("teste='teste'").or("value='value'")).toSql();
		String sqlLogical = SqlTool.getInstance().select(" * ").from("nome_tabela").where(attribute("teste").equals("teste").and("teste").equals("teste").or("value").equals("value")).toSql();
		assertNotNull(sql);
		assertNotNull(sqlLogical);
		System.out.println(sql);
		System.out.println(sqlLogical);
	}
	
	@Test
	public void testSelectWithWhere() throws Exception {
		String sql = SqlTool.getInstance().select("atributos").from("nome_tabela").where(expression("teste='teste'").and("teste='teste'").or("value='value'")).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}
	
	@Test
	public void testSelectWithInnerJoin() throws Exception {
		String sql = SqlTool.getInstance().select("atributos").from("nome_tabela").innerJoin("tabela").on(expression("teste='teste'").and("teste='teste'").or("value='value'")).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}
	
	@Test
	public void testSelectWithLeftOuterJoin() throws Exception {
		String sql = SqlTool
						.getInstance()
						.select("atributos")
						.from("nome_tabela")
						.leftOuterJoin("tabela").on(expression("teste='teste'")	.and("teste='teste'").or("value='value'"))
						.where(expression("teste='teste'").and("teste='teste'").or("value='value'")).toSql();
		assertNotNull(sql);
		System.out.println(sql);
		
		
		String sqlLogical = SqlTool.getInstance().select("atributos").from("nome_tabela").leftOuterJoin("outra_tabela").on(attribute("nome").equals("teste")).where(attribute("tal").differentFrom("este")).toSql();
		System.out.println("sqlLogical: "+ sqlLogical);
	}
	
	@Test
	public void testSelectWithRightOuterJoin() throws Exception {
		String sql = SqlTool.getInstance().select("atributos").from("nome_tabela").rightOuterJoin("tabela").on(expression("teste='teste'").and("teste='teste'").or("value='value'")).toSql();
		assertNotNull(sql);
		System.out.println(sql);
	}	
}
