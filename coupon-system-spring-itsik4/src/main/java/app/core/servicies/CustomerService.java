package app.core.servicies;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.core.entities.Coupon;
import app.core.entities.Coupon.Category;
import app.core.entities.Customer;
import app.core.exception.CouponSystemException;

@Service
@Transactional
@Scope("prototype")
public class CustomerService extends ClientService {

	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	/**
	 * log in: Checks if password and email are correct
	 * and also set id to customer
	 * 
	 * @param email
	 * @param password
	 * @return true or false
	 */

	@Override
	public boolean login(String email, String password) {
		if (customerRepo.existsByEmailAndPassword(email, password)) {
			Customer customer = customerRepo.findCustomerByEmailAndPassword(email, password);
			this.customerId = customer.getId();
			return true;
		} else {
			return false;
		}
	}

	
	
	/**
	 * purchase coupon 
	 * if coupon exists,
	 * if coupon already purchased,
	 * if coupon available, 
	 * if the coupon is valid.
	 * @param Coupon
	 * @throws CouponSystemException
	 */
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		if (customerId == 0) {
			throw new CouponSystemException("purchaseCoupon failed - need to login first");
		}

		Customer customer = customerRepo.getById(customerId);
		Optional<Coupon> opt = couponRepo.findById(coupon.getId());

		if (opt.isPresent()) {
			Coupon couponFromDb = couponRepo.getById(coupon.getId());
			if (customer.getCoupons().contains(couponFromDb)) {
				throw new CouponSystemException("purchaseCoupon failed - ccoupon " + coupon.getId() + " alredy exsits");
			}
			if (couponFromDb.getAmount() < 1) {
				throw new CouponSystemException(
						"purchaseCoupon failed - the coupon " + coupon.getId() + " out of stock");
			}
			if (couponFromDb.getEndDate().isBefore(LocalDate.now())) {
				throw new CouponSystemException(
						"purchaseCoupon failed - the date of coupon " + coupon.getId() + " has passed");
			}
			customer.addCoupon(couponFromDb);
			couponFromDb.setAmount(couponFromDb.getAmount() - 1);
		}
	}

	

	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		Optional<Customer> opt = customerRepo.findById(customerId);
		if (opt.isPresent()) {
			Customer customerFromDb = opt.get();
			return customerFromDb;
		} else {
			throw new CouponSystemException("getOneCustomer failed - this customer not exist");
		}
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
	public void purchaseCouponFromDb(int couponId) throws CouponSystemException {
		if (customerId == 0) {
			throw new CouponSystemException("purchaseCoupon failed - need to login first");
		}

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

	/**
	 * @return All specific customer coupons by customer ID
	 * @throws CouponSystemException
	 */
	public List<Coupon> getAllCoupon (){
	return couponRepo.findByCustomersId(customerId);
	}
	
	/**
	 * @param category
	 * @return All coupons from a specific category of specific customer by customer id
	 * @throws CouponSystemException
	 */
	public List<Coupon> getAllCouponByCategory (Category category){
		return couponRepo.findByCustomersIdAndCategory(customerId , category);
	}
	
	/**
	 * @param maxPrice
	 * @return All specific coupons of a specific customer by customer id, up to the maximum
	 *         price
	 * @throws CouponSystemException
	 */
	public List<Coupon> getAllCouponUpToMaxPrice (double maxPrice){
		return couponRepo.findByCustomersIdAndPriceLessThan(customerId , maxPrice);
	}
	
	/**
	 * @return customer details
	 * @throws CouponSystemException
	 */
	public Customer getCustomerDetails () {
		return customerRepo.findById(customerId).get();
	}
	
}
