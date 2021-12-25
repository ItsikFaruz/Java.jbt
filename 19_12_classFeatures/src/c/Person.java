package c;

public class Person {

	// instance variables
	public final int id; // final cannot be reassigned
	private String name;
	private int age;

	// class variables
	private static int counter;
	// constant
	public static final int MAX_AGE = 120;
	
	static { //static initializer - run on class load - only once, (+static before {} )
		if ( Math.random()<0.5)
			counter = 100;
		else {
			counter = 1000;
		}
		System.out.println("class loaded - counter set to " + counter);
		
		
	}

	{ // initializer - run on object creation before CTOR ( only {} )
		System.out.println("Person created");
		counter++;
		this.id = counter; // id is assigned and locked on this value
	}

	public Person() {

	}

	public Person(String name, int age) {
		super();

		this.name = name;
		setAge(age); // send to method setAge

	}

	public static int getCounter() {
		return counter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= MAX_AGE)
			this.age = age;
	}

}
