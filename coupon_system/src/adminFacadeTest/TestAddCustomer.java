package adminFacadeTest;

import coupon.core.beans.Customer;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;

public class TestAddCustomer {

	public static void main(String[] args) {
		try {
			Customer c1 = new Customer(0, "laffla", "lolo", "gffaga", "16ff4");

			AdminFacade admin = new AdminFacade("admin@admin.com", "admin");

			int id = admin.addCustomer(c1);

			System.out.println("customer: " + id  +" added" );

			System.out.println(c1);
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
