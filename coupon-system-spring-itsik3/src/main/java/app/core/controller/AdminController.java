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
import app.core.entities.Customer;
import app.core.exception.CouponSystemException;
import app.core.servicies.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/add_company")
	public String addCompany (@RequestBody Company company) {
		
		try {
			 
			int id =  adminService.addCompany(company);
			return ("company: " + id + " added");
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
 
		}
				
	}
	
	@PutMapping("/update_company")
	public String updateCompany (@RequestBody Company company){
		
		try {
			adminService.updateCompany(company);
			return ("company: " + company.getId()+ " updated");
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping("/delete_company/{companyId}")
	public String deleteCompany (@PathVariable int companyId){
		try {
			adminService.deleteCompany(companyId);
			return ("company: " + companyId + " deleted");
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@GetMapping("/get_all_companies")
	public List<Company> getAllCompany(){
		try {
			List<Company> companies = adminService.getAllCompany();
			return (companies);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/get_one_company/{companyId}")
	public Company getOneCompany(@PathVariable int companyId){
		try {
			 return (adminService.getOneCompany(companyId));
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
			
		
	}
	@PostMapping("/add_customer")
	public String addCompany (@RequestBody Customer customer) {
		
		try {
			int id = adminService.addCustomer(customer);
			return ("customer: " +id+ " added");
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
 
		}
		
	}
	
	@PutMapping("/update_customer")
	public String updateCustomer (@RequestBody Customer customer){
		try {
			int id = adminService.updateCustomer(customer);
			return ("customer: " + id + " updated");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	@DeleteMapping("/delete_customer/{customerId}")
		public String deleteCustomer (@PathVariable int customerId ){
			try {
				adminService.deleteCustomer(customerId);
				return ("customer: " +customerId+ " deleted");
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			}
		}
	
	@GetMapping("/get_all_customer")
	public List<Customer> getAllCustomer(){
		try {
			List<Customer> customers = adminService.getAllCustomer();
			return (customers);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/get_one_customer/{customerId}")
	public Customer getOneCustomer (@PathVariable int customerId){
		try {
			 return (adminService.getOneCustomer(customerId));
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
			
	
	
	}	
	
	
}
