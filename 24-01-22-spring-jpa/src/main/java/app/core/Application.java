package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.dao.PersonDao;
import app.core.entites.Person;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		PersonDao personDao = ctx.getBean(PersonDao.class);
		
//		Person person = new Person(102,"bbb", 33);
//		personDao.addPerson(person);	
		
//		Person p = personDao.find(102);
//		System.out.println(p);
		
		personDao.deleteNyId(102);
		System.out.println("deleted");
		
//		Person t = new Person(102, "nnn", 35);
//		personDao.updatePerson(t);
//		
		
	}

}
