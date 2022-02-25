package app.core.servicies;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.core.entities.Coupon;
import app.core.entities.Coupon.Category;
import app.core.entities.Customer;
import app.core.exception.CouponSystemException;

@Service
@Transactional

public class CustomerService extends ClientService {


	
	@Override
	public boolean login(String email, String password ,int id) {
		if (customerRepo.existsByEmailAndPasswordAndId(email, password ,id)) {
			return true;
		} else {
			return false;
		}
	}

	
//	public void purchaseCoupon(Coupon coupon , int customerId  ) throws CouponSystemException {
//
//		Customer customer = customerRepo.getById(customerId);
//		Optional<Coupon> opt = couponRepo.findById(coupon.getId());
//
//		if (opt.isPresent()) {
//			Coupon couponFromDb = couponRepo.getById(coupon.getId());
//			if (customer.getCoupons().contains(couponFromDb)) {
//				throw new CouponSystemException("purchaseCoupon failed - ccoupon " + coupon.getId() + " alredy purchased");
//			}
//			if (couponFromDb.getAmount() < 1) {
//				throw new CouponSystemException(
//						"purchaseCoupon failed - the coupon " + coupon.getId() + " out of stock");
//			}
//			if (couponFromDb.getEndDate().isBefore(LocalDate.now())) {
//				throw new CouponSystemException(
//						"purchaseCoupon failed - the date of coupon " + coupon.getId() + " has passed");
//			}
//			customer.addCoupon(couponFromDb);
//			couponFromDb.setAmount(couponFromDb.getAmount() - 1);
//		}
//		else {
//			throw new CouponSystemException(
//					"purchaseCoupon failed -  coupon " + coupon.getId() + "not exists");
//
//		}
//	}

	public void purchaseCouponFromDb(int couponId , int customerId) throws CouponSystemException {
	
		Customer customer = customerRepo.getById(customerId);
		Optional<Coupon> opt = couponRepo.findById(couponId);

		if (opt.isEmpty()) {
			throw new CouponSystemException("purchaseCoupon failed - ccoupon " + couponId + " not exsits");
		}

		Coupon couponFromDb = couponRepo.getById(couponId);

		if (customer.getCoupons().contains(couponFromDb)) {
			throw new CouponSystemException("purchaseCoupon failed - ccoupon " + couponId + " alredy exsits");
		}
		if (couponFromDb.getAmount() < 1) {
			throw new CouponSystemException("purchaseCoupon failed - the coupon " + couponId + " out of stock");
		}
		if (couponFromDb.getEndDate().isBefore(LocalDate.now())) {
			throw new CouponSystemException("purchaseCoupon failed - the date of coupon " + couponId + " has passed");
		}
		customer.addCoupon(couponFromDb);
		couponFromDb.setAmount(couponFromDb.getAmount() - 1);
	}

	public List<Coupon> getAllCoupon (int customerId){
		return couponRepo.findByCustomersId(customerId);
	}
	
	
	public List<Coupon> getAllCouponByCategory (Category category, int customerId){
		return couponRepo.findByCustomersIdAndCategory(customerId , category);
	}
	
	public List<Coupon> getAllCouponUpToMaxPrice (double maxPrice , int customerId){
		return couponRepo.findByCustomersIdAndPriceLessThan(customerId , maxPrice);
	}
	
	public Customer getCustomerDetails (int customerId) {
		return customerRepo.findById(customerId).get();
	}
	
//	public Customer getOneCustomer(int customerId) throws CouponSystemException {
//		Optional<Customer> opt = customerRepo.findById(customerId);
//		if (opt.isPresent()) {
//			Customer customerFromDb = opt.get();
//			return customerFromDb;
//		} else {
//			throw new CouponSystemException("getOneCustomer failed - this customer not exist");
//		}
//	}
}
