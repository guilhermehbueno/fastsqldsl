package com.fastsql.sql.command.result;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.sql.jdbc.ResultSet;

public class PackageResult <T>{
	
	private final ResultSet resultSet;
	private final Object modelo;
	private List<T> results;
	
	public void setResults(List<T> results) {
		this.results = results;
	}

	public PackageResult(ResultSet resultSet, Object modelo) {
		super();
		this.resultSet = resultSet;
		this.modelo = modelo;
		this.results = new ArrayList<T>();
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public Object getModelo() {
		return modelo;
	}

	public List<T> getResults() {
		return results;
	}
}
