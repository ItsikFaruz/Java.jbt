package CustomerFacadeTest;

import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.CustomerFacade;

public class TestLogIn {

	public static void main(String[] args) {

		try {

			CustomerFacade customerFacade = new CustomerFacade();

			
			System.out.println(customerFacade.login("zz", "zz"));
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
