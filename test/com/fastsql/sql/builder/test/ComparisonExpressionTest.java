package com.fastsql.sql.builder.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastsql.sql.builder.SqlTerms;
import com.fastsql.sql.expression.SimpleComparisonExpression;

public class ComparisonExpressionTest {

	@Test
	public void test() {
		String sql = SimpleComparisonExpression
						.expression("teste='teste'")
						.and("teste='teste'")
						.or("teste is not null")
						.and("testando = 'testando'")
						.build();
		assertNotNull(sql);
		System.out.println("test: "+sql);
		
		String expression = SqlTerms
						.attribute("nome")
						.equals(SqlTerms.likeInt("guilherme"))
						.and("sobrenome").equals("bueno")
						.or("nome").differentFrom("lula")
						.build();
		System.out.println("Teste com expression Int: "+expression);
		
	}
	
	@Test
	public void testMinimal() {
		String expression = 
				SqlTerms
				.attribute("nome").equals("guilherme")
				.and("sobrenome").equals("bueno")
				.or("nome").differentFrom("lula")
				.build();
		System.out.println("testMinimal: "+expression);

		String sql = 
				SimpleComparisonExpression
					.expression("teste='teste'")
					.and("teste='teste'")
					.or("teste is not null")
					.and("testando = 'testando'")
					.build();
		assertNotNull(sql);
		System.out.println("testMinimal: "+sql);
	}

}
