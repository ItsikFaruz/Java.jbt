package CustomerFacadeTest;

import coupon.core.beans.Coupon;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.CustomerFacade;

public class TestCouponPurchase {

	public static void main(String[] args) {

		Coupon coupon1 = new Coupon(9);
				
		
		try {

			CustomerFacade customerFacade = new CustomerFacade();
			customerFacade.login("zz", "zz");
			customerFacade.purchaseCoupon(coupon1);
			System.out.println(coupon1.getId() + " purchsed");

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
