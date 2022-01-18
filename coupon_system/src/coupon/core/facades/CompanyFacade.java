package coupon.core.facades;

import java.util.ArrayList;

import coupon.core.beans.Company;
import coupon.core.beans.Coupon;
import coupon.core.beans.Coupon.Category;
import coupon.core.exception.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	private String email;
	private String password;

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

	public CompanyFacade() {
	}

	public CompanyFacade(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {

		if (!this.companyDao.isCompanyExist(email, password)) {
			throw new CouponSystemException("wrong password or email");
		}
		return true;
	}

	/**
	 * adds new coupon only in is not exist 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void addCoupon(Coupon coupon) throws CouponSystemException {

		if (this.couponDao.checkDuplicateTitle(coupon.getCompanyId(), coupon.getTitle())) {
			throw new CouponSystemException(
					"ERROR: company: " + coupon.getCompanyId() + " allready has a coupon title: " + coupon.getTitle());
		}
		this.couponDao.addCoupon(coupon);
	}

	/**
	 * update coupon without changes coupon id or company id
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void updateCoupon(Coupon coupon) throws CouponSystemException {

		if (!this.couponDao.checkIfIdOrCompanyIdExist(coupon.getId(), coupon.getCompanyId())) {
			throw new CouponSystemException(
					"updateCoupon faild - coupon id or company id dons`t match or dons`t exist");
		}
		this.couponDao.updateCoupon(coupon);

	}

	public void deleteCoupon(int couponId) throws CouponSystemException {

		this.couponDao.deleteCouponPurchases(couponId);
		this.couponDao.deleteCoupon(couponId);
	}

	public ArrayList<Coupon> getCompanyCoupon() throws CouponSystemException {
		
		int companyId = this.companyDao.getCompanyId(this.getEmail(), this.password);
		return (ArrayList<Coupon>) this.couponDao.getAllCouponOfCompany(companyId);

	}

	public ArrayList<Coupon> getCompanyCouponsByCategory(Category category) throws CouponSystemException {
		
		
		int companyId = this.companyDao.getCompanyId(this.getEmail(), this.password);
		return (ArrayList<Coupon>) this.couponDao.getAllCouponOfCompany(companyId , category);
	}
	
	public ArrayList<Coupon> getCompanyCoupons(Double maxPrice) throws CouponSystemException {
		
		
		int companyId = this.companyDao.getCompanyId(this.getEmail(), this.password);
		return (ArrayList<Coupon>) this.couponDao.getAllCouponOfCompanyUpTOMax(companyId , maxPrice);
	}
	
	public Company getCompanyDetails() throws CouponSystemException {
		int comanyId = this.companyDao.getCompanyId(this.getEmail(), this.password);
		return this.companyDao.getOneCompany(comanyId);
		
	}
	
	
}
