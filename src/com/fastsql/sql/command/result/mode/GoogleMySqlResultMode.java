package com.fastsql.sql.command.result.mode;

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
import com.fastsql.sql.util.GoogleMySql;
import com.google.cloud.sql.jdbc.ResultSet;

public class GoogleMySqlResultMode  implements ResultMode, QueryResult{
	
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
	}
	

	@Override
	public <T> Result<T> getResult(String sql, T retorno){
		ResultSet resultSet;
		Result<T> result = null;
		try {
			this.google = new GoogleMySql();
			System.out.println("Instanciando GoogleMySql");
			resultSet = this.google.select(sql);
			System.out.println("Realizando Select com retorno: "+ resultSet);
			PackageResult packageResult = new PackageResult(resultSet, retorno);
			System.out.println("packageResult :"+packageResult);
			result = this.processorResult.process(packageResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
