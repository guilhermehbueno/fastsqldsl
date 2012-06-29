package com.fastsql.sql.command.result;

public interface ProcessorResult {
	
	public <T> Result<T> process(PackageResult packageResult);
	public void addStepResult(StepResult stepResult);

}
