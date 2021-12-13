package d;

public class SwitchDemo1 {

	public static void main(String[] args) {

		String day = "saturday";

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
