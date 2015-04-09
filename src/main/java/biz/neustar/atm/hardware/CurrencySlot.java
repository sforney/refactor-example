package biz.neustar.atm.hardware;

import java.util.Random;

import biz.neustar.refactor.currency.Bills;
import biz.neustar.refactor.currency.Coins;
import biz.neustar.refactor.currency.Currency;

public class CurrencySlot {
	public static CurrencySlot instance;
	private Random random;
	
	private CurrencySlot() {
		random = new Random();
	}
	
	public static CurrencySlot getInstance() {
		if(instance == null) {
			instance = new CurrencySlot();
		}
		return instance;
	}
	
	public Currency[] acceptCurrency() {
		int numBills = random.nextInt(5);
		int numCoins = random.nextInt(10);
		Currency [] objects = new Currency[numBills + numCoins];
		for(int i = 0; i < numBills; i++) {
			int bill = random.nextInt(7);
			switch(bill) {
			case 0:
				objects[i] = Bills.ONE;
			case 1:
				objects[i] = Bills.FIVE;
			case 2:
				objects[i] = Bills.TEN;
			case 3:
				objects[i] = Bills.TWENTY;
			case 4:
				objects[i] = Bills.FIFTY;
			case 5:
				objects[i] = Bills.HUNDRED;	
			case 6:
				objects[i] = Bills.TWO;
			}
		}
		for(int i = 0; i < numCoins; i++) {
			int coin = random.nextInt(6);
			switch(coin) {
			case 0:
				objects[i] = Coins.PENNY;
			case 1:
				objects[i] = Coins.NICKEL;
			case 2:
				objects[i] = Coins.DIME;
			case 3:
				objects[i] = Coins.QUARTER;
			case 4:
				objects[i] = Bills.FIFTY;
			case 5:
				objects[i] = Coins.DOLLAR;	
			}
		}
		return objects;
	}
}
