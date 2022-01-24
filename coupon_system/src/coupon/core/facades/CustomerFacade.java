package coupon.core.facades;

import java.util.ArrayList;

import coupon.core.beans.Coupon;
import coupon.core.beans.Coupon.Category;
import coupon.core.beans.Customer;
import coupon.core.exception.CouponSystemException;

public class CustomerFacade extends ClientFacade {

	private String email;
	private String password;
	private int id  ;


	public CustomerFacade() {
	}

	public int getId() {
		return id;
	}
	
	private void setId (String email , String password) throws CouponSystemException {
		this.id = this.customerDao.getCustomerId(email, password);
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *
	 *	log in: Checks if password and user are correct.
	 *	return true or false
	 *	if true, also set id to company 
	 *
	 */
	@Override
	public boolean login(String email, String password) throws CouponSystemException {

		if (!this.customerDao.isCustomerExists(email,password)){
			return false;
		}
		this.setId(email, password);
		return true;
	}

	
	public void purchaseCoupon (Coupon coupon) throws CouponSystemException {
		
		
		if (!couponDao.checkCouponExist(coupon)) {
			throw new CouponSystemException("ERROR: the coupon not exist in the system ");
		}
		
		if (this.customerDao.checkCouponPurchased(this.id, coupon)){
			throw new CouponSystemException("the coupon: " + coupon.getId() + " has already been purchased, can`t buy again"); 
		}
	
		if (!this.couponDao.checkAvailable(coupon)){
			throw new CouponSystemException("ERROR: No coupons left available ");
		}
		
			if(!couponDao.checkIfDateExpierd(coupon)) {
				throw new CouponSystemException("ERROR: The coupon has expired ");
		}
			
			this.couponDao.addCouponPurchase(this.id, coupon.getId());
			couponDao.SubtractsFromAmount(coupon);
		}
	
		public ArrayList<Coupon> getCustomerCoupons () throws CouponSystemException {
			return (ArrayList<Coupon>) customerDao.getAllCouponOfCustomer(this.id);
		}
		public ArrayList<Coupon> getCustomerCoupons (Category category) throws CouponSystemException {
			return (ArrayList<Coupon>) customerDao.getAllCouponOfCustomer(this.id, category);
		}
		public ArrayList<Coupon> getCustomerCoupons (double maxPrice) throws CouponSystemException {
			return (ArrayList<Coupon>) customerDao.getAllCouponOfCustomerBelwoMaxPrice(this.id, maxPrice);
		}
		
		public Customer getCustomerDetails () throws CouponSystemException {
			return customerDao.getOneCustomer(this.id);
			
		}
		
		
}
