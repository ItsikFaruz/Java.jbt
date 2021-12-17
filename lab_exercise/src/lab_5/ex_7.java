package lab_5;

public class ex_7 {

	public static void main(String[] args) {
		int num = (int) (Math.random() * 100) + 1;
		int j = 0;
		int i = 0;
		num = 150;
		System.out.println(num);
		System.out.println("======");

		lbl: for (i = 1; i <= num; i++) {
			if (i % 7 == 0) {
				System.out.println(" boom ");
				continue lbl;
			}
			j = i;
			while (j > 0) {
				if (j % 10 == 7) {
					System.out.println(" boom ");
					continue lbl;
				}
				j = (int) j / 10;
			}
			System.out.println(i);

		}
	}
}