package lab_10;

import java.util.Arrays;

import java.util.Scanner;

public class ex_3 {

	public static void main(String[] args) {
		
		Scanner num = new Scanner(System.in);
		int[] arrDup = new int [5];
		
		boolean found = false;
		int cnt = 0;
		
		for (int i = 0; i < arrDup.length; i++) {			
			System.out.println("enter a number:");
			arrDup[i] = num.nextInt();		
		}
		
		for (int i = 0; i < arrDup.length; i++) {
			found = false; 
			for (int j = 0; j < arrDup.length; j++){				
				if ( arrDup[i] == arrDup [j]) {
					found = true;
				}
			}
				if(!found) {
					cnt++;
				}					
		}
		
		int[] arrUnic = new int [cnt];
		
		for (int i = 0; i < arrUnic.length; i++) {
			found = false; 
			for (int j = 0; j < arrUnic.length; j++){				
				if ( arrDup[i] == arrUnic [j]) {
					found = true;
				}
			}
				if(!found) {
					arrUnic[(-cnt)+1] = arrDup[i];
					cnt--;
				}
		
		}
		
		num.close();
		System.out.println(Arrays.toString(arrDup));
		System.out.println(Arrays.toString(arrUnic));
	}

}
