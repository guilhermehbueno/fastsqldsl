package com.fastsql.sql.builder;

import com.fastsql.sql.api.Delete;
import com.fastsql.sql.api.From;
import com.fastsql.sql.api.Insert;
import com.fastsql.sql.api.Select;
import com.fastsql.sql.api.Update;
import com.fastsql.sql.command.delete.DeleteImpl;
import com.fastsql.sql.command.insert.InsertImpl;
import com.fastsql.sql.command.result.mode.GoogleMySqlResultMode;
import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.command.select.SelectImpl;
import com.fastsql.sql.command.update.UpdateImpl;
import com.fastsql.sql.configuration.ConfigurationContext;
import com.fastsql.sql.configuration.exception.ConfigurationException;

public class SqlTool {
	
	private final ResultMode mode;
	
	public SqlTool(ResultMode resultMode) {
		super();
		this.mode = resultMode;
	}
	
	public SqlTool() throws ConfigurationException {
		super();
		this.mode = ConfigurationContext.getConfiguration().getResultMode();
	}

	public static SqlTool getInstance(ResultMode mode){
		return new SqlTool(mode);
	}
	
	public static SqlTool getInstance() throws ConfigurationException{
		return new SqlTool();
	}
	
	public Select select(String atributo) throws Exception{
		return new SelectImpl(atributo,this.mode);
	}
	
	public From select(Class modelo) throws Exception{
		return new SelectImpl(modelo, this.mode);
	}
	
	public Update update(Object entidade) throws Exception{
		return new UpdateImpl(entidade, this.mode);
	}
	
	public Delete delete(String nomeEntidade){
		return new DeleteImpl(nomeEntidade, this.mode);
	}
	
	public Delete delete(Object entidade) throws Exception{
		return new DeleteImpl(entidade, this.mode);
	}
	
	public Insert insert(Object entidade) throws Exception{
		return new InsertImpl(entidade, this.mode);
	}

}
