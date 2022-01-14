package adminFacadeTest;

import coupon.core.beans.Company;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;

public class TestUpdateCompany {

	public static void main(String[] args) {
		try {
			Company aaa = new Company(9, "beitar", "adsa", "adsa");

			AdminFacade admin = new AdminFacade();

			admin.updateCompany(aaa);

			System.out.println("company " + aaa.getId() + "  updated");

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
