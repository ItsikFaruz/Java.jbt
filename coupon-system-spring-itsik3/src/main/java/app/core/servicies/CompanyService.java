package app.core.servicies;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.exception.CouponSystemException;

@Service
@Transactional
public class CompanyService extends ClientService {

	
	
	@Override
	public boolean login(String email, String password) {
		if (customerRepo.existsByEmailAndPassword(email, password)) 
			return true;
		else 
			return false;
	}
	
	public int addCoupon (Coupon coupon) throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(coupon.getCompany().getId());
		if (opt.isPresent()) {	
			Company company = companyRepo.save(coupon.getCompany());
			company.addCoupon(coupon);
			return coupon.getId();
		}else {
			throw new CouponSystemException("addCoupon faild - company: " + coupon.getCompany().getId() + " id is not exist");
		}
		
	}
	public Company getCompany (int companyId ) throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(companyId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CouponSystemException("add coupon faild - company not exist.");
		}
	
	}
}