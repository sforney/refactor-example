package biz.neustar.refactor.server;

import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ATMServerConfiguration {
	private String dbUsername;
	private String dbPassword;
	private String dbName;
	
	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	public ATMServerConfiguration() {
		injectValues();
	}
	
	private void injectValues() {
		throw new IllegalArgumentException("External dependency accessed. #Fail");
	}
    
}
