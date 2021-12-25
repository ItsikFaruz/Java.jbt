package d.singleton;

public class Bank {

	
	
//======================singleton pattern=================
		//1. private CTOR
		private Bank() {
			
		}
		//2. private static instance of bank
		private static Bank instance = new Bank();
		//3.
		public static Bank getInstance() {
			return instance;
		}

		
		
		
		
		//====================|Bank business====================
		private int numberOfCustomers;
		
		public void addCustomer() {
			numberOfCustomers++;
		}
		
		public void removeCustomer() {
			numberOfCustomers--;
		
		}

		public int getNumberOfCustomers() {
			return numberOfCustomers;
		}

	
		
		
		
}