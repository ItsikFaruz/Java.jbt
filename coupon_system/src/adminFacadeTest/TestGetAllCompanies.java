package adminFacadeTest;

import java.util.ArrayList;
import java.util.List;

import coupon.core.beans.Company;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;

public class TestGetAllCompanies {

	public static void main(String[] args) {
		try {

			AdminFacade admin = new AdminFacade("admin@admin.com", "admin");

			List<Company> allcompnies = new ArrayList<>();
			allcompnies = admin.getAllCompanies();

			for (Company company : allcompnies) {
				System.out.println(company);
			}

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
