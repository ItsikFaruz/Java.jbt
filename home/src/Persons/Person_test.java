package Persons;

public class Person_test {

	public static void main(String[] args) {
		System.out.println(Person.getCounter());
		Person[] persons = new Person[5];
		persons[0] = new Person("Itsik", 33);	
		persons [1] = new Person("David", 35);	
		persons [2] = new Person("Shlomi", 40);	
		persons [3]= new Person("Moshe", 70);	
		persons [4] = new Person("Eldar", 50);	

		for (int i = 0; i < persons.length; i++) {
			System.out.println((persons[i].getName())
			+ " " + (persons[i].getAge())+ " "+ persons[i].id);
		}
	}

}
