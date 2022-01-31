package coupon.core.facades;

import java.util.ArrayList;

import coupon.core.beans.Company;
import coupon.core.beans.Coupon;
import coupon.core.beans.Coupon.Category;
import coupon.core.exception.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	private String email;
	private String password;
	private int id;

	public CompanyFacade() {
	}

	public CompanyFacade(String email, String password) {
		this.email = email;
		this.password = password;

	}

	public int getId() {
		return id;
	}

	/**
	 * the method Enter the number id by email and password
	 * 
	 * @param email
	 * @param password
	 * @throws CouponSystemException
	 */
	private void setId(String email, String password) throws CouponSystemException {

		this.id = (this.companyDao.getCompanyId(email, password));

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
	 * true, also set id to company
	 * 
	 * @param email
	 * @param password
	 * @return true or false
	 */
	@Override
	public boolean login(String email, String password) throws CouponSystemException {

		if (!this.companyDao.isCompanyExist(email, password)) {
			return false;

		}

		this.setId(email, password);
		return true;
	}

	/**
	 * adds new coupon only in is not exist
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void addCoupon(Coupon coupon) throws CouponSystemException {

		if (this.couponDao.checkDuplicateTitle(this.id, coupon.getTitle())) {
			throw new CouponSystemException(
					"ERROR: company: " + coupon.getCompanyId() + " allready has a coupon title: " + coupon.getTitle());
		}
		couponDao.addCoupon(coupon);
	}

	/**
	 * update coupon without changes coupon id or company id
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void updateCoupon(Coupon coupon) throws CouponSystemException {

		if (!this.couponDao.checkIfIdAndCompanyIdExist(coupon.getId(), coupon.getCompanyId())) {
			throw new CouponSystemException(
					"updateCoupon faild - It is not possible to change a companyId or CouponId");
		}
		this.couponDao.updateCoupon(coupon);

	}

	/**
	 * Delete coupon and all its purchases
	 * 
	 * @param couponId
	 * @throws CouponSystemException
	 */
	public void deleteCoupon(int couponId) throws CouponSystemException {

		this.couponDao.deleteCouponPurchases(couponId);
		this.couponDao.deleteCoupon(couponId);
	}

	/**
	 * @return All company coupons
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCompanyCoupon() throws CouponSystemException {

		return (ArrayList<Coupon>) this.couponDao.getAllCouponOfCompany(this.id);

	}

	/**
	 * @param category
	 * @return All company coupons by specific category
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCompanyCouponsByCategory(Category category) throws CouponSystemException {

		return (ArrayList<Coupon>) this.couponDao.getAllCouponOfCompany(this.id, category);
	}

	/**
	 * @param maxPrice
	 * @return All company coupons up to a maximum price
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCompanyCoupons(Double maxPrice) throws CouponSystemException {

		return (ArrayList<Coupon>) this.couponDao.getAllCouponOfCompanyUpTOMax(this.id, maxPrice);
	}

	/**
	 * @return company details
	 * @throws CouponSystemException
	 */
	public Company getCompanyDetails() throws CouponSystemException {

		return this.companyDao.getOneCompany(this.id);

	}

}
