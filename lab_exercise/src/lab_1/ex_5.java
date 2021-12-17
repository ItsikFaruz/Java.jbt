package lab_1;

public class ex_5 {

	public static void main(String[] args) {
		  
		int num1 = (int)(Math.random()*101);
		int num2 = (int)(Math.random()*101);
		System.out.println(num1 + " , " + num2);
		
		
		
		int max = num1 > num2 ? num1 : num2;
		System.out.println("the bigger is: " + max );
		
	}

}
