package companyFacadeTest;

import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.CompanyFacade;

public class TestGetCompanyCouponn {

	public static void main(String[] args) {
		
		try {

			CompanyFacade companyfacade = new CompanyFacade();
			
			
			System.out.println(companyfacade.getCompanyCoupon());
			
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
