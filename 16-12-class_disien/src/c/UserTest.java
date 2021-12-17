package c;

public class UserTest {

	public static void main(String[] args) {
				
		User u1 = new User(201202827,"itsik","izik703@gmail.com",12345);
		User u2 = new User(201202827,"moshe","izik703@gmail.com",12345);
		System.out.println(u1);
		System.out.println(u1.hashCode());
		System.out.println(u1.equals(u2));
	}

}
