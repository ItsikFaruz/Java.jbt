package bank_exercise;

public class Log {

	long timestamp;
	int clientId ;
	String description;
	float amount;

	
	public Log(long timestamp, int clientId, String description, float amount) {
		super();
		this.timestamp = timestamp;
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
	}
	
		
	public String getData() {
		return "Log [timestamp=" + timestamp + ", clientId=" + clientId + ", description=" + description + ", amount="
				+ amount + "]";
	}
	
	
	
}
