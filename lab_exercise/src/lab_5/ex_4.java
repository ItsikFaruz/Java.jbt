package lab_5;

public class ex_4 {

	public static void main(String[] args) {

		int num = (int) (Math.random() * 10001);
		int opp = 0;
		
		System.out.println(num);

		while (num > 0) {
			opp *= 10;
			opp += num % 10;
			num = ((int) num / 10);
		}

		System.out.println("the left opposite number is: " + opp);

	}

}
