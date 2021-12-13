package e.loops;

public class demo1For1 {

	public static void main(String[] args) {

		for (int i = 101; i <= 110; i++) {
			System.out.println(i);
		}

		System.out.println("===============");

		for (int i = 100; i >= 50; i--) {
			System.out.println(i);
		}
		System.out.println("===============");

		for (int i = 100; i <= 200; i += 2) {
			System.out.println(i);
		}
		System.out.println("===============");

		for (int i = 0; i <= 100; i += 7) {

			System.out.println(i);

		}
		System.out.println("===============");

		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.println(i + " " + (int) i);
		}

		System.out.println("===============");
		for (int i = 0, j = 10; i <= 10 && j >= 0; i++, j--) {
			System.out.println(i + " - " + j);

		}
		
	}
}
