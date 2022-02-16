package coupon.core.facades;

import java.util.ArrayList;

import coupon.core.beans.Coupon;
import coupon.core.beans.Coupon.Category;
import coupon.core.beans.Customer;
import coupon.core.exception.CouponSystemException;

public class CustomerFacade extends ClientFacade {

	private String email;
	private String password;
	private int id;

	public CustomerFacade() {
	}

	public int getId() {
		return id;
	}

	private void setId(String email, String password) throws CouponSystemException {
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
	 * log in: Checks if password and email are correct. return true or false if
	 * true, also set id to customer
	 * 
	 * @param email
	 * @param password
	 * @return true or false
	 */
	@Override
	public boolean login(String email, String password) throws CouponSystemException {

		if (!this.customerDao.isCustomerExists(email, password)) {
			return false;
		}
		this.setId(email, password);
		return true;
	}

	
	
	/**
	 * purchase coupon from data base, also checks: 
	 * if coupon exists,
	 * if coupon already purchased,
	 * if coupon available, 
	 * if the coupon is valid.
	 * @param couponId
	 * @throws CouponSystemException
	 */
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {

		if (!couponDao.checkCouponExist(coupon)) {
			throw new CouponSystemException("ERROR: the coupon not exist in the system ");
		}

		if (this.customerDao.checkCouponPurchased(this.id, coupon)) {
			throw new CouponSystemException(
					"the coupon: " + coupon.getId() + " has already been purchased, can`t buy again");
		}

		if (!this.couponDao.checkAvailable(coupon)) {
			throw new CouponSystemException("ERROR: No coupons left available ");
		}

		if (couponDao.checkIfDateExpierd(coupon)) {
			throw new CouponSystemException("ERROR: The coupon has expired ");
		}

		this.couponDao.addCouponPurchase(this.id, coupon.getId());
		couponDao.SubtractsFromAmount(coupon);
	}

	/**
	 * @return All specific customer coupons by id
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCustomerCoupons() throws CouponSystemException {
		return (ArrayList<Coupon>) customerDao.getAllCouponOfCustomer(this.id);
	}

	/**
	 * @param category
	 * @return All coupons from a specific category of specific customer by id
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		return (ArrayList<Coupon>) customerDao.getAllCouponOfCustomer(this.id, category);
	}

	/**
	 * @param maxPrice
	 * @return All specific coupons of a specific customer by id, up to the maximum
	 *         price
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		return (ArrayList<Coupon>) customerDao.getAllCouponOfCustomerBelwoMaxPrice(this.id, maxPrice);
	}

	/**
	 * @return customer details
	 * @throws CouponSystemException
	 */
	public Customer getCustomerDetails() throws CouponSystemException {
		return customerDao.getOneCustomer(this.id);

	}

}
