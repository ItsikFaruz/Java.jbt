package coupon.core.facades;

import java.util.ArrayList;

import coupon.core.beans.Company;
import coupon.core.beans.Customer;
import coupon.core.exception.CouponSystemException;

public class AdminFacade extends ClientFacade {

	private final String emailSystem = "admin@admin.com";
	private final String passwordSystem = "admin";
	private String email;
	private String password;
	
	
	
	
	
	
	public AdminFacade(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public boolean login(String email, String password) {
		email=this.email;
		password=this.password;
		return email.equals(this.emailSystem) && password.equals(this.passwordSystem);

	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * add company to database only if name or email company not exist
	 * 
	 * @param company
	 * @return the id of the company
	 * @throws CouponSystemException
	 */
	public int addCompany(Company company) throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");
		
		
		if (this.companyDao.isCompanyExistByNameOrEmail(company.getName(), company.getEmail())) {
			throw new CouponSystemException("addCompany failed - name or email alredy exist");
		}
		return this.companyDao.addCompany(company);
	}

	/**
	 * update company - (can`t change the id or name company).
	 * 
	 * @param company
	 * @throws CouponSystemException
	 */
	public void updateCompany(Company company) throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");
		
		if (!this.companyDao.checkIfIdOrNameExist(company.getId(), company.getName())) {
			throw new CouponSystemException("updateCompany failed - id and name dons`t match or dons`t exist");
		}
		this.companyDao.updateCompany(company);
	}

	/**
	 * delete company and all her coupons and coupon purchase
	 * 
	 * @param coumpanyId
	 * @throws CouponSystemException
	 */
	public void deleteCompanyAndPurchase(int coumpanyId) throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");
		
		this.companyDao.deleteCompanyCouponPurchase(coumpanyId);
		this.couponDao.deleteAllCompanyCoupons(coumpanyId);
		this.companyDao.deleteCompany(coumpanyId);

	}

	/**
	 * get all companies from database
	 * 
	 * @return ArrayList of all companies
	 * @throws CouponSystemException
	 */
	public ArrayList<Company> getAllCompanies() throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");
		
		return (ArrayList<Company>) this.companyDao.getAllCompanies();

	}

	/**
	 * get company ID and return the Company
	 * 
	 * @param companyId
	 * @return Company
	 * @throws CouponSystemException
	 */
	public Company getOneCompany(int companyId) throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");

		return this.companyDao.getOneCompany(companyId);
	}

	/**
	 * adding customer to database and return the ID only if email not exist
	 * 
	 * @param customer
	 * @return customer ID
	 * @throws CouponSystemException
	 */
	public int addCustomer(Customer customer) throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");

		if (this.customerDao.isEmailCustomerExists(customer.getEmail())) {
			throw new CouponSystemException("addCustomer failed - customer email allready exist ");
		}
		int id = this.customerDao.addCustomer(customer);
		return id;

	}

	/**
	 * update customer details ( id can`t change )
	 * @param customer
	 * @throws CouponSystemException
	 */
	public void updateCustomer(Customer customer) throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");
		
		if (!this.customerDao.isCustomerIdChanged(customer.getId())) {
			throw new CouponSystemException("updateCustomer failed - The customer ID cannot be changed ");
		}
		this.customerDao.updateCustomer(customer);
	}
	
	/**
	 * deletes a customer and all his purchases
	 * @param customerId
	 * @throws CouponSystemException
	 */
	public void deleteCustomer (int customerId) throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");
		
		this.couponDao.deleteAllCouponPurchaseOfCustomer(customerId);
		this.customerDao.deleteCustomer(customerId);
		
	}
	
	/**
	 * @return array list of all customer
	 * @throws CouponSystemException
	 */
	public ArrayList<Customer> getAllCustomers () throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");
		
		return (ArrayList<Customer>) this.customerDao.getAllCustomer();
		
	}
	
	public Customer getOneCustomer (int customerId) throws CouponSystemException {
		if(!this.login(this.email, this.password))
			throw new CouponSystemException("login Administor faild: wrong password or email");
		
		return this.customerDao.getOneCustomer(customerId);
	}
	
	
	
	
}