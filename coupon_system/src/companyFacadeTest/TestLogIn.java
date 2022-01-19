package companyFacadeTest;

import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.CompanyFacade;

public class TestLogIn {

	public static void main(String[] args) {

		try {

			CompanyFacade companyfacade = new CompanyFacade("@@", "1234");
			
			
			System.out.println(companyfacade.login(companyfacade.getEmail(),companyfacade.getPassword()));
			System.out.println(companyfacade.getId());
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
