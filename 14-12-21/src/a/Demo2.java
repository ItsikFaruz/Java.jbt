package a;



public class Demo2 {

	public static void main(String[] args) {
		// create an array of int - length 5

		int[] grades = new int[100];

		for (int i = 0; i < grades.length; i++) {
			grades[i] = (int) (Math.random() * 101);
			System.out.println(grades[i]);
		}

	}

}
