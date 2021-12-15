package lab_2;

public class ex_2 {

	public static void main(String[] args) {
		
		int num = (int)(Math.random()*101);
		
		System.out.println(num);
		
		if ( num < 50 )
			System.out.println("Small!");
		else 
			System.out.println("Big!");

		if ( num%2 == 0)
			System.out.println("Even");
			else System.out.println("Odd");
		
	}

}
