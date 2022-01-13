package test;

import java.time.LocalDate;

import coupon.core.beans.Coupon;
import coupon.core.dao.ConnectionPool;
import coupon.core.dao.CouponDao;
import coupon.core.dao.CouponDaoDb;
import coupon.core.exception.CouponSystemException;

public class testAddCoupon {

	public static void main(String[] args) {

		Coupon coupon1 = new Coupon(0, 1, Coupon.Category.values()[1], "vecation", "road", LocalDate.of(2010, 12, 11),
				LocalDate.of(2022, 12, 15), 10, 25, "ahah");

		CouponDao couponDao = new CouponDaoDb();

		try {
			couponDao.addCoupon(coupon1);

			System.out.println("coupon added");
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
