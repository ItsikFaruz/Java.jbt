package adminFacadeTest;

import coupon.core.beans.Company;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;

public class TestAddCompany {

	public static void main(String[] args) {
		try {
			Company aaa = new Company(0, "hat", "phza", "555");

			AdminFacade admin = new AdminFacade("admin@admin.com" , "admin");

			int id = admin.addCompany(aaa);

			System.out.println("created company:" + id + " id");

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
