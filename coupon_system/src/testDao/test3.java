package testDao;

import coupon.core.dao.CompanyDao;
import coupon.core.dao.CompanyDaoDb;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;

public class test3 {

	public static void main(String[] args) {
		
		
		try {
		//	Company cmp = new Company(2, "pharm", "@@", "5555");
			CompanyDao dao = new CompanyDaoDb();
			
			System.out.println(dao.getAllCompanies());
			
			System.out.println("company deleted");
			//System.out.println(cmp);
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
