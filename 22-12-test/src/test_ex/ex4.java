package test_ex;

import java.util.Arrays;

public class ex4 {

	public static void main(String[] args) {

		int[] arr1 = new int[25];
		int[] arr2 = new int[25];
		int[] arr3 = new int[5];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int) (Math.random() * 10);
			arr2[i] = (int) (Math.random() * 10);
		}

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

		System.out.println("---------------------------");

		int max = 0 ;
		
		
		for (int i = 0; i <= 9; i++) {
		max = maxNam(arr1 ,i);
			for (int j : arr3) {
				if (j < max)
					arr3[j] = max;
			}
		
		}	
		
			

		System.out.println(Arrays.toString(arr3));
		

		
	}
	
	
	public static int maxNam(int arr1[] , int i) {
			
			int temp1 = 0;
			for (int j = 0; j < arr1.length; j++) {
				if (i == arr1[j]) {
					temp1 = (temp1 * 10) + i;
					
				}
		
		}
			return temp1;
	}
	
	public static int[] checkArr (int arr[] , int max){
		
		int arrtemp[5];
		for (int i : arr) {
			if (i == null) {
				
			}
		}
		
		
	}
	
	
	
}