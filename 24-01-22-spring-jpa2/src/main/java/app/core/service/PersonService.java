package app.core.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entites.Person;
import app.core.repository.PersonRepository;


@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public int addPerson (Person person) {
		Optional<Person> opt = this.personRepository.findById(person.getId());
		if (opt.isEmpty()) {
			person = this.personRepository.save(person);
			return person.getId();
		}else {
			throw new RuntimeException ("add failed person id " + person.getId() + "already exist");
		}		
	}
	public Person find (int Id) {
		Optional<Person> opt = this.personRepository.findById(Id);
		if (opt.isPresent()) {
			
			return opt.get();
		}else {
			throw new RuntimeException ("find failed person id " + Id + "not found");
		}		
	}
	public void update (Person person) {
		Optional<Person> opt = this.personRepository.findById(person.getId());
		if (opt.isPresent()) {
			this.personRepository.save(person);
		}else {
			throw new RuntimeException ("update failed - person id " + person.getId() + "not found");
		}		
	}
	public void delete (int id) {
		Optional<Person> opt = this.personRepository.findById(id);
		if (opt.isPresent()) {
			this.personRepository.deleteById(id);
		}else {
			throw new RuntimeException ("update failed - person id " + id + "not found");
		}		
	}
	
	
	
	
	
}
