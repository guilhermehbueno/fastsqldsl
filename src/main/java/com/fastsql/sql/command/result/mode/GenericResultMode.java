package com.fastsql.sql.command.result.mode;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.fastsql.sql.command.result.PackageResult;
import com.fastsql.sql.command.result.ProcessorResult;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.impl.GoogleMySqlProcessorResult;
import com.fastsql.sql.command.result.step.ExtractColumnStep;
import com.fastsql.sql.util.GenericSqlCommands;

public class GenericResultMode implements ResultMode{


	private Logger log = Logger.getLogger(GoogleMySqlResultMode.class);
	
	private final ProcessorResult processorResult;
	private GenericSqlCommands generic;
	
	public GenericResultMode() {
		this.processorResult = new GoogleMySqlProcessorResult();
		this.processorResult.addStepResult(new ExtractColumnStep());
		try {
		this.generic = new GenericSqlCommands();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public <T> Result<T> getResult(String sql, T retorno){
		ResultSet resultSet;
		Result<T> result = null;
		try {
			log.info("Instanciando GoogleMySql: "+sql);
			System.out.println("Instanciando GoogleMySql: "+sql);
			resultSet = this.generic.select(sql);
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
		return generic.select(select);
	}

	public boolean update(String update) throws Exception {
		return generic.update(update);
	}

	public boolean delete(String delete) throws Exception {
		return this.generic.delete(delete);
	}

	public boolean insert(String insert) throws Exception {
		return this.generic.insert(insert);
	}
}
