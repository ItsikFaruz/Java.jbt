package CustomerFacadeTest;

import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.CustomerFacade;

public class TestLogIn {

	public static void main(String[] args) {

		try {

			CustomerFacade customerFacade = new CustomerFacade("izik", "1514");

			System.out.println(customerFacade.login(customerFacade.getEmail(), customerFacade.getPassword()));
			System.out.println("customer: " + customerFacade.getId() + " connected");
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
