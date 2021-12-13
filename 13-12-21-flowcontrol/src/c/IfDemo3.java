package c;

public class IfDemo3 {

	public static void main(String[] args) {

		int grade = (int) (Math.random() * 101);
		System.out.println(grade);

		if (grade < 60) {
			System.out.println("FAIL");
		} else if (grade < 70) {
			System.out.println("PASS");
		} else if (grade < 90)
			System.out.println("GOOD");
		else {
			System.out.println("GREAT");
		}
	}

}
