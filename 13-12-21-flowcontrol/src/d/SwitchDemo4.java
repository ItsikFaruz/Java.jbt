package d;

import java.util.Scanner;

public class SwitchDemo4 {

	public static void main(String[] args) {

		Scanner inputday = new Scanner(System.in);
		System.out.println("please enter a day:");
		String day = inputday.nextLine();
		inputday.close();
		

		switch (day) {
		case "sunday":
		case "monday":
		case "wednsday":
		case "thursday":
			System.out.println("16:30");
			break;
		case "tuesday":
			System.out.println("12:30");
			break;
		case "friday":
		case "saturday":
			System.out.println("holiday");
			break;

			default:
				System.out.println(day + "is not a day");
		
			
		}

	}

}
