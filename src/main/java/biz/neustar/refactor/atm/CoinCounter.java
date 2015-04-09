package biz.neustar.refactor.atm;

import biz.neustar.refactor.currency.Coins;

public class CoinCounter {
	public static float readCoin(Coins coin) {
		switch(coin) {
		case PENNY:
			return 0.01f;
		case NICKEL:
			return 0.05f;
		case DIME:
			return 0.1f;
		case QUARTER:
			return 0.25f;
		case FIFTY:
			return 0.5f;
		case DOLLAR:
			return 0.0f;
		default:
			throw new IllegalArgumentException("Unknown coin type " + coin.toString());
		}
	}
}
