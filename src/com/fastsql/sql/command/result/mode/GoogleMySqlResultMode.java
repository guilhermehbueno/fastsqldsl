package com.fastsql.sql.command.result.mode;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.fastsql.sql.command.result.PackageResult;
import com.fastsql.sql.command.result.ProcessorResult;
import com.fastsql.sql.command.result.QueryResult;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.impl.GoogleMySqlProcessorResult;
import com.fastsql.sql.command.result.step.ExtractColumnStep;
import com.fastsql.sql.command.result.step.ExtractEnumeratedStep;
import com.fastsql.sql.command.result.step.ExtractManyToManyStep;
import com.fastsql.sql.command.result.step.ExtractManyToOneStep;
import com.fastsql.sql.command.result.step.ExtractOneToManyStep;
import com.fastsql.sql.command.result.step.ExtractOneToOneStep;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;
import com.fastsql.sql.util.GoogleMySql;
import com.google.cloud.sql.jdbc.ResultSet;

public class GoogleMySqlResultMode  implements ResultMode{
	
	private Logger log = Logger.getLogger(GoogleMySqlResultMode.class);
	
	private final ProcessorResult processorResult;
	private GoogleMySql google;
	
	public GoogleMySqlResultMode() {
		this.processorResult = new GoogleMySqlProcessorResult();
		this.processorResult.addStepResult(new ExtractColumnStep());
		this.processorResult.addStepResult(new ExtractEnumeratedStep());
		this.processorResult.addStepResult(new ExtractManyToManyStep());
		this.processorResult.addStepResult(new ExtractManyToOneStep());
		this.processorResult.addStepResult(new ExtractOneToManyStep());
		this.processorResult.addStepResult(new ExtractOneToOneStep());
		try {
		this.google = new GoogleMySql();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public <T> Result<T> getResult(String sql, T retorno){
		ResultSet resultSet;
		Result<T> result = null;
		try {
			log.info("Instanciando GoogleMySql: "+sql);
			System.out.println("Instanciando GoogleMySql: "+sql);
			resultSet = this.google.select(sql);
			log.info("Realizando Select com retorno: "+ resultSet);
			PackageResult packageResult = new PackageResult(resultSet, retorno);
			log.info("packageResult :"+packageResult);
			result = this.processorResult.process(packageResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultSet select(String select) throws Exception {
		return google.select(select);
	}

	@Override
	public boolean update(String update) throws Exception {
		return google.update(update);
	}

	@Override
	public boolean delete(String delete) throws Exception {
		return this.google.delete(delete);
	}


	@Override
	public boolean insert(String insert) throws Exception {
		return this.google.insert(insert);
	}
}
