package testDao;

import java.time.LocalDate;

import coupon.core.beans.Coupon;
import coupon.core.dao.ConnectionPool;
import coupon.core.dao.CouponDao;
import coupon.core.dao.CouponDaoDb;
import coupon.core.exception.CouponSystemException;

public class testUpdateCoupon {

	public static void main(String[] args) {

		Coupon coupon1 = new Coupon(2, 1, Coupon.Category.values()[3], "plaza", "boat", LocalDate.of(2010, 12, 11),
				LocalDate.of(2022, 12, 15), 10, 25, "aaaa");

		CouponDao couponDao = new CouponDaoDb();

		try {
			couponDao.updateCoupon(coupon1);

			System.out.println("coupon: " + coupon1.getId() + " updated");
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
