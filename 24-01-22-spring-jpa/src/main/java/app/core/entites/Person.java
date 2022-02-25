package app.core.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity // tell JPA that is a table
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	private int id;
	private String name;
	private int age;
	
	
}
