package adminFacadeTest;

import coupon.core.beans.Customer;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;

public class TestUpdateCustomer {

	public static void main(String[] args) {
		try {
			Customer c1 = new Customer(9, "lala", "lolo", "gaga", "1614");

			AdminFacade admin = new AdminFacade();

			admin.updateCustomer(c1);

			System.out.println("customer" + c1.getId() +" updated" );

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
