package bank_exercise;

public class Client {
	
		int id ;
		String name;
		float balance ;
		Account[] accounts = new Account[5];
		float commissionRate;
		float interestRate;
		Logger logger;
		
		
		public Client(int id, String name, float balance) {
			super();
			this.id = id;
			this.name = name;
			this.balance = balance;
			Log log = new Log(System.currentTimeMillis(),id,name,balance);
			logger.log(log);
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public float getBalance() {
			return balance;
		}


		public void setBalance(float balance) {
			this.balance = balance;
		}


		public int getId() {
			return id;
		}


		public Account[] getAccounts() {
			return accounts;
		}
		
		public void addAccount(Account account) {
			for (int i=0; i<accounts.length ;i++) {
				if (accounts[i] == null) {
					accounts [i] = account;
					Log log = new Log(System.currentTimeMillis(),id,("create new account, number:" + i),this.balance);
					logger.log(log);
					break;
				}
				else {
					System.out.println("max account used");
				}
			}
					
		}
		
		public Account getAccount(int id) {
			for (Account account : accounts) {
				if (account.getId() == id) {
					return account;
				}
			}
			return null;
		}
			
		public void removeAccount(int id) {
			for (Account account : accounts) {
				if (account.getId() == id) {
					this.balance = account.getBalance();
					Log log = new Log(System.currentTimeMillis(),id,("delete client account" + account.getId()),this.balance);
					logger.log(log);
					account = null;
				}	
			}
		}
		
		public void deposit(float amount) {
			
			amount = amount - (amount*commissionRate);
			this.balance +=amount;
			Log log = new Log(System.currentTimeMillis(), this.getId(),"you deposit:", amount);
			logger.log(log);
		}
		
			public void withdraw(float amount) {
			
			amount = amount - (amount*commissionRate);
			this.balance +=amount;
			Log log = new Log(System.currentTimeMillis(), this.getId(),"withdraw" , amount);
			logger.log(log);
		}
		
		
		
		
}		
		
	
		
		


