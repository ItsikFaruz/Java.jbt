package adminFacadeTest;

import coupon.core.beans.Company;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;

public class TestAddCompany {

	public static void main(String[] args) {
		try {
			Company aaa = new Company(0, "beitar", "aa", "fff");

			AdminFacade admin = new AdminFacade();

			int id = admin.addCompany(aaa);

			System.out.println("created company" + id);

			System.out.println(aaa);
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
