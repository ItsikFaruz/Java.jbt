package lab_2;

public class ex_5 {

	public static void main(String[] args) {
		
		int num1 = (int)(Math.random()*101);
		int num2 = (int)(Math.random()*101);
		int num3 = (int)(Math.random()*101);
		
		System.out.println(num1 + ", " + num2 + ", " + num3);
		
		
		if (num1<num2 && num1<num3)
			System.out.println("The amaller is: " + num1);
		else if (num2<num1 && num2<num3)
			System.out.println("The amaller is: " + num2);
		else	
			System.out.println("The amaller is: " + num3);
		

	}

}
