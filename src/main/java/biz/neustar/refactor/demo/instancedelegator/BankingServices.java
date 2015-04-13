package biz.neustar.refactor.demo.instancedelegator;

public class BankingServices {
	public static void updateAccountBalance(int userId, Money money) {
		System.out.println("Account balance updated!");
	}
}
