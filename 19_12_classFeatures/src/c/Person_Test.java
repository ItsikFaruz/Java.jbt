package c;

public class Person_Test {

	public static void main(String[] args) {
		
		Person p1 = new Person ("itsik",33);
		Person p2 = new Person ("elad",32);
		Person p3 = new Person ("moshe",25);
		Person p4 = new Person ("moshe",110);
			
		System.out.println(Person.getCounter());
		
		System.out.println("id p2: " + p2.id);
		System.out.println("name: " + p2.getName());
		System.out.println(p4.getAge());
		
	}

}
