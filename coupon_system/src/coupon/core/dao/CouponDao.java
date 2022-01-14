package coupon.core.dao;

import java.util.List;

import coupon.core.beans.Coupon;
import coupon.core.exception.CouponSystemException;

public interface CouponDao {

	int addCoupon(Coupon coupon) throws CouponSystemException;

	void updateCoupon(Coupon coupon) throws CouponSystemException;

	void deleteCoupon(int couponId) throws CouponSystemException;

	List<Coupon> getAllCoupon() throws CouponSystemException;

	Coupon getOneCoupon(int couponId) throws CouponSystemException;

	void addCouponPurchase(int customerId, int couponId) throws CouponSystemException;

	void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException;

	void deleteAllCompanyCoupons(int companyId) throws CouponSystemException ;
	
	void deleteAllCouponPurchaseOfCustomer(int customerId ) throws CouponSystemException;
}
