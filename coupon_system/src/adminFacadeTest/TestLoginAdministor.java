package adminFacadeTest;

import coupon.core.facades.AdminFacade;

public class TestLoginAdministor {

	public static void main(String[] args) {

		AdminFacade admin = new AdminFacade("admin@admin.com", "admin");

	    System.out.println(admin.login(admin.getEmail(), admin.getPassword())); 	

	}

}
