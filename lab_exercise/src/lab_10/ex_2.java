package lab_10;

import java.util.Arrays;

import java.util.Scanner;

public class ex_2 {

	public static void main(String[] args) {

		Scanner num = new Scanner(System.in);
		int[] arrDup = new int[10];
		int cnt = 0;
		boolean found = false;

		for (int i = 0; i < arrDup.length; i++) {
			System.out.println("enter a number:");
			arrDup[i] = num.nextInt();
		}
		int[] arrtemp = new int[arrDup.length];


		for (int i = 0; i < arrDup.length; i++) {
			found = false;
			for (int j = 0; j < arrDup.length; j++) {
				if (arrDup[i] == arrtemp[j])
					found = true;

			}
			if (!found) {
				arrtemp[cnt] = arrDup[i];
				cnt++;
			}

		}
		
		int[] arrUnic = new int[cnt];
		System.arraycopy(arrtemp, 0, arrUnic, 0, arrUnic.length);

		num.close();
		System.out.println(Arrays.toString(arrDup));
		System.out.println(Arrays.toString(arrtemp));
		System.out.print("the UNIC arr is: ");
		System.out.println(Arrays.toString(arrUnic));
	}

}
