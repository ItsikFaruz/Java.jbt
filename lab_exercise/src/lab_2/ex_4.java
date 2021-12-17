package lab_2;

public class ex_4 {

	public static void main(String[] args) {

		int num1 = (int) (Math.random() * 101);
		int num2 = (int) (Math.random() * 101);
		int num3 = (int) (Math.random() * 101);

		System.out.println(num1 + ", " + num2 + ", " + num3);

		if (num1 > num2 && num1 > num3)
			System.out.println("The bigger is:" + num1);
		else if (num2 > num1 && num2 > num3)
			System.out.println("The bigger is:" + num2);
		else
			System.out.println("The bigger is:" + num3);

	}

}
