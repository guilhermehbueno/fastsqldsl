package com.fastsql.sql.command.result;

import java.util.List;

public class Result <T>{
	
	private final List<T> results;

	public Result(List<T> results) {
		super();
		this.results = results;
	}
	
	public T getUniqueResult(){
		System.out.println("Executando getUniqueResult: "+this.results);
		if(this.results.size()>0){
			return this.results.get(0);
		}
		return null;
	}

	public List<T> getResult() {
		return results;
	}
}
