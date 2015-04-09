package biz.neustar.refactor.atm;

public class ATMStart {
	public static void main(String [] args) throws Exception{
		ATM atm = ATM.getInstance();
		atm.process();
	}
}
