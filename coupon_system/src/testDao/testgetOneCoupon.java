package testDao;

import coupon.core.dao.ConnectionPool;
import coupon.core.dao.CouponDao;
import coupon.core.dao.CouponDaoDb;
import coupon.core.exception.CouponSystemException;

public class testgetOneCoupon {

	public static void main(String[] args) {



		CouponDao couponDao = new CouponDaoDb();
		
	
		try {
		
		System.out.println(couponDao.getOneCoupon(1)); 
		
	
		
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
