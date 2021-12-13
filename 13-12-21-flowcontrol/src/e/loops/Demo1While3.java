package e.loops;

import java.util.Scanner;

public class Demo1While3 {

	public static void main(String[] args) {
		
		int password = 123;
		int cnt = 1;
		System.out.println("please enter a password:");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
	
		
		while (input != password && cnt < 3) {
			cnt++;
			System.out.println("worng password,please enter again:");
			input = sc.nextInt();
			
		}		
				
		sc.close();
		if(input == password) {
			System.out.println("you are loged in");			
			
		}else {
	System.out.println("you are locked out");			
			
		}
	}

}
