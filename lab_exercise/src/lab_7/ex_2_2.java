package lab_7;

import java.util.Arrays;

public class ex_2_2 {

	public static void main(String[] args) {

		String name = "John Bryce";
		char[] arr = new char [name.length()];
		int h = 0;
		
		
		for (int i = 0; i < name.length(); i++) {
			   arr[i] = name.charAt(i);  
			
			}

		
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == 'h') {
				h++;
			}

		}
		System.out.println(Arrays.toString(arr));
		System.out.println(h);

	}

}
