package coupon.core.facades;

import coupon.core.beans.Coupon;
import coupon.core.exception.CouponSystemException;

public class CustomerFacade extends ClientFacade {

	private String email;
	private String password;

	public CustomerFacade() {

	}

	public CustomerFacade(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public boolean login(String email, String password) throws CouponSystemException {

		if (!this.customerDao.isCustomerExists(this.getEmail(), this.getPassword())) {
			throw new CouponSystemException("wrong password or email");
		}
		return true;
	}

	
	public void purchaseCoupon (Coupon coupon) throws CouponSystemException {
		
		if (!login(this.getEmail(), this.getPassword())) {
			throw new CouponSystemException("ERROR: The user is not recognized ");
		}
		
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
