package Bank_singleton;

public class Bank {

	private Bank() {
		
	}
	
	
	//---------------------------------
	private static Bank instance = new Bank();

	public static Bank getInstance() {
		return instance;
	}
	
	//---------------------------------
	
	private double balance ;
	private int numberOfCustomers;

	//---------------------------------
	
	public double getBalance() {
		return balance;
	}
	public void transferMoney(double amount) {
		this.balance += amount;
	}
	public int addCustomers() {
		return numberOfCustomers++;
	}
	public int removeCustomers() {
		return numberOfCustomers--;
	}
	
	public int getNumberOfCustomers (){
		return numberOfCustomers;
	}	
	
}
