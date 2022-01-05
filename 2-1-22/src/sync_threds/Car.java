package sync_threds;

import java.util.ArrayList;
import java.util.List;

public class Car extends Thread {

	
	private int number;
	private int km;
	private List<String> registeredDrivers = new ArrayList<String>();
	
	
	public Car(int number) {
		super();
		this.number = number;
		
	}
	
	public void registerDriver() {
	Thread driver = currentThread();
	registeredDrivers.add(getName());
	System.out.println("\tdriver ");
	}
	
	public static void drive( int distance) {
		
		
	}
	
	
	
	
}
