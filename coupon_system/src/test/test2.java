package test;

import java.sql.Connection;

import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;

public class test2 {

	public static void main(String[] args) {

		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection con1 = pool.getConnection();
			Connection con2 = pool.getConnection();
			Connection con3 = pool.getConnection();
			Connection con4 = pool.getConnection();
			Connection con5 = pool.getConnection();
			System.out.println("got 5 connection from pool");
			pool.restoreConnection(con1);
			pool.restoreConnection(con2);
			pool.restoreConnection(con3);
			pool.restoreConnection(con4);
			pool.restoreConnection(con5);
			System.out.println("returned 5 connections from pool");
		} catch (CouponSystemException e) {
			System.out.println("error" + e.getMessage());
		}finally {
			try {
				ConnectionPool.getInstance().closeAllConnections();
			} catch (CouponSystemException e) {
				e.printStackTrace();
			}
		}
		
	}

}
