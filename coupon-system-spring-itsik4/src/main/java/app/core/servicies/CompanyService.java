package app.core.servicies;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Coupon.Category;
import app.core.exception.CouponSystemException;

@Service
@Transactional
@Scope("prototype")
public class CompanyService extends ClientService {

	private int companyId;

	public int getId() {
		return companyId;
	}

	public void setId(int id) {
		this.companyId = id;
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
	public boolean login(String email, String password) {
		if (companyRepo.existsByEmailAndPassword(email, password)) {
			Company company = companyRepo.findCompanyByEmailAndPassword(email, password);
			this.companyId = company.getId();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * adds new coupon only if is not exist
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 * @return The ID number the coupon received in the database 
	 */
	public int addCoupon(Coupon coupon) throws CouponSystemException {
		if (couponRepo.existsByTitleAndCompanyId(coupon.getTitle(), companyId)) {
			throw new CouponSystemException("addCoupon faild - coupon: " + coupon.getTitle() + " is alredy exists  ");
		}
		Company company = null;
		Optional<Company> opt = companyRepo.findById(coupon.getCompany().getId());
		if (opt.isPresent()) {
			company = opt.get();
		} else {
			throw new CouponSystemException(
					"addCoupon faild - company: " + coupon.getCompany().getId() + " id is not exist");
		}
		if (company.getId() == companyId) {
			company.addCoupon(coupon);
			return coupon.getId();
		} else {
			throw new CouponSystemException(
					"addCoupon faild - company id in coupon: " + coupon.getCompany().getId() + " and company id not mutch");
		}
	}

	/**
	 * update coupon without changes coupon id or company id
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void updatCoupon(Coupon coupon) throws CouponSystemException {
		if (couponRepo.existsByIdAndCompanyId(coupon.getId(), companyId)) {
			couponRepo.save(coupon);

		} else
			throw new CouponSystemException(" updatCoupon faild - can not change coupon id company id ");
	}

	/**
	 * Delete coupon and all its purchases
	 * 
	 * @param couponId
	 * @throws CouponSystemException
	 */
	public void deleteCoupon(int couponId) throws CouponSystemException {
		if (couponRepo.existsByIdAndCompanyId(couponId, companyId)) {
			couponRepo.deleteById(couponId);

		} else
			throw new CouponSystemException(" deleteCoupon faild - coupon " + couponId + "not exists ");
	}

	
	/**
	 * @param companyId
	 * @return company from data base
	 * @throws CouponSystemException
	 */
	public Company getCompany(int companyId) throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(companyId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CouponSystemException("add coupon faild - company not exist.");
		}
	}

	/**
	 * @return All company coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getAllCompanyCoupon() {
		return couponRepo.findByCompanyId(this.companyId);
	}

	/**
	 * @param category
	 * @return All company coupons by specific category
	 * @throws CouponSystemException
	 */
	public List<Coupon> getAllCompanyCouponByCategory(Category category) {
		return couponRepo.findByCompanyIdAndCategory(this.companyId, category);
	}

	/**
	 * @param maxPrice
	 * @return All company coupons up to a maximum price
	 * @throws CouponSystemException
	 */
	public List<Coupon> getAllCompanyCouponUpToMaxPrice(double maxPrice) {
		return couponRepo.findByCompanyIdAndPriceLessThan(this.companyId, maxPrice);
	}

	/**
	 * @return company details
	 * @throws CouponSystemException
	 */
	public Company getCompanyDetials() throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(this.companyId);
		if (opt.isPresent())
			return opt.get();
		else
			throw new CouponSystemException("getCompanyDetials faild - company- " + companyId + " not exist.");
	}

}