package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	public boolean  existsByEmailAndPassword (String email , String password);
	
	public boolean  existsByEmail (String email);

}
