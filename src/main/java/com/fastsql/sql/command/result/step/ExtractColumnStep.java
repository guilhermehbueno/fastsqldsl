package com.fastsql.sql.command.result.step;

import java.util.List;
import java.util.logging.Logger;

import com.fastsql.sql.command.result.PackageResult;
import com.fastsql.sql.command.result.StepResult;
import com.fastsql.sql.util.ResultSetUtil;

public class ExtractColumnStep implements StepResult{

private final Logger log = Logger.getLogger(ExtractColumnStep.class.getName());
	
	public void execute(PackageResult packageResult) {
		log.info("ExtractColumnStep Executando execute");
		List result = null;
		try {
			result = ResultSetUtil.extractEntityFrom(packageResult.getResultSet(), packageResult.getModelo());
			packageResult.setResults(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
