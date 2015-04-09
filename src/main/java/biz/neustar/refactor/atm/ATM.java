package biz.neustar.refactor.atm;

import biz.neustar.atm.hardware.Buttons;
import biz.neustar.atm.hardware.CurrencySlot;
import biz.neustar.atm.hardware.Display;
import biz.neustar.refactor.account.Account;
import biz.neustar.refactor.currency.Bills;
import biz.neustar.refactor.currency.Coins;
import biz.neustar.refactor.currency.Currency;
import biz.neustar.refactor.db.BankDB;
import biz.neustar.refactor.db.DBManagerHelper;
import biz.neustar.refactor.server.ATMServer;
import biz.neustar.refactor.server.ATMServerConfiguration;

/**
 * A singleton, since there's only one ATM
 * @author sforney
 *
 */
public class ATM {
	private static ATM instance;
	public static ATMServer server;
	private Account currentAccount;
	private Display display;
	private Buttons input;
	
	private ATM() {
		server = ATMServer.getInstance();
		currentAccount = null;
		display = Display.getInstance();
	}
	
	public static ATM getInstance() {
		if(instance == null) {
			instance = new ATM();
		}
		return instance;
	}
	
	
	
	public void deposit() {
		display.writeText("Please insert bills and/or coins");
		Currency [] currency = CurrencySlot.getInstance().acceptCurrency();
		float amount = 0.0f;
		for(Currency cur : currency) {
			if(cur instanceof Bills) {
				amount += BillCounter.readBill((Bills)cur);
			} else if(cur instanceof Coins) {
				amount += CoinCounter.readCoin((Coins) cur);
			}
		}
		currentAccount.deposit(amount);
		ATMServerConfiguration config = new ATMServerConfiguration();
		BankDB bankDB = DBManagerHelper.getDBConnection(config.getDbUsername(), config.getDbPassword(), config.getDbName());
		bankDB.writeToDB("account", "funds", amount);
	}
	
	public void withdraw() {
		display.writeText("Enter amount to withdraw");
		float amount = input.getAmount();
		currentAccount.withdraw(amount);
		server.updateAccount(currentAccount);
		dispenseFunds(amount);
	}
	
	public void getBalance() {
		float balance = currentAccount.getBalance();
		display.writeText("Current balance is " + balance);
	}
	
	public void dispenseFunds(Float amount) {
		display.writeText("Please remove your funds from the currency bin");
		System.out.println("Dispensed $" + amount + " to customer " + currentAccount.getAccountId());
	}
	
	public void process() {
		while(true) {
			if(input.isButtonPressed()) {
				processInput(input);
				input.clearButtonState();
			}
		}
	}
	
	public void login() {
		ATMServerConfiguration config = new ATMServerConfiguration();
		BankDB bankDB = DBManagerHelper.getDBConnection(config.getDbUsername(), config.getDbPassword(), config.getDbName());
		currentAccount = bankDB.getAccount("1010011010");
	}
	
	public void processInput(Buttons input) {
		if(input.isLoginPressed()) {
			login();
		} else if(input.isDepositPressed()) {
			deposit();
		} else if(input.isWithdrawalPressed()) {
			withdraw();
		}
	}
}
