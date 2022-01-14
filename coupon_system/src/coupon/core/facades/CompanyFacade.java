package coupon.core.facades;

import coupon.core.beans.Coupon;
import coupon.core.exception.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	@Override
	public boolean login(String email, String password) throws CouponSystemException {

		if (!this.companyDao.isCompanyExist(email, password)) {
			throw new CouponSystemException("wrong password or email");
		}
		return true;
	}

	public void addCoupon(Coupon coupon) throws CouponSystemException {

		if (this.couponDao.checkDuplicateTitle(coupon.getCompanyId(), coupon.getTitle())) {
			throw new CouponSystemException("ERROR: company: "+coupon.getCompanyId() +" allready has a coupon title: " + coupon.getTitle());
		}
		this.couponDao.addCoupon(coupon);
	}

}
