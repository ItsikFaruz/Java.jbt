package app.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.repos.BookRepo;

@SpringBootApplication
public class getBooksOfLibrary {

//	get books of specific library
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(getBooksOfLibrary.class, args);

		BookRepo bookRepo = ctx.getBean(BookRepo.class);
		List<Book> books = new ArrayList<>();
		books=(bookRepo.findByLibraryId(3));
		
		for (Book book : books) {
			System.out.println(book);
		}
	}
		

}
