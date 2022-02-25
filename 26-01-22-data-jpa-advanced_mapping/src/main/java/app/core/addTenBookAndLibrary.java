package app.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.service.LibraryService;

@SpringBootApplication
public class addTenBookAndLibrary {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(addTenBookAndLibrary.class, args);

		LibraryService service = ctx.getBean(LibraryService.class);
//		LibraryRepo libraryRepo =ctx.getBean(LibraryRepo.class);
		
		Library library1 = new Library(0, "libr", "Tel aviv", null);
		Library library2 = new Library(0, "libr2", "Jerusalem", null);
		Library[] libraries = {library1,library2};
 		
		String[] authors = { "Din", "Dan", "Lea", "Moshe", "Sarrah" };
		List<Book> books = new ArrayList<>();
		for (int i = 0; i <=20; i++) {
			LocalDate publication = LocalDate.of(2022,(int) (Math.random()*12)+1, 1);
			Book book = new Book(0, "book-"+i, authors [i % authors.length], publication, null);
			books.add(book);
		}
		
		
		int c = 0 ;
		for (Book book : books) {
			int i = c % libraries.length;
			libraries[i].addBook(book);
			c++;
		}
		
		service.addLibrary(library1);
		service.addLibrary(library2);
		
	}

}
