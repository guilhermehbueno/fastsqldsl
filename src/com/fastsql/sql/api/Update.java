package com.fastsql.sql.api;

public interface Update extends BuildUpdate, FromUpdate{
	
	Insert set(Build expression);
	Insert on(Build expression);
	Insert values(Build expression);

}
