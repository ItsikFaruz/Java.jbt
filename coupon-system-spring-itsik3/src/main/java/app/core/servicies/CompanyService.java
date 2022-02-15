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

	private int companyId = 2;

	public int getId() {
		return companyId;
	}

	public void setId(int id) {
		this.companyId = id;
	}

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

	public int addCoupon(Coupon coupon) throws CouponSystemException {

		Company company = null;
		Optional<Company> opt = companyRepo.findById(coupon.getCompany().getId());
		if (opt.isPresent()) {
			company = opt.get();
		} else {
			throw new CouponSystemException(
					"addCoupon faild - company: " + coupon.getCompany().getId() + " id is not exist");
		}
		
		if (couponRepo.existsByTitleAndCompanyId(coupon.getTitle(), companyId)) {
			throw new CouponSystemException("addCoupon faild - coupon: " + coupon.getTitle() + " is alredy exists  ");
		}
		
		
		if (company.getId() == companyId) {
			company.addCoupon(coupon);
			Coupon couponFromDb = couponRepo.findByTitleAndCompanyId(coupon.getTitle(), companyId);
			return couponFromDb.getId(); 
			
		} else {
			throw new CouponSystemException(
					"addCoupon faild - company id in coupon: " + coupon.getCompany().getId() + " and company id  login not mutch");
		}
	}

	public void updatCoupon(Coupon coupon) throws CouponSystemException {
		if (couponRepo.existsByIdAndCompanyId(coupon.getId(), companyId) && coupon.getCompany().getId() ==companyId) {
			couponRepo.save(coupon);

		} else
			throw new CouponSystemException(" updatCoupon faild - can not change coupon and id company id ");
	}

	public void deleteCoupon(int couponId) throws CouponSystemException {
		if (couponRepo.existsByIdAndCompanyId(couponId, companyId)) {
			couponRepo.deleteById(couponId);

		} else
			throw new CouponSystemException(" deleteCoupon faild - coupon " + couponId + "not exists ");
	}

	public Company getCompany(int companyId) throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(companyId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CouponSystemException("add coupon faild - company not exist.");
		}
	}

	public List<Coupon> getAllCompanyCoupon() {
		return couponRepo.findByCompanyId(this.companyId);
	}

	public List<Coupon> getAllCompanyCouponByCategory(Category category) {
		return couponRepo.findByCompanyIdAndCategory(this.companyId, category);
	}

	public List<Coupon> getAllCompanyCouponUpToMaxPrice(double maxPrice) {
		return couponRepo.findByCompanyIdAndPriceLessThan(this.companyId, maxPrice);
	}

	public Company getCompanyDetials() throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(this.companyId);
		if (opt.isPresent())
			return opt.get();
		else
			throw new CouponSystemException("getCompanyDetials faild - company- " + companyId + " not exist.");
	}

}