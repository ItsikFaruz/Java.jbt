package test;

import coupon.core.beans.Company;
import coupon.core.dao.CompanyDao;
import coupon.core.dao.CompanyDaoDb;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;

public class test1 {

	public static void main(String[] args) {
		
		
		try {
			Company cmp = new Company(0, "super", "@@", "1234");
			CompanyDao dao = new CompanyDaoDb();
			int id = dao.addCompany(cmp);
			dao.addCompany(cmp);
			
			System.out.println("created company" + id);
			System.out.println(cmp);
		} catch (CouponSystemException e) {
			
			
			e.printStackTrace();
		}finally {
			try {
				ConnectionPool.getInstance().closeAllConnections();
				System.out.println("all connections closed");
			} catch (CouponSystemException e) {
				e.printStackTrace();
			}
		}
		
	
	}

}
