package test;

import coupon.core.dao.ConnectionPool;
import coupon.core.dao.CustomerDao;
import coupon.core.dao.CustomerDaoDb;
import coupon.core.exception.CouponSystemException;

public class testCustomer {

	public static void main(String[] args) {
		
		//Customer c1 = new Customer(3,"bbb","go","@@@","12345");
		
		try {
			CustomerDao castumerDao = new CustomerDaoDb();
		System.out.println( castumerDao.getAllCustomer());
			
			System.out.println("customer show");
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
