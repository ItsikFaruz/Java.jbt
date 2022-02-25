package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Library;
import app.core.service.LibraryService;

@SpringBootApplication
public class addLibrary {
	
//	add library and add book to specific library

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(addLibrary.class, args);

		LibraryService service = ctx.getBean(LibraryService.class);
		Library library = new Library(0, "aaa", "Haifa", null);
		service.addLibrary(library);
	}
		

}
