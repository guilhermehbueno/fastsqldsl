package com.fastsql.sql.api;

import com.fastsql.sql.command.expression.SimpleComparisonExpression;

public interface Join extends Build{
	From on(SimpleComparisonExpression expression);
}
