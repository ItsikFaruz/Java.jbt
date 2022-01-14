package coupon.core.dao;

import java.util.List;

import coupon.core.beans.Coupon;
import coupon.core.beans.Customer;
import coupon.core.exception.CouponSystemException;

public interface CustomerDao {

	boolean isCustomerExists(String email, String password) throws CouponSystemException;

	int addCustomer(Customer customer) throws CouponSystemException;

	void updateCustomer(Customer customer) throws CouponSystemException;

	void deleteCustomer(int customerId) throws CouponSystemException;

	Customer getOneCustomer(int customerId) throws CouponSystemException;

	List<Customer> getAllCustomer() throws CouponSystemException;

	boolean isEmailCustomerExists(String email) throws CouponSystemException;
	
	boolean isCustomerIdChanged(int customerId) throws CouponSystemException;
	
	List<Coupon> getAllCouponOfCustomer(int customerId) throws CouponSystemException;

}
