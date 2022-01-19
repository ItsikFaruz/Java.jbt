package coupon.core.facades;

import coupon.core.beans.Coupon;
import coupon.core.exception.CouponSystemException;

public class CustomerFacade extends ClientFacade {

	private String email;
	private String password;
	private int id ;

	
	public CustomerFacade(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	private void setId () throws CouponSystemException {
		this.id = this.customerDao.getCustomerId(this.email, this.password);
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

		if (!this.customerDao.isCustomerExists(this.getEmail(), this.getPassword())) {
			throw new CouponSystemException("login faild: wrong password or email");
		}
		this.setId();
		return true;
	}

	
	public void purchaseCoupon (Coupon coupon) throws CouponSystemException {
		
		this.login(this.getEmail(), this.getPassword());
		
		
		if (!couponDao.checkCouponExist(coupon)) {
			throw new CouponSystemException("ERROR: the coupon not exist in the system ");
		}
		
		if (this.customerDao.checkCouponPurchased(this.getEmail(), this.getPassword(), coupon)){
			throw new CouponSystemException("the coupon: " + coupon.getId() + " has already been purchased, can`t buy again"); 
		}
	
		if (!this.couponDao.checkAvailable(coupon)){
			throw new CouponSystemException("ERROR: No coupons left available ");
		}
		
			if(!couponDao.checkIfDateExpierd(coupon)) {
				throw new CouponSystemException("ERROR: The coupon has expired ");
		}
			
			int customeId = this.customerDao.getCustomerId(this.getEmail(),this.getPassword());
			this.couponDao.addCouponPurchase(customeId, coupon.getId());
			couponDao.SubtractsFromAmount(coupon);
	}

	
}
