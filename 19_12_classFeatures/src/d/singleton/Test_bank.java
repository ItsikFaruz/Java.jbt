package d.singleton;

public class Test_bank {

	public static void main(String[] args) {

		
		
			Bank bank1 = Bank.getInstance();
			Bank bank2 = Bank.getInstance();
			Bank bank3 = Bank.getInstance();
			
			
			bank1.addCustomer();
			bank1.addCustomer();
			bank1.addCustomer();
			
			bank2.removeCustomer();
			
			System.out.println(bank3.getNumberOfCustomers());
	}

}
