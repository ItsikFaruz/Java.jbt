package app.core.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.entites.Person;

@Component
@Transactional
public class PersonDao {

	@Autowired
	private EntityManager em;
	
	public void addPerson (Person person) {
		em.persist(person);
	}
	
	public Person find (int personId) {
		Person p = em.find(Person.class, personId);
		return p ;
	}
	public void deleteNyId (int personId) {
		Person p = find(personId);
		em.remove(p);
	}
	public void updatePerson (Person person) {
		Person personFromDb = find(person.getId());
		personFromDb.setName(person.getName());
		personFromDb.setAge(person.getAge());
	}
	
	
}
