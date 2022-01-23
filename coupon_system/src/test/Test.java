package test;

import java.util.ArrayList;
import java.util.List;

import coupon.core.CouponExpiratinDailyJob;
import coupon.core.beans.Company;
import coupon.core.beans.Customer;
import coupon.core.dao.ConnectionPool;
import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;
import logInManager.core.LoginManager;
import logInManager.core.clients.ClientType;

public class Test {

	private CouponExpiratinDailyJob job = new CouponExpiratinDailyJob();

	public void testAll() {
		System.out.println("start test");
		try {
			startSystem();
			// the test ====================================================================
			doAdminTest();
//			doCompanyTest();
//			doCustomerTest();
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
		System.out.println("================ ADMIN TEST");
		AdminFacade af = (AdminFacade) LoginManager.getInstance().logIn("admin@admin.com", "admin",
				ClientType.ADMINISTRATOR);
		if (af != null) {
			System.out.println("admin logged in successfully");
		} else {
			System.out.println("admin login failed");
		}
		// ================add company=============================
		Company company1 = new Company(0, "aaa", "aaa", "aaa");
		Company company2 = new Company(0, "bbb", "bbb", "bbb");
		Company company3 = new Company(0, "ccc", "ccc", "ccc");
		af.addCompany(company1);
		af.addCompany(company2);
		af.addCompany(company3);
		System.out.println(company1 + " has been added");
		System.out.println(company2 + " has been added");
		System.out.println(company3 + " has been added");
		// ==================update company==========================
		company1.setEmail("@@@");
		af.updateCompany(company1);
		System.out.println("Company: id = " + company1.getId() + " has been updated to " + company1);
		// ==================delete company==========================
		af.deleteCompanyAndPurchase(company1.getId());
		System.out.println("Company: id = " + company1.getId() + " has been deleted");
		// ==================get all company==========================
		System.out.println("List of all companies below: ");
		List<Company> allcompnies = new ArrayList<>();
		allcompnies = af.getAllCompanies();
		for (Company company : allcompnies) {
			System.out.println(company);
		}
		System.out.println("-----------------------------------------------------------");
		// ==================get one company==========================
		System.out.print("got one company : ");
		System.out.println(af.getOneCompany(company2.getId()));
		// ===================add customers==========================
		Customer customer1 = new Customer(0, "aa", "aa", "aa", "aa");
		Customer customer2 = new Customer(0, "bb", "bb", "bb", "bb");
		Customer customer3 = new Customer(0, "cc", "cc", "cc", "cc");
		af.addCustomer(customer1);
		af.addCustomer(customer2);
		af.addCustomer(customer3);
		System.out.println(customer1 + "has been added");
		System.out.println(customer2 + "has been added");
		System.out.println(customer3 + "has been added");
		System.out.println("-----------------------------------------------------------");
		// ====================update customer==========================
		customer1.setEmail("@@");
		customer1.setFirstName("dd");
		af.updateCustomer(customer1);
		System.out.println("Customer: id = " + customer1.getId() + " has been updated to " + customer1);
		// ====================delete customer==========================
		af.deleteCustomer(customer1.getId());
		System.out.println("Customer: id = " + customer1.getId() + " has been deleted");
		// ====================get all customer==========================
		System.out.println("List of all customers below: ");
		List<Customer> allCustomers = new ArrayList<>();
		allCustomers = af.getAllCustomers();
		for (Customer customer : allCustomers) {
			System.out.println(customer);
		}

	}

	private void doCompanyTest() {
		// TODO Auto-generated method stub

	}

	private void doCustomerTest() {
		// TODO Auto-generated method stub

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
