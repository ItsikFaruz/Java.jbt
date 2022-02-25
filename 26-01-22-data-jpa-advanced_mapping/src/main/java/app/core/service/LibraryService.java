package app.core.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.repos.BookRepo;
import app.core.repos.LibraryRepo;

@Service
@Transactional
public class LibraryService {
	
	@Autowired
	private LibraryRepo libraryRepo;

	@Autowired
	private BookRepo bookRepo;
	
	public int  addLibrary (Library library) {
		library = libraryRepo.save(library);
		return library.getId();
		
	}
	
	public int  addBook (Book book) {
		book = bookRepo.save(book);
		return book.getId();
		
	}
	public void  addBookToLibrary (Book book, int libraryId) {
		if (this.libraryRepo.existsById(libraryId) && !bookRepo.existsById(book.getId())){
			Library library = this.libraryRepo.findById(libraryId).get();
			library.addBook(book);
		}else
		throw new RuntimeErrorException(null, "library not found");	
	}
	
	
	public List<Book> getAllBoksOfLibrary (int libraryId) {
		return bookRepo.findByLibraryId(libraryId);
	}
	
	public void updateLibrary (Library library) {
		Optional<Library> opt = libraryRepo.findById(library.getId());
		if (opt.isPresent()) {
			Library libraryFromDb = opt.get();
			libraryFromDb.setName(library.getName());
			libraryFromDb.setAddress(library.getAddress());
			
		}else 
			throw new RuntimeException("updateLibrary faild - not found");
	}
	
	public void updateBook (Book book) {
		if ( this.bookRepo.existsById(book.getId())) {
			Book bookFromDb = bookRepo.findById(book.getId()).get();
			bookFromDb.setTitle(book.getTitle());
			bookFromDb.setPublication(book.getPublication());
		}else 
			throw new RuntimeException("updateBook faild - not found");
	}
	public Optional<Book> findBookById (int bookId){
		return bookRepo.findById(bookId);
	}
	
	public Library getLibraryByName (String libraryName) {
		Library library = libraryRepo.findByName(libraryName);
		if(library != null) {
			return library;
		}
		throw new RuntimeException("getLibraryByName faild - not found");
	}
	
	public List<Book> getAllBooksPublicationBefore (LocalDate date){
		return bookRepo.findByPublicationBefore(date);
	}
	
	public List<Book> getAllBooksPublicationAfter (LocalDate date){
		return bookRepo.findByPublicationAfter(date);
	}
	public List<Book> getAllBooksPublishedBetween (LocalDate date1 , LocalDate  date2){
		return bookRepo.findByPublicationBetweenOrderByPublication(date1 , date2);
	}
	public List<Book> getBooksByAuthorStartingWith (char prefix){
		return bookRepo.findByAuthorStartingWith(prefix);
	}
	
	
	
	
	
	
}
