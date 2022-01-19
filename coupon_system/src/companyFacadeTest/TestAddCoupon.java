package companyFacadeTest;

import java.time.LocalDate;

import coupon.core.beans.Coupon;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.CompanyFacade;

public class TestAddCoupon {

	public static void main(String[] args) {
		
		Coupon coupon1 = new Coupon(0,11, Coupon.Category.values()[4], "ttat", "ttat", LocalDate.of(2010, 12, 11),
				LocalDate.of(2022, 10, 15), 0, 50, "lona");
		try {

			CompanyFacade companyfacade = new CompanyFacade("@@","1234");
			
			companyfacade.addCoupon(coupon1);
			
			System.out.println(coupon1);
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
