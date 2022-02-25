package app.core;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entites.Student;
import app.core.repository.StudentRepo;

@SpringBootApplication
public class Application4 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application4.class, args);

		StudentRepo repo = ctx.getBean(StudentRepo.class);
		
//		List<Student> students =  repo.findByActiveIsTrue();
//		for (Student student : students) {
//			System.out.println(student);
//		}
		List<Student> students =  repo.findByActiveIsFalse();
		for (Student student : students) {
			System.out.println(student);
		}

		
		

	}	
}
