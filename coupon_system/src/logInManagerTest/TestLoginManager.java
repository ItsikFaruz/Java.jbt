package logInManagerTest;

import coupon.core.exception.CouponSystemException;
import coupon.core.facades.ClientFacade;
import coupon.core.facades.CustomerFacade;
import logInManager.core.LoginManager;
import logInManager.core.clients.ClientType;

public class TestLoginManager {

	public static void main(String[] args) throws CouponSystemException {

		LoginManager logintClient = LoginManager.getInstance();

	ClientFacade client = logintClient.logIn("ff", "ff", ClientType.CUSTOMER);
	    
	if (client == null) {
		System.out.println("ERROR : conected failed");
	}else
		
	if (client instanceof CustomerFacade) {
		CustomerFacade customerClient = (CustomerFacade) client;
		
		System.out.println(customerClient.getId());
	}
	    
	    	
	    	System.out.println();
	    	System.out.println("conected");
	    	
	    
	}

}
