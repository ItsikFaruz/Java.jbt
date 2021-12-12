package c;

public class PersonTest {

	public static void main(String[] args) {
		
		Person p1 = new Person ();
		Person p2 = new Person (201202827,"itsik",33,185);
		
		System.out.println(p1.getId());
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getHight());
		System.out.println("====================");
		System.out.println(p2.getId());
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.getHight());
		
	}

}
