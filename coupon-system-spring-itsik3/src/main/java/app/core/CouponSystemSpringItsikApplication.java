package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Coupon.Category;
import app.core.exception.CouponSystemException;
import app.core.servicies.CompanyService;
import app.core.servicies.CustomerService;

@SpringBootApplication
public class CouponSystemSpringItsikApplication {

	public static void main(String[] args) throws CouponSystemException {
       ApplicationContext ctx =  SpringApplication.run(CouponSystemSpringItsikApplication.class, args);
		
       CompanyService companyService = ctx.getBean(CompanyService.class);
       CustomerService customerService = ctx.getBean(CustomerService.class);
       
//   		CompanyRepo companyRepo = ctx.getBean(CompanyRepo.class);
//   		CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
//   		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
   	
   		
//   		AdminService adminService = ctx.getBean(AdminService.class);
   		
//   		Customer customer = new Customer(0, "bbb", "bbbb", "bbbb", "bbbb", null);
//   		System.out.println(adminService.addCustomer(customer)); 
   		
   		
   		
//   		Company company = new Company(7, "666", "666", "666", null  );
   		
//   		try {
//			 adminService.updateCompany(company);
//		
//   		} catch (CouponSystemException e) {
//			System.err.println(e.getMessage());
//		
//		}
   		
//		Coupon c1 = new Coupon(25, Category.RESTURANT, "yyyy", "yyyy",LocalDate.of(2020, 05, 05) ,LocalDate.of(2022, 06, 06) ,5, 10D, "yyyy", companyService.getCompany(2) , null);
		
		
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
       
       System.out.println(customerService.login("aaaa", "aaaa")); 
       customerService.purchaseCouponFromDb(25);
//       
	}
}
