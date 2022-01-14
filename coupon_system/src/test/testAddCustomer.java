package test;

import coupon.core.beans.Customer;
import coupon.core.dao.ConnectionPool;
import coupon.core.dao.CustomerDaoDb;
import coupon.core.exception.CouponSystemException;

public class testAddCustomer {

	public static void main(String[] args) {
		
		Customer c1 = new Customer(0,"dddda","ddd","%$%$","66665");
		
		try {
			CustomerDaoDb castumerDao = new CustomerDaoDb();
			
		System.out.println( castumerDao.addCustomer(c1));
			
			System.out.println("customer " +c1.getId() + " added");
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
