package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Coupon.Category;
import app.core.entities.Customer;
import app.core.exception.CouponSystemException;
import app.core.repos.CompanyRepo;
import app.core.servicies.AdminService;
import app.core.servicies.CompanyService;

@SpringBootApplication
public class CouponSystemSpringItsikApplication {

	public static void main(String[] args) throws CouponSystemException {
       ApplicationContext ctx =  SpringApplication.run(CouponSystemSpringItsikApplication.class, args);
		
       CompanyService companyService = ctx.getBean(CompanyService.class);
   		CompanyRepo companyRepo = ctx.getBean(CompanyRepo.class);
//   		CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
//   		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
   	
   		
   		AdminService adminService = ctx.getBean(AdminService.class);
   		
//   		Customer customer = new Customer(0, "itsik", "faruz", "@@@", "1234", null);
//   		adminService.addCustomer(customer);
   		
   		
   		
//   		Company company = new Company(7, "666", "666", "666", null  );
   		
//   		try {
//			 adminService.updateCompany(company);
//		
//   		} catch (CouponSystemException e) {
//			System.err.println(e.getMessage());
//		
//		}
   		
//		Coupon c1 = new Coupon(0, Category.RESTURANT, "vvv", "vvv",LocalDate.of(2020, 05, 05) ,LocalDate.of(2020, 06, 06) ,10, 10D, "333", companyService.getCompany(2) , null);
//		
//		companyService.addCoupon(c1);
   		
//   	adminService.deleteCompany(5);
   		
//   		ArrayList<Company> allCompany = adminService.getAllCompany();
//   		for (Company company : allCompany) {
//			System.out.println(company);
//		}
   		
//   		System.out.println(adminService.getOneCompany(1));
	}
}
