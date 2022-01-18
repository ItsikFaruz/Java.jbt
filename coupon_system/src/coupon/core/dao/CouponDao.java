package coupon.core.dao;

import java.util.List;

import coupon.core.beans.Coupon;
import coupon.core.beans.Coupon.Category;
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
	
	boolean checkDuplicateTitle(int companyId , String couponTitle) throws CouponSystemException;
	
	boolean checkIfIdOrCompanyIdExist (int couponId , int companyId) throws CouponSystemException; 
	
	void deleteCouponPurchases(int couponId ) throws CouponSystemException ;
	
	List<Coupon> getAllCouponOfCompany( int companyId) throws CouponSystemException;
	
	List<Coupon> getAllCouponOfCompany(int companyId ,Category category) throws CouponSystemException; 
	
    List<Coupon> getAllCouponOfCompanyUpTOMax(int companyId ,Double maxPrice) throws CouponSystemException;
    
    void SubtractsFromAmount (Coupon coupon) throws CouponSystemException;
    
    boolean checkCouponExist(Coupon coupon) throws CouponSystemException;
    
    boolean checkAvailable(Coupon coupon) throws CouponSystemException;
    
    boolean checkIfDateExpierd(Coupon coupon) throws CouponSystemException;
}
