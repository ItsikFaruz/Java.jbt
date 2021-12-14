package f;

import java.util.Arrays;

public class Arraycopy {

	public static void main(String[] args) {

		int [] arr1 = {2,4,6};
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = new int [arr1.length];
		System.out.println(Arrays.toString(arr2));
		
		//copy arr1 1 to arr2  
		System.arraycopy(arr1, 0, arr2, 0, 3);
		
		System.out.println(Arrays.toString(arr2));
	}

}
