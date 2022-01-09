package coupon.core.dao;

import java.util.List;

import coupon.core.beans.Company;
import coupon.core.exception.CouponSystemException;

public interface CompanyDao {

	boolean isCompanyExist(String email, String password) throws CouponSystemException;

	int addCompany(Company company) throws CouponSystemException;

	
	
	
	void updateCompany(Company company) throws CouponSystemException;

	void deleteCompany(int companyID) throws CouponSystemException;

	List<Company> getAllCompanies()throws CouponSystemException;;

	
	
	
	Company getOneCompany(int companyID)throws CouponSystemException;;

}
