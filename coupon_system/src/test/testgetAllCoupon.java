package test;

import java.util.ArrayList;
import java.util.List;

import coupon.core.beans.Coupon;
import coupon.core.dao.ConnectionPool;
import coupon.core.dao.CouponDao;
import coupon.core.dao.CouponDaoDb;
import coupon.core.exception.CouponSystemException;

public class testgetAllCoupon {

	public static void main(String[] args) {



		CouponDao couponDao = new CouponDaoDb();
		
		List<Coupon> coupons = new ArrayList<>();
		try {
		
		coupons= couponDao.getAllCoupon();
		
		for (Coupon coupon : coupons) {
			System.out.println(coupon);
		}
		
		
			System.out.println("\n\tEND\n");
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
