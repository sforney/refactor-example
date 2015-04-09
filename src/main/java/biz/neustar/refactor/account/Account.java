package biz.neustar.refactor.account;

public class Account {
	private float balance = 0.0f;
	private String accountId;
	
	public void deposit(float amount) {
		balance += amount;
	}
	
	public void withdraw(float amount) {
		balance -= amount;
	}
	
	public float getBalance() {
		return balance;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
