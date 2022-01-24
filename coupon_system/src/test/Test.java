package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import coupon.core.CouponExpiratinDailyJob;
import coupon.core.beans.Company;
import coupon.core.beans.Coupon;
import coupon.core.beans.Coupon.Category;
import coupon.core.beans.Customer;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;
import coupon.core.facades.CompanyFacade;
import coupon.core.facades.CustomerFacade;
import logInManager.core.LoginManager;
import logInManager.core.clients.ClientType;

public class Test {

	private CouponExpiratinDailyJob job = new CouponExpiratinDailyJob();

	public void testAll() {
		System.out.println("start test");
		try {
			startSystem();
			// the test ====================================================================
//			doAdminTest();
//			doCompanyTest();
			doCustomerTest();
			// =============================================================================
		} catch (CouponSystemException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("\nsystem shutdown in 5 seconds");
			try {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				stopSystem();
			} catch (CouponSystemException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of test");
	}

	private void doAdminTest() throws CouponSystemException {
		System.out.println("================ ADMIN TEST ==============");
		AdminFacade af = (AdminFacade) LoginManager.getInstance().logIn("admin@admin.com", "admin",
				ClientType.ADMINISTRATOR);
		if (af != null) {
			System.out.println("admin logged in successfully");
		} else {
			System.out.println("admin login failed");
		}
		System.out.println("-----------------------------------------------------------");
		// ==================add company==============================
		Company company1 = new Company(0, "aaa", "aaa", "aaa");
		Company company2 = new Company(0, "bbb", "bbb", "bbb");
		Company company3 = new Company(0, "ccc", "ccc", "ccc");
		af.addCompany(company1);
		System.out.println("added " + company1 );
		af.addCompany(company2);
		System.out.println("added " + company2);
		af.addCompany(company3);
		System.out.println("added " + company3);
		System.out.println("-----------------------------------------------------------");
		// ==================update company===========================
		company1.setEmail("@@@");
		af.updateCompany(company1);
		System.out.println("updated company: " + company1.getId() + " to: " + company1);
		System.out.println("-----------------------------------------------------------");
		// ==================delete company===========================
		af.deleteCompanyAndPurchase(company1.getId());
		System.out.println("deleted company: " + company1.getId());
		System.out.println("-----------------------------------------------------------");
		// ==================get all company==========================
		System.out.println("All Compnies: ");
		List<Company> allcompnies = new ArrayList<>();
		allcompnies = af.getAllCompanies();
		for (Company company : allcompnies) {
			System.out.println(company);
		}
		System.out.println("-----------------------------------------------------------");
		// ==================get one company==========================
		System.out.print("got one company : ");
		System.out.println(af.getOneCompany(company2.getId()));
		System.out.println("-----------------------------------------------------------");
		// ===================add customers===========================
		Customer customer1 = new Customer(0, "aa", "aa", "aa", "aa");
		Customer customer2 = new Customer(0, "bb", "bb", "bb", "bb");
		Customer customer3 = new Customer(0, "cc", "cc", "cc", "cc");
		af.addCustomer(customer1);
		System.out.println("added " + customer1);
		af.addCustomer(customer2);
		System.out.println("added " + customer2);
		af.addCustomer(customer3);
		System.out.println("added " + customer3);
		System.out.println("-----------------------------------------------------------");
		// ====================update customer=========================
		customer1.setEmail("@@");
		customer1.setFirstName("dd");
		af.updateCustomer(customer1);
		System.out.println("updated Customer: " + customer1.getId() + " to " + customer1);
		System.out.println("-----------------------------------------------------------");
		// ====================delete customer=========================
		af.deleteCustomer(customer1.getId());
		System.out.println("deleted Customer: id = " + customer1.getId());
		System.out.println("-----------------------------------------------------------");
		// ====================get all customer========================
		System.out.println("List of all customers below: ");
		List<Customer> allCustomers = new ArrayList<>();
		allCustomers = af.getAllCustomers();
		for (Customer customer : allCustomers) {
			System.out.println(customer);
		}
		System.out.println("-----------------------------------------------------------");
		// ====================got one customer========================
		System.out.print("got one customer : ");
		System.out.println(af.getOneCustomer(customer2.getId()));
		System.out.println("-----------------------------------------------------------");
	}

	
	
	private void doCompanyTest() throws CouponSystemException {
		System.out.println("====================== COMPANY TEST =======================");
		CompanyFacade company = (CompanyFacade) LoginManager.getInstance().logIn("bbb", "bbb", ClientType.COMPANY);
		if (company != null) {
			System.out.println("company logged in successfully");
		} else {
			System.out.println("company login failed");
		}
		System.out.println("-----------------------------------------------------------");
		// ==================add coupon==============================
		Coupon coupon1 = new Coupon(0, 95, Coupon.Category.FOOD, "aaaa", "aaaa", LocalDate.of(2010, 12, 11),
				LocalDate.of(2025, 10, 15), 10, 10, "aaaa");
		Coupon coupon2 = new Coupon(0, 95, Coupon.Category.TRAVEL, "bbbb", "bbbb", LocalDate.of(2010, 12, 11),
				LocalDate.of(2022, 10, 15), 10, 10, "cccc");
		Coupon coupon3 = new Coupon(0, 96, Coupon.Category.VACATION, "cccc", "cccc", LocalDate.of(2010, 12, 11),
				LocalDate.of(2022, 10, 15), 10, 10, "cccc");
		company.addCoupon(coupon1);
		System.out.println("added " + coupon1);
		company.addCoupon(coupon2);
		System.out.println("added " + coupon2);
		company.addCoupon(coupon3);
		System.out.println("added " + coupon3);
		System.out.println("-----------------------------------------------------------");
		// ==================update coupon============================
		coupon1.setTitle("@@@@");
		coupon1.setImage("@@@@");
		coupon1.setDescription("@@@@");
		company.updateCoupon(coupon1);
		System.out.println("updated Coupon: " + coupon1.getId() + " to " + coupon1);
		System.out.println("-----------------------------------------------------------");
		// ==================delete company===========================
		company.deleteCoupon(coupon1.getId());
		System.out.println("deleted Coupon: " + coupon1.getId());
		System.out.println("-----------------------------------------------------------");
		// ==================company coupons==========================
		System.out.println("All company coupons: ");
		List<Coupon> allCoupon = new ArrayList<>();
		allCoupon = company.getCompanyCoupon();
		for (Coupon coupon : allCoupon) {
			System.out.println(coupon);
		}
		System.out.println("-----------------------------------------------------------");
		// ==================company coupons by category==============
		System.out.println("All company coupons by specific category:");
		List<Coupon> allCouponByCategory = new ArrayList<>();
		allCouponByCategory = company.getCompanyCouponsByCategory(Category.TRAVEL);
		for (Coupon coupon : allCouponByCategory) {
			System.out.println(coupon);
		}
		System.out.println("-----------------------------------------------------------");
		// =============company coupons by up to a max price===========
		double maxPrice = 20D;
		System.out.println("all company coupons up to: " + maxPrice + " Dollar");
		List<Coupon> allCouponUpToMaxPrice = company.getCompanyCoupons(maxPrice);
		for (Coupon coupon : allCouponUpToMaxPrice) {
			System.out.println(coupon);
		}
		System.out.println("-----------------------------------------------------------");
		// ========================Company Details=====================
		System.out.println("Company Details:");
		System.out.println(company.getCompanyDetails());
	}

	
	
	
	private void doCustomerTest() throws CouponSystemException {
		System.out.println("====================== CUSTOMER TEST =======================");
		CustomerFacade customer = (CustomerFacade) LoginManager.getInstance().logIn("bb", "bb", ClientType.CUSTOMER);
		if (customer != null) {
			System.out.println("customer logged in successfully");
		} else {
			System.out.println("customer login failed");
		}
		System.out.println("-----------------------------------------------------------");
		Coupon coupon2 = new Coupon(135, 89, Coupon.Category.TRAVEL, "bbbb", "bbbb", LocalDate.of(2010, 12, 11),
				LocalDate.of(2022, 10, 15), 10, 10, "cccc");
		Coupon coupon3 = new Coupon(136, 90, Coupon.Category.VACATION, "cccc", "cccc", LocalDate.of(2010, 12, 11),
				LocalDate.of(2020, 10, 15), 10, 10, "cccc");
		customer.purchaseCoupon(coupon2);
		System.out.println("customer: " + customer.getId() + " purchased " + coupon2 );
		customer.purchaseCoupon(coupon3);
		System.out.println("customer: " + customer.getId() + " purchased " + coupon3 );
		System.out.println("-----------------------------------------------------------");
		
		
		

	}

	private void startSystem() throws CouponSystemException {
		ConnectionPool.getInstance();
		job.startDailyJob();
	}

	private void stopSystem() throws CouponSystemException {
		job.stopDailyJob();
		try {
			job.getThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ConnectionPool.getInstance().closeAllConnections();
	}

}
