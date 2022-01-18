package companyFacadeTest;

import coupon.core.beans.Coupon.Category;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.CompanyFacade;

public class TestGetCompanyCouponnOfCategory {

	public static void main(String[] args) {
		
		try {

			CompanyFacade companyfacade = new CompanyFacade("@$@$","55");
			
			
			System.out.println(companyfacade.getCompanyCouponsByCategory(Category.TRAVEL));
			
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
