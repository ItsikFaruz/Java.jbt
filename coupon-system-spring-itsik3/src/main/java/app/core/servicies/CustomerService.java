package app.core.servicies;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.core.entities.Customer;
import app.core.exception.CouponSystemException;

@Service
@Transactional
public class CustomerService extends ClientService {
	

	
	@Override
	public boolean login(String email, String password) {
		if (customerRepo.existsByEmailAndPassword(email, password)) 
			return true;
		else 
			return false;
	
	}

		
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
