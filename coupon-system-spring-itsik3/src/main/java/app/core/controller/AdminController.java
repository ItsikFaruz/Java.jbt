package app.core.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Company;
import app.core.entities.Customer;
import app.core.exception.CouponSystemException;
import app.core.servicies.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/add_company")
	public ResponseEntity<?> addCompany (@RequestBody Company company) {
		
		try {
			int id = adminService.addCompany(company);
			return ResponseEntity.ok(id);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
 
		}
				
	}
	
	@PutMapping("/update_company")
	public ResponseEntity<?> updateCompany (@RequestBody Company company){
		
		try {
			adminService.updateCompany(company);
			return ResponseEntity.ok("company: " + company.getId()+ " updated");
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete_company/{companyId}")
	public ResponseEntity<?> deleteCompany (@PathVariable int companyId){
		try {
			adminService.deleteCompany(companyId);
			return ResponseEntity.ok("company: " + companyId + " deleted");
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/get_all_companies")
	public ResponseEntity<?> getAllCompany(){
		try {
			List<Company> companies = adminService.getAllCompany();
			return ResponseEntity.ok(companies);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/get_one_company/{companyId}")
	public ResponseEntity<?> getOneCompany(@PathVariable int companyId){
		try {
			 return ResponseEntity.ok(adminService.getOneCompany(companyId));
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
			
		
	}
	@PostMapping("/add_customer")
	public ResponseEntity<?> addCompany (@RequestBody Customer customer) {
		
		try {
			int id = adminService.addCustomer(customer);
			return ResponseEntity.ok(id);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
 
		}
		
	}
	
	@PutMapping("/update_customer")
	public ResponseEntity<?> updateCustomer (@RequestBody Customer customer){
		try {
			int id = adminService.updateCustomer(customer);
			return ResponseEntity.ok("customer: " + id + " updated");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	@DeleteMapping("/delete_customer/{customerId}")
		public ResponseEntity<?> deleteCustomer (@PathVariable int customerId ){
			try {
				adminService.deleteCustomer(customerId);
				return ResponseEntity.ok("customer: " +customerId+ " deleted");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
		}
	
	@GetMapping("/get_all_customer")
	public ResponseEntity<?> getAllCustomer(){
		try {
			List<Customer> customers = adminService.getAllCustomer();
			return ResponseEntity.ok(customers);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/get_one_customer/{customerId}")
	public ResponseEntity<?> getOneCustomer (@PathVariable int customerId){
		try {
			 return ResponseEntity.ok(adminService.getOneCustomer(customerId));
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
			
	
	
	}	
	
	
}
