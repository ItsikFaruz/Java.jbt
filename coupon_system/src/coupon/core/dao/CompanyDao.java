package coupon.core.dao;

import java.util.ArrayList;

import coupon.core.beans.Company;
import coupon.core.exception.CouponSystemException;

public interface CompanyDao {

	boolean isCompanyExist(String email, String password) throws CouponSystemException;

	int addCompany(Company company) throws CouponSystemException;

	void updateCompany(Company company) throws CouponSystemException;

	void deleteCompany(int companyID) throws CouponSystemException;

	ArrayList<Company> getAllCompanies();

	Company getOneCompany(int companyID);

}
