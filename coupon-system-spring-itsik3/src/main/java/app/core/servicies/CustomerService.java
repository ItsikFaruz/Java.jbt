package app.core.servicies;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Customer;
import app.core.exception.CouponSystemException;
import app.core.repos.CompanyRepo;
import app.core.repos.CouponRepo;
import app.core.repos.CustomerRepo;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private CouponRepo couponRepo;
	@Autowired
	private CustomerRepo customerRepo;
	
	
	//test
	
	
	
	
	public int addCustomer (Customer customer) {
		customer = customerRepo.save(customer);
		return customer.getId();
	}
	
	
	public void deleteCustomer (int customerId) {
		customerRepo.deleteById(customerId);
	}
	
	
	public List<Customer> getAllCustomers () {
		return  customerRepo.findAll();
	}
	
	
	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		Optional<Customer> opt =  customerRepo.findById(customerId);
		if (opt.isPresent()) {
			Customer customerFromDb = opt.get();
			return customerFromDb;
		}else {
			throw new CouponSystemException("getOneCustomer failed - this customer not exist");
		}
	}
	
	
	
	
	
	
}
