package biz.neustar.atm.hardware;

import java.util.Random;

public class Buttons {
	private static Buttons instance = null;
	
	public static Buttons getInstance() {
		if(instance == null) {
			instance = new Buttons();
		}
		return instance;
	}
	
	private Buttons() {}
	
	//Has a button been pressed since the last input check?
	private boolean buttonState = false;
	
	public boolean isButtonPressed() {
		return buttonState;
	}
	
	public void clearButtonState() {
		buttonState = false;
	}
	
	public void pushButton() {
		buttonState = true;
	}
	
	/*
	* Each button is represented by a boolean to represent whether it is being held down or not
	* To figure out which array index refers to which button, please refer to the Neustar
	* Official ATM Reference Manual, page 537, paragraph 2.  To obtain a copy of the Neustar
	* Official ATM Reference Manual, please see your manager, and request Form #1937b,
	* Reference Manual Requesition Request
	* */
	public boolean[] getButtonState() {
		throw new IllegalArgumentException("External dependency accessed. #Fail");
	}
	
	public boolean isLoginPressed() {
		return getButtonState()[0];
	}
	
	public boolean isDepositPressed() {
		return getButtonState()[1];
	}
	
	public boolean isWithdrawalPressed() {
		return getButtonState()[2];
	}
	
	public float getAmount() {
		Random random = new Random();
		return random.nextFloat() * 300 + 1;
	}
}
