package biz.neustar.atm.hardware;

public class Display {
	public static Display instance;
	
	private Display() {
		
	}
	
	public static Display getInstance() {
		if(instance == null) {
			instance = new Display();
		}
		return instance;
	}
	
	public void writeText(String test) {
		throw new IllegalArgumentException("External dependency accessed. #Fail");
	}
}
