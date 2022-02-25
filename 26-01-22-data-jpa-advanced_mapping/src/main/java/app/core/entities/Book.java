package app.core.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id ;
	@Column(unique=true)
	private String title ;
	private String author ;
	private LocalDate publication;
	@ManyToOne
	@JoinColumn(name = "library_id")
	private Library library;
}
