package lab_7;

import java.util.Arrays;

public class ex_2_3 {
	public static void main(String[] arsg) {
		
		String name = "John Bryce";
		char[] chars = name.toCharArray();
		int counter = 0;
		
		for (char h : chars) {
			if (h == 'h')
				counter ++ ;
		}
		
		System.out.println(Arrays.toString(chars));
		System.out.println("'h' letter shows:" +counter + " times");
		
	}
}
