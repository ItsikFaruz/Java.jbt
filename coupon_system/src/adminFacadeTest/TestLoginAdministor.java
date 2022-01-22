package adminFacadeTest;

import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;
import coupon.core.facades.ClientFacade;

public class TestLoginAdministor {

	public static void main(String[] args) throws CouponSystemException {

		ClientFacade admin = new AdminFacade();
		
	    System.out.println(admin.login("admin@admin.com", "admin"))	;

	}

}
