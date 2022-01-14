package test;

import coupon.core.dao.ConnectionPool;
import coupon.core.dao.CouponDao;
import coupon.core.dao.CouponDaoDb;
import coupon.core.exception.CouponSystemException;

public class testDeleteCouponPurchseCoupon {

	public static void main(String[] args) {



		CouponDao couponDao = new CouponDaoDb();

		try {
			couponDao.deleteCouponPurchase(1, 4);

			System.out.println(" Coupon Purchase deleted");
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
