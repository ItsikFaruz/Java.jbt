package logInManagerTest;

import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;
import coupon.core.facades.CompanyFacade;
import coupon.core.facades.CustomerFacade;
import logInManager.core.LoginManager;
import logInManager.core.clients.ClientType;

public class TestLoginManager {

	public static void main(String[] args) throws CouponSystemException {

	LoginManager logintClient = LoginManager.getInstance();

	CustomerFacade customerFacade = (CustomerFacade) logintClient.logIn("zz", "zz", ClientType.CUSTOMER);
	CompanyFacade companyFacade = (CompanyFacade) logintClient.logIn("zzz", "zzz", ClientType.COMPANY);
	AdminFacade adminFacade = (AdminFacade) logintClient.logIn("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
	 
//	if (customerFacade == null) 
//		throw new CouponSystemException("EROOR: Login failed");

//	if (companyFacade == null) 
//		throw new CouponSystemException("EROOR: Login failed");

	if (adminFacade == null) 
		throw new CouponSystemException("EROOR: Login failed");
		
	
	
//	System.out.println("Customer: " +  customerFacade.getId() + " conected" );
//	System.out.println("Company: " +  companyFacade.getId() + " conected" );
	System.out.println("Administrator conected" );
	  
	    	
	}	

}
