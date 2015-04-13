package biz.neustar.refactor.demo.extractinterface;

public class TransactionLog {
	public void saveTransaction(Transaction transaction) {
		System.out.println("Transaction saved");
	}
	
	public void recordError(int code) {
		System.out.println("Error code " + code + " reported");
	}
}
