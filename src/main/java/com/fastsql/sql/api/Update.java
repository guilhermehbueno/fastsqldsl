package com.fastsql.sql.api;

public interface Update extends BuildUpdate, FromUpdate{
	
	Update set(Build expression);
	Update on(Build expression);
	Update values(Build expression);

}
