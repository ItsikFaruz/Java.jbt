package Bank_singleton;



public class Test_bank {

	public static void main(String[] args) {
		
		Bank bank1 = Bank.getInstance();
		
		bank1.addCustomers();
		bank1.addCustomers();
		bank1.addCustomers();
		bank1.addCustomers();
		bank1.addCustomers();
	
		System.out.println(Bank.getInstance().getBalance());
		bank1.transferMoney(1000);
		System.out.println(Bank.getInstance().getBalance());
		
		client cl1 = new client();
		cl1.deposit(1000);
		System.out.println(Bank.getInstance().getBalance());
		System.out.println(Bank.getInstance().getNumberOfCustomers());
	
		
		
	}

}
