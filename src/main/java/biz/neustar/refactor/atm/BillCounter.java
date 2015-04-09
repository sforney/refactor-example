package biz.neustar.refactor.atm;

import biz.neustar.refactor.currency.Bills;

public class BillCounter {
	public static float readBill(Bills bill) {
		switch(bill) {
		case ONE:
			return 1.0f;
		case TWO:
			return 2.0f;
		case FIVE:
			return 5.0f;
		case TEN:
			return 10.0f;
		case TWENTY:
			return 20.0f;
		case FIFTY:
			return 50.0f;
		case HUNDRED:
			return 1000.0f;
		default:
			throw new IllegalArgumentException("Unknown bill type " + bill.toString());
		}
	}
}
