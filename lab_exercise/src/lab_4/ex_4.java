package lab_4;

public class ex_4 {

	public static void main(String[] args) {
		int num1 = (int)(Math.random()*101);
		int num2 = (int)(Math.random()*101);
		int temp;
		if (num1 > num2) {
			temp=num1;
			num1=num2;
			num2=temp;
		}
		System.out.println(num1 + ", "+ num2);
		
		
		for (int i = num1 ; i <= num2 ; i++)
			System.out.println(i + " ");
		
	}

}
