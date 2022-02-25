package app.core.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.repos.BookeRepo;

@Transactional
@Service
public class BookService {

	@Autowired
	private BookeRepo bookeRepo;
	
	public int addBook(Book book) {
		return this.bookeRepo.save(book).getId();
	}
	
	public Book getBook(int  bookId) {
		Optional<Book> opt = bookeRepo.findById(bookId);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			throw new RuntimeException("getBook faild - not found");
		}
			
	}
	
	public List<Book> getAllBooks(){
		return bookeRepo.findAll();
	}
	
	public void updateBook (Book book) {
		if ( bookeRepo.existsById(book.getId())) {
			bookeRepo.save(book);
		}else {
			throw new RuntimeException("update book failed. book id " + book.getId()+ " not found");
		}
	}	
	public void deleteBook (int bookId) {
		if (bookeRepo.existsById(bookId)) {
			bookeRepo.deleteById(bookId);
			}else
			{
				throw new RuntimeException("delete book failed. book id " + bookId+ "not found");
			}
	}
   
}