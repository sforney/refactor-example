package biz.neustar.refactor.server;

import biz.neustar.refactor.account.Account;
import biz.neustar.refactor.db.BankDB;
import biz.neustar.refactor.db.DBManagerHelper;

/**
 * Obviously this needs to be a singleton as there will only 
 * ever be one ATM server
 * @author sforney
 *
 */
public class ATMServer {
	private static ATMServer instance;
	private ATMServerConfiguration config;
	
	private ATMServer() {
		config = new ATMServerConfiguration();
	}
	
	public static ATMServer getInstance() {
		if(instance == null) {
			instance = new ATMServer();
		}
		return instance;
	}
	
	public void updateAccount(Account account) {
		BankDB db = DBManagerHelper.getDBConnection(config.getDbUsername(), config.getDbPassword(), config.getDbName());
		db.updateAccount(account);
	}
}
