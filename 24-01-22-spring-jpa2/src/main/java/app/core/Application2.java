package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.service.PersonService;

@SpringBootApplication
public class Application2 {


	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Application2.class, args);
		
		PersonService service = ctx.getBean(PersonService.class);
		
		
//		Person p1 = new Person(1, "aaa", 22);
//		Person p2 = new Person(2, "bbb", 35);
		
		service.delete(3);
		service.delete(4);		
		
	}

}
