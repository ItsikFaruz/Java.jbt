package adminFacadeTest;

import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;

public class TestGetOneCustomer {

	public static void main(String[] args) {
		try {
			

			AdminFacade admin = new AdminFacade("admin@admin.com" , "admin");

			

			System.out.println(admin.getOneCustomer(9));

		} catch (CouponSystemException e) {

			e.printStackTrace();
		} finally {
			try {
				ConnectionPool.getInstance().closeAllConnections();
				System.out.println("all connections closed");
			} catch (CouponSystemException e) {
				e.printStackTrace();
			}
		}

	}

}
