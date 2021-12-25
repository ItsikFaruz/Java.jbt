package bank_exercise;

public class Logger {
	
	String driverName;

	public Logger(String driverName) {
		super();
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	public void log (Log log) {
		System.out.println(log.getData());
		
	}
	
	public Log[] getLogs() {
		System.out.println("not yet supported");
		return null;
	}

}
