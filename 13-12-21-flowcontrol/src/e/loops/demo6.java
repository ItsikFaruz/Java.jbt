package e.loops;

import java.util.Scanner;

public class demo6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter 1st number:");
		int a = sc.nextInt();
		System.out.println("enter 2st number:");
		int b = sc.nextInt();
		sc.close();

		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		System.out.println(a + " - " + b);
		System.out.println("==================");

		 for (int i = a; i <= b; i++) {
			int temp = i;
			if (temp % 7 == 0) {
				System.out.println("boom");
				continue;
			} else if (temp > 9) {
				while (temp >9) {
					if ((int) temp / 10 == 7) {
						System.out.println("boom");
					
					}

					temp = (int)temp / 10;
				}
				else
					System.out.println(i);
			}

			else
				System.out.println(i);

		}

	}
}
