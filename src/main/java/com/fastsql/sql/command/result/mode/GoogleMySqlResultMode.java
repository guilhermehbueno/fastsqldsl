package com.fastsql.sql.command.result.mode;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.fastsql.sql.command.result.PackageResult;
import com.fastsql.sql.command.result.ProcessorResult;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.impl.GoogleMySqlProcessorResult;
import com.fastsql.sql.command.result.step.ExtractColumnStep;
import com.fastsql.sql.util.GoogleMySql;
import com.google.cloud.sql.jdbc.ResultSet;

public class GoogleMySqlResultMode  implements ResultMode{
	
	private Logger log = Logger.getLogger(GoogleMySqlResultMode.class);
	
	private final ProcessorResult processorResult;
	private GoogleMySql google;
	
	public GoogleMySqlResultMode() {
		this.processorResult = new GoogleMySqlProcessorResult();
		this.processorResult.addStepResult(new ExtractColumnStep());
		try {
		this.google = new GoogleMySql();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public <T> Result<T> getResult(String sql, T retorno){
		ResultSet resultSet;
		Result<T> result = null;
		try {
			log.info("Instanciando GoogleMySql: "+sql);
			System.out.println("Instanciando GoogleMySql: "+sql);
			resultSet = this.google.select(sql);
			log.info("Realizando Select com retorno: "+ resultSet);
			PackageResult<T> packageResult = new PackageResult<T>(resultSet, retorno);
			log.info("packageResult :"+packageResult);
			result = this.processorResult.process(packageResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultSet select(String select) throws Exception {
		return google.select(select);
	}

	public boolean update(String update) throws Exception {
		return google.update(update);
	}

	public boolean delete(String delete) throws Exception {
		return this.google.delete(delete);
	}

	public boolean insert(String insert) throws Exception {
		return this.google.insert(insert);
	}
}
