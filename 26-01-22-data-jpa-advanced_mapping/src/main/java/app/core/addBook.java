package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.service.LibraryService;

@SpringBootApplication
public class addBook {
	
//	add library and add book to specific library

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(addBook.class, args);

		LibraryService service = ctx.getBean(LibraryService.class);
		Book book = new Book(0, "lala", "Kobi", LocalDate.of(2020, 5, 5), null);
		service.addBook(book);
	}
		

}
