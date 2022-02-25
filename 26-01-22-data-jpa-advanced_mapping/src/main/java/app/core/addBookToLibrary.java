package app.core;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.repos.LibraryRepo;
import app.core.service.LibraryService;

@SpringBootApplication
public class addBookToLibrary {
	
//	add library and add book to specific library

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(addBookToLibrary.class, args);
		LibraryRepo libraryRepo = ctx.getBean(LibraryRepo.class);
		int libraryId=3;
		
		LibraryService service = ctx.getBean(LibraryService.class);
		Book book = new Book(0, "toto", "tami", LocalDate.of(2020, 5, 5), null);
		Optional<Library> opt = libraryRepo.findById(libraryId);
		if(opt.isPresent()) {
			service.addBookToLibrary(book, libraryId);
			
		}else
			System.out.println("not found");
		
		
	}
		

}
