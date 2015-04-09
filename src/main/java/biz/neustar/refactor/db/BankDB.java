package biz.neustar.refactor.db;

import biz.neustar.refactor.account.Account;

public class BankDB {
	public void writeToDB(String table, String column, String value) {
		throw new IllegalArgumentException("External dependency created. #Fail");
	}
	
	public void writeToDB(String table, String column, float value) {
		throw new IllegalArgumentException("External dependency created. #Fail");
	}
	
	public void updateAccount(Account account) {
		throw new IllegalArgumentException("External dependency created. #Fail");
	}
	
	public Account getAccount(String accountId) {
		throw new IllegalArgumentException("External dependency created. #Fail");
	}
}
