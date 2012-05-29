package com.fastsql.sql.command.result.mode;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.fastsql.sql.command.result.PackageResult;
import com.fastsql.sql.command.result.ProcessorResult;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.impl.HsqlDBProcessorResult;
import com.fastsql.sql.command.result.step.ExtractColumnStep;
import com.fastsql.sql.command.result.step.ExtractEnumeratedStep;
import com.fastsql.sql.command.result.step.ExtractManyToManyStep;
import com.fastsql.sql.command.result.step.ExtractManyToOneStep;
import com.fastsql.sql.command.result.step.ExtractOneToManyStep;
import com.fastsql.sql.command.result.step.ExtractOneToOneStep;
import com.fastsql.sql.util.HsqlDB;

public class HsqlDBResultMode implements ResultMode{
	
	private final ProcessorResult processorResult;
	private static Logger log = Logger.getLogger(HsqlDBResultMode.class);
	private HsqlDB hsqlDB;
	
	public HsqlDBResultMode() throws Exception {
		this.hsqlDB = new HsqlDB();
		this.processorResult = new HsqlDBProcessorResult();
		this.processorResult.addStepResult(new ExtractColumnStep());
		this.processorResult.addStepResult(new ExtractEnumeratedStep());
		this.processorResult.addStepResult(new ExtractManyToManyStep());
		this.processorResult.addStepResult(new ExtractManyToOneStep());
		this.processorResult.addStepResult(new ExtractOneToManyStep());
		this.processorResult.addStepResult(new ExtractOneToOneStep());
	}

	@Override
	public <T> Result<T> getResult(String sql, T retorno) {
		ResultSet resultSet;
		Result<T> result = null;
		try {
			log.info("Instanciando GoogleMySql: "+sql);
			System.out.println("Instanciando GoogleMySql: "+sql);
			resultSet = this.hsqlDB.select(sql);
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
		return this.hsqlDB.select(select);
	}

	@Override
	public boolean update(String update) throws Exception {
		return this.hsqlDB.update(update);
	}

	@Override
	public boolean delete(String delete) throws Exception {
		return this.hsqlDB.delete(delete);
	}

	@Override
	public boolean insert(String insert) throws Exception {
		return this.hsqlDB.insert(insert);
	}
}
