package lab_7;

import java.util.Arrays;

public class ex_2 {

	public static void main(String[] args) {

		String name = "John Bryce";

		int h = 0;
		char[] chars = name.toCharArray();

		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == 'h') {
				h++;
			}

		}
		System.out.println(Arrays.toString(chars));
		System.out.println(h);

	}

}
