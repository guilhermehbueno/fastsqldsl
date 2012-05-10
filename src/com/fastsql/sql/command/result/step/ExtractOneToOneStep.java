package com.fastsql.sql.command.result.step;

import java.util.logging.Logger;

import com.fastsql.sql.command.result.PackageResult;
import com.fastsql.sql.command.result.StepResult;

public class ExtractOneToOneStep implements StepResult{
	
	private final Logger log = Logger.getLogger(ExtractOneToOneStep.class.getName());
	
	@Override
	public void execute(PackageResult packageResult) {
		log.info("Executando");
	}
}
