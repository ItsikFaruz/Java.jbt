package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

	public boolean  existsByEmailAndPasswordAndId (String email , String password, int id);
	public boolean  existsByEmailAndName (String email , String password);
	public boolean  existsByEmailOrName (String email , String name);
	public Company  findCompanyByEmailAndPassword (String email , String password);
	
	


}
