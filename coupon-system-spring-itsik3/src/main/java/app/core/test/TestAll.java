package app.core.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.entities.Company;
import app.core.entities.Customer;
import app.core.exception.CouponSystemException;
import app.core.loginManager.Clients.ClientType;
import app.core.loginManager.LoginManager;
import app.core.servicies.AdminService;



@Component
public class TestAll {
	
	@Autowired
	LoginManager loginManager;

//==========test==========	
	@PostConstruct
	public void test() throws CouponSystemException {
		System.out.println("post");
		doAdminTest();
//  	doCompanyTest();
//  	doCustomerTest();

	}
	
	//*******************************ADMIN TEST************************************
	public void doAdminTest() throws CouponSystemException {
		
		System.out.println("\n\n\n====================== ADMIN TEST =======================\n");
		AdminService af = (AdminService) loginManager.login("admin@admin.com", "admin",
				ClientType.ADMINISTRATOR);
//		System.out.println(adminService.getAllCompany());
		System.out.println("\n-------------------add company----------------------------");
		// ==================add company==============================
		Company company1 = new Company(0, "aaa", "aaa", "aaa" , null);
		Company company2 = new Company(0, "bbb", "bbb", "bbb" , null);
		Company company3 = new Company(0, "ccc", "ccc", "ccc" , null);
		af.addCompany(company1);
		System.out.println("added " + company1);
		af.addCompany(company2);
		System.out.println("added " + company2);
		af.addCompany(company3);
		System.out.println("added " + company3);
		System.out.println("\n-----------------update company----------------------------");
		// ==================update company===========================
		company1.setEmail("@@@");
		af.updateCompany(company1);
		System.out.println("updated company: " + company1.getId() + " to: " + company1);
		System.out.println("\n------------------delete company---------------------------");
		// ==================delete company===========================
		af.deleteCompany(company1.getId());
		System.out.println("deleted company: " + company1.getId());
		System.out.println("\n--------------getAll Companies-----------------------------");
		// ==================get all company==========================
		System.out.println("All Companies: ");
		List<Company> allcompnies = new ArrayList<>();
		allcompnies = af.getAllCompany();
		for (Company company : allcompnies) {
			System.out.println(company);
		}
		System.out.println("\n-------------------get one company-------------------------");
		// ==================get one company==========================
		System.out.print("got one company : ");
		System.out.println(af.getOneCompany(company2.getId()));
		System.out.println("\n---------------------add customers-------------------------");
		// ===================add customers===========================
		Customer customer1 = new Customer(0, "aaaa", "aaaa", "aaaa", "aaaa", null);
   		Customer customer2 = new Customer(0, "bbbb", "bbbb", "bbbb", "bbbb", null);
   		Customer customer3 = new Customer(0, "cccc", "cccc", "cccc", "cccc", null);
		af.addCustomer(customer1);
		System.out.println("added " + customer1);
		af.addCustomer(customer2);
		System.out.println("added " + customer2);
		af.addCustomer(customer3);
		System.out.println("added " + customer3);
		System.out.println("\n-------------------update customer-------------------------");
		// ====================update customer=========================
		customer1.setEmail("@@");
		customer1.setFirstName("dd");
		af.updateCustomer(customer1);
		System.out.println("updated Customer: " + customer1.getId() + " to " + customer1);
		System.out.println("\n--------------------delete customer------------------------");
		// ====================delete customer=========================
		af.deleteCustomer(customer1.getId());
		System.out.println("deleted Customer: id = " + customer1.getId());
		System.out.println("\n------------------get all customer-------------------------");
		// ====================get all customer========================
		System.out.println("List of all customers below: ");
		List<Customer> allCustomers = new ArrayList<>();
		allCustomers = af.getAllCustomer();
		for (Customer customer : allCustomers) {
			System.out.println(customer);
		}
		System.out.println("\n-----------------get one customer--------------------------");
		// ====================get one customer========================
		System.out.print("get one customer : ");
		System.out.println(af.getOneCustomer(customer2.getId()));
		System.out.println("\n-----------------------------------------------------------");
	}



   				
		
		
		
	

	
	
	
	
	
	
	
	
	public void doCompanyTest() {

	}

	
	
	
	public void doCustomerTest() {

	}

}
