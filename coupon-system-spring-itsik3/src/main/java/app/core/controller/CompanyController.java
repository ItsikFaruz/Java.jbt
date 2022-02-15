package app.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Coupon;
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
	
	
}
