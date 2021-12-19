package Bank_singleton;

public class client {
	
	private double balance;
	
	public void deposit(double amount) {
		balance += amount;
		double commission = amount * 0.05;
		Bank.getInstance().transferMoney(commission);
		
	}
	

}
