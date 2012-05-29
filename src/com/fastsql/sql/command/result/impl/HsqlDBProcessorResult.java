package com.fastsql.sql.command.result.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fastsql.sql.command.result.PackageResult;
import com.fastsql.sql.command.result.ProcessorResult;
import com.fastsql.sql.command.result.Result;
import com.fastsql.sql.command.result.StepResult;

public class HsqlDBProcessorResult  implements ProcessorResult{
	
	private static Logger log = Logger.getLogger(GoogleMySqlProcessorResult.class);
	private final List<StepResult> steps = new ArrayList<StepResult>();

	@Override
	public <T> Result<T> process(PackageResult packageResult) {
		for (StepResult step : this.steps) {
			log.info(this.getClass().getSimpleName()+" Executando: "+step.getClass().getSimpleName());
			step.execute(packageResult);
		}
		return new Result<T>(packageResult.getResults());
	}

	@Override
	public void addStepResult(StepResult stepResult) {
		if(stepResult!=null){
			steps.add(stepResult);
		}
	}

}
