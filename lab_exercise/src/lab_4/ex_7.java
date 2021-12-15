package lab_4;

public class ex_7 {

	public static void main(String[] args) {
		int num1 = (int)(Math.random()*7)+1;
		int sum = 1;
			System.out.println(num1 );
			System.out.println("======");
		
			for (int i = 2 ; i <= num1; i++) {
				sum *= i;
			}
			System.out.println(sum);
		
		
	}

}
