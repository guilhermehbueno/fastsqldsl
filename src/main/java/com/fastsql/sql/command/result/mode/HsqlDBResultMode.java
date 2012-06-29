package com.fastsql.sql.command.result.mode;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.fastsql.sql.command.result.PackageResult;
import com.fastsql.sql.command.result.ProcessorResult;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.impl.HsqlDBProcessorResult;
import com.fastsql.sql.command.result.step.ExtractColumnStep;
import com.fastsql.sql.util.HsqlDB;

public class HsqlDBResultMode implements ResultMode{
	
	private final ProcessorResult processorResult;
	private static Logger log = Logger.getLogger(HsqlDBResultMode.class);
	private HsqlDB hsqlDB;
	
	public HsqlDBResultMode() throws Exception {
		this.hsqlDB = new HsqlDB();
		this.processorResult = new HsqlDBProcessorResult();
		this.processorResult.addStepResult(new ExtractColumnStep());
	}

	public <T> Result<T> getResult(String sql, T retorno) {
		ResultSet resultSet;
		Result<T> result = null;
		try {
			log.info("Instanciando GoogleMySql: "+sql);
			System.out.println("Instanciando GoogleMySql: "+sql);
			resultSet = this.hsqlDB.select(sql);
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
		return this.hsqlDB.select(select);
	}

	public boolean update(String update) throws Exception {
		return this.hsqlDB.update(update);
	}

	public boolean delete(String delete) throws Exception {
		return this.hsqlDB.delete(delete);
	}

	public boolean insert(String insert) throws Exception {
		return this.hsqlDB.insert(insert);
	}
}
