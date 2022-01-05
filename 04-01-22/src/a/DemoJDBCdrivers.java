package a;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DemoJDBCdrivers {

	public static void main(String[] args) {
		
		
		// to get available jbdc
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		
		
		System.out.println("available jbdc driver:");
		while(drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			System.out.println(driver);
		}
		
		System.out.println("====================");
		
	}
	
}
