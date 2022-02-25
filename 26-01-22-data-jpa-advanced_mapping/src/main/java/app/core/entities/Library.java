package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "books")
@Entity
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(unique=true)
	String name;
	String address;

	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
	List<Book> books;

	public void addBook(Book book) {
		if (this.books == null) {
			books = new ArrayList<Book>();
			
		} 
			book.setLibrary(this);
			this.books.add(book);
	}

}
