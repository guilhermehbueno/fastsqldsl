package com.fastsql.sql.api;

public interface Insert extends BuildUpdate{
	
	Insert set(Build expression);
	Insert on(Build expression);
	Insert values(Build expression);

}
