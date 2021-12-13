package e.loops;

import java.util.Scanner;

public class demo6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("enter 1st number:");
		int a = sc.nextInt();
		System.out.println("enter 2st number:");
		int b = sc.nextInt();
		sc.close();
		
		if (a>b) {
			int temp = a;
			a=b;
			b=temp;
		}
		
		System.out.println(a + " - " + b );
		System.out.println("==================");
		
		for (int i = a ; i<= b ; i ++ ) {
			if ( i %7 == 0 ) {
				System.out.println("boom");
			}else while {
				
				((int) i / 10 == 7)
				
			}
			
			else {
				System.out.println(i);
				
				
			}
		}
		
		
	}
}
