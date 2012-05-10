package com.fastsql.sql.builder;

import com.fastsql.sql.api.Delete;
import com.fastsql.sql.api.From;
import com.fastsql.sql.api.Insert;
import com.fastsql.sql.api.Select;
import com.fastsql.sql.api.Update;
import com.fastsql.sql.command.insert.InsertImpl;
import com.fastsql.sql.command.result.mode.GoogleMySqlResultMode;
import com.fastsql.sql.command.result.mode.ResultMode;
import com.fastsql.sql.command.select.SelectImpl;

public class SqlTool {
	
	private final ResultMode mode;
	
	public SqlTool(ResultMode resultMode) {
		super();
		this.mode = resultMode;
	}
	
	public SqlTool() {
		super();
		//TODO: INICIAR COM IMPLEMENTACAO DEFAULT QUE PODERA SER RECUPERADA DE UM XML NO CONTEXTO.
		this.mode = new GoogleMySqlResultMode();
	}

	public static SqlTool getInstance(ResultMode mode){
		return new SqlTool(mode);
	}
	
	public static SqlTool getInstance(){
		return new SqlTool();
	}
	
	public Select select(String atributo){
		return new SelectImpl(atributo,this.mode);
	}
	
	public From select(Class modelo){
		return new SelectImpl(modelo, this.mode);
	}
	
	public static Update update(){
		return null;
	}
	
	public static Delete delete(){
		return null;
	}
	
	public static Insert insert(Object entidade) throws Exception{
		return new InsertImpl(entidade);
	}

}