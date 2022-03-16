package app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Coupon;
import app.core.servicies.CompanyService;
import app.core.servicies.CustomerService;
@CrossOrigin
@RestController
@RequestMapping("/LAYOUT")
public class LayoutController {

	@Autowired
	CustomerService customerService;
	@Autowired
	CompanyService companyService;
	
	
	
	@GetMapping("/get_all_products")
	public List<Coupon> getAllProducts(@RequestHeader String token) {
		return this.customerService.getAllProducts();
	}
	
	@GetMapping("/get_one_coupon/{couponId}")
	public Coupon getCoupon( @PathVariable int couponId ) {
		
			return companyService.getCoupon(couponId);
	}
	
	
}
