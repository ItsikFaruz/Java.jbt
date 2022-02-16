package app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Coupon.Category;
import app.core.exception.CouponSystemException;
import app.core.servicies.CompanyService;


@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@PostMapping("/add_coupon")
	public String addCoupon (@RequestBody Coupon coupon) {
		try {
			int id = companyService.addCoupon(coupon);
			return ("coupon: " + id + " added");
			
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		
		}
	
	}
	
	@PutMapping("/update_coupon")
	public String updateCompany (@RequestBody Coupon coupon){
		
		try {
			companyService.updatCoupon(coupon);
			return ("coupon: " + coupon.getId()+ " updated");
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping("/delete_coupon/{couponId}")
	public String deleteCoupon (@PathVariable int couponId){
		try {
			companyService.deleteCoupon(couponId);
			return ("company: " +  couponId + " deleted");
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@GetMapping("/get_company_coupon")
	public List<Coupon> getAllCompanyCoupon(){
		try {
			List<Coupon> coupons = companyService.getAllCompanyCoupon();
			return (coupons);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/get_company_coupon_by_category/{category}")
	public List<Coupon> getAllCompanyCouponByCategory(@PathVariable Category category){
		try {
			List<Coupon> coupons = companyService.getAllCompanyCouponByCategory(category);
			return (coupons);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/get_company_coupon_up_to_max_price/{maxPrice}")
	public List<Coupon> getAllCompanyCouponUpToMaxPrice(@PathVariable double maxPrice){
		try {
			List<Coupon> coupons = companyService.getAllCompanyCouponUpToMaxPrice(maxPrice);
			return (coupons);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/get_company_details")
	public Company getOneCompanyDetails() {
		try {
			 return (companyService.getCompanyDetials());
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	
	
	}
	
}
