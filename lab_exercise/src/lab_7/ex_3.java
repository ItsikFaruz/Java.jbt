package lab_7;

import java.util.Arrays;

public class ex_3 {

	public static void main(String[] args) {
		String str = "Sara Shara Shir Cameach";
		char[] charStr = str.toCharArray();
		int counter = 0;
		for (char vOwels : charStr) {
			if (vOwels == 'a' || vOwels == 'e' || vOwels == 'i' || vOwels == 'o' || vOwels == 'u') {
				counter++;
			}
		}

		System.out.println(Arrays.toString(charStr));
		System.out.println("tjere is: " + counter + " Vowels letters");

	}

}
