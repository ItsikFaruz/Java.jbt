package d.scope;

import java.security.DomainCombiner;
import java.security.PublicKey;

public class Person {
	
	// attributes are global in the class
	// global variable are initialized automatically to default values 
	private int id;
	private String name;
	private int age;
	
	
	public int getId() {
		int id ; // this id is local to this method - not initialized
		id = 10; // initialization
		System.out.println(id); // 10
		System.out.println(this.id); // the value of the Person.id
		return this.id;
		
	}

}
