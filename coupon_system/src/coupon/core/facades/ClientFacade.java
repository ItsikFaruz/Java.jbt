package coupon.core.facades;

import coupon.core.dao.CompanyDao;
import coupon.core.dao.CompanyDaoDb;
import coupon.core.dao.CouponDao;
import coupon.core.dao.CouponDaoDb;
import coupon.core.dao.CustomerDao;
import coupon.core.dao.CustomerDaoDb;

public abstract class ClientFacade {

	protected CompanyDao companyDao = new CompanyDaoDb();
	protected CustomerDao customerDao = new CustomerDaoDb();
	protected CouponDao couponDao = new CouponDaoDb();
	

	public abstract boolean login (String email , String password);
		
	
		
}	