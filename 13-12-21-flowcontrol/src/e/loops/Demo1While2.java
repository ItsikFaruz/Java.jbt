package e.loops;

import java.util.Scanner;

public class Demo1While2 {

	public static void main(String[] args) {
		
		int password = 123;
		System.out.println("please enter a password:");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
	
		
		while (input != password) {
			System.out.println("worng password,please enter again:");
			input = sc.nextInt();
			
		}		
			
			sc.close();
	System.out.println("you are logged in");			
			
			
			
		}
	

}
