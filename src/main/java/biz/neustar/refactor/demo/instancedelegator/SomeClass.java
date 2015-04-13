package biz.neustar.refactor.demo.instancedelegator;

public class SomeClass {
	private int id;
	private Money sum;
	
	public void someMethod() {
		BankingServices.updateAccountBalance(id, sum);
	}
}
