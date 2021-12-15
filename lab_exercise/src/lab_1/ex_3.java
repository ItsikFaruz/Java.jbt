package lab_1;

public class ex_3 {

	public static void main(String[] args) {

		int num1 = (int) (Math.random() * 101);
		int num2 = (int) (Math.random() * 101);

		System.out.println(num1 + "," + num2);
		System.out.println("the sum is:" + (num1 + num2));
		System.out.println("the average is:" + ((num1 + num2) / 2));
		System.out.println("The remainder div [10]: " +  "num1:" +(num1 % 10) +
				" num2:" + (num2%10));
		System.out.println("The area of rectangle is : " + (num1 * num2));

	}

}
