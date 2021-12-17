package lab_5;

public class ex_5 {

	public static void main(String[] args) {

		int num = (int) (Math.random() * 10001);
		int sum = 0;
		System.out.println(num);

		while (num > 9) {
			sum += num%10;
			num = ((int) num / 10);
		}
			sum+= num;
		System.out.println("the sum of numbers digits is: " + sum);

	}

}
