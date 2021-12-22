package test_ex;

import java.util.Arrays;

public class ex1 {

	public static void main(String[] args) {

		int[] arr1 = new int[25];
		int[] arr2 = new int[25];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int) (Math.random() * 10);
			arr2[i] = (int) (Math.random() * 10);
		}

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

		System.out.println("---------------------------");

		int max = 0;
		int temp = 0;

		for (int i = 0; i <= 9; i++) {
			temp = 0;
			for (int j = 0; j < arr1.length; j++) {
				if (i == arr1[j]) {
					temp = (temp * 10) + i;
				}

			}

			if (temp > max) {
				max = temp;
			}
		}

		System.out.println("max arr1: " + max);
		
		max=0;
		for (int i = 0; i <= 9; i++) {
			temp = 0;
			for (int j = 0; j < arr2.length; j++) {
				if (i == arr2[j]) {
					temp = (temp * 10) + i;
				}

			}

			if (temp > max) {
				max = temp;
			}
		}

			
		System.out.println("max arr2: " + max);
		System.out.println("----------------------------");
		

		
		
		
		
		int[] arrtemp = new int [50]; 
		int[] arr3 = new int[5];
		
		for (int i = 0; i < arr1.length ; i++) {
				arrtemp[i]=arr1[i];
			}
			
		int cnt=0;
		  for (int i = (arr1.length); i < arrtemp.length  ; i++) {
			  	
				arrtemp[i]=arr2[cnt];
				cnt++;

		  }

		System.out.println(Arrays.toString(arrtemp));
		
				cnt=0;
				for (int j = 9; j >= 0; j--) {
				for (int i = 0; i < arrtemp.length; i++) {
					if (cnt<5) {	
					if (arrtemp[i] == j) {
							arr3[cnt] = j;
							cnt++;
							break;
						}				
					
				}
			}
		}
				System.out.println("------------------------");
						System.out.println(Arrays.toString(arr3));
	}
}