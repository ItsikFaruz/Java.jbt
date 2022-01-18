package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.beans.Person;

@Configuration
@ComponentScan
public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		System.out.println("application context started");

		Person p1 = ctx.getBean("person", Person.class);
		Person p2 = ctx.getBean("alertName",Person.class);
		System.out.println(p1);
		System.out.println(p2);

		try {
			System.out.println("closing application context in 5 seconds");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.close();
		System.out.println("application context closed");

	}

	@Bean
	public String name() {
		return "Itsik";
	}
	
	@Bean
	public Person alertName () {
		Person p1 = new Person("Kim");
		p1.setName("Kim");
		return p1;
		
	}
	
}
