package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import app.core.entities.Coupon;
import app.core.entities.Coupon.Category;
import app.core.entities.Customer;
import app.core.exception.CouponSystemException;
import app.core.loginManager.Clients.ClientType;
import app.core.loginManager.LoginManager;
import app.core.servicies.AdminService;
import app.core.servicies.CompanyService;
import app.core.test.TestAll;

@EnableScheduling
@SpringBootApplication
public class CouponSystemSpringItsikApplication {

	public static void main(String[] args) throws CouponSystemException {
       ApplicationContext ctx =  SpringApplication.run(CouponSystemSpringItsikApplication.class, args);
       AdminService adminService = ctx.getBean(AdminService.class);
//       TestAll testAll = ctx.getBean(TestAll.class);
//       testAll.test();
       
       
       
       
//       CompanyService companyService = ctx.getBean(CompanyService.class);
//       CustomerService customerService = ctx.getBean(CustomerService.class);
       
//   		CompanyRepo companyRepo = ctx.getBean(CompanyRepo.class);
//   		CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
//   		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
   	
   		
//   		AdminService adminService = ctx.getBean(AdminService.class);
   		
//   		Customer customer = new Customer(0, "bbb", "bbbb", "bbbb", "bbbb", null);
//   		System.out.println(adminService.addCustomer(customer)); 
//   		Customer customer2 = new Customer(0, "aaa", "aaa", "aaa", "aaa", null);
   		
   		
//   		Company company = new Company(7, "666", "666", "666", null  );
   		
//   		try {
//			 adminService.updateCompany(company);
//		
//   		} catch (CouponSystemException e) {
//			System.err.println(e.getMessage());
//		
//		}
   		
//		
//		
//		companyService.login("sss", "sss");
//		companyService.addCoupon(c1);
		
//		companyService.deleteCoupon(25);
   		
//   	adminService.deleteCompany(5);
//    	adminService.deleteCustomer(6);
//   	
//   		ArrayList<Company> allCompany = adminService.getAllCompany();
//   		for (Company company : allCompany) {
//			System.out.println(company);
//		}
   		
//   		System.out.println(adminService.getOneCompany(1));
   		
//		ArrayList<Customer> allCustmer = adminService.getAllCustomer();
//		for (Customer customer : allCustmer) {
//		System.out.println(customer);
//	}
   		
//   		System.out.println( adminService.getOneCustomer(7));
   		
//       companyService.login("sss", "sss");
//       System.out.println(companyService.getCompanyDetials());
       
//       	customerService.login("bbbb", "bbbb");
//       	customerService.purchaseCouponFromDb(25);
       
//       System.out.println(customerService.login("aaaa", "aaaa")); 
//       List<Coupon> list = customerService.getAllCoupon();
//       for (Coupon coupon : list) {
//		System.out.println(coupon);
//	}
//       System.out.println(customerService.login("aaaa", "aaaa")); 
//       List<Coupon> list = customerService.getAllCouponByCategory(Category.RESTURANT);
//       for (Coupon coupon : list) {
//    	   System.out.println(coupon);
//       }
//       System.out.println(customerService.login("aaaa", "aaaa")); 
//       List<Coupon> list = customerService.getAllCouponUpToMaxPrice(4D);
//       for (Coupon coupon : list) {
//    	   System.out.println(coupon);
//       }

       
//       LoginManager loginManager = ctx.getBean(LoginManager.class) ;
//       CustomerService customer = (CustomerService) loginManager .login("aaaa", "aaaa",ClientType.CUSTOMER);
//       
//       System.out.println(customer.login("aaaa", "aaaa"));	
//       System.out.println(customer.getCustomerDetails()); 
       
//       LoginManager loginManager = ctx.getBean(LoginManager.class) ;
//       CompanyService company = (CompanyService) loginManager .login("ddd", "ddd",ClientType.COMPANY);
       
//       System.out.println(customer.login("aaaa", "aaaa"));	
//       Coupon c1 = new Coupon(0, Category.RESTURANT, "bvbv", "bvbv",LocalDate.of(2020, 05, 05) ,LocalDate.of(2021, 06, 06) ,5, 10D, "bvbv", company.getCompany(2) , null);
//       company.addCoupon(c1);
       //       System.out.println(company.getCompanyDetials()); 
//       

       
      
	}
}
