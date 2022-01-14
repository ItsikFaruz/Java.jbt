package adminFacadeTest;

import java.util.ArrayList;
import java.util.List;

import coupon.core.beans.Customer;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;

public class TestGetAllCustomers {

	public static void main(String[] args) {
		try {

			AdminFacade admin = new AdminFacade();

			List<Customer> allCustomers = new ArrayList<>();
			allCustomers = admin.getAllCustomers();

			for (Customer customer : allCustomers) {
				System.out.println(customer);
			}

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
