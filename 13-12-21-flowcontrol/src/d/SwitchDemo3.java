package d;

public class SwitchDemo3 {

	public static void main(String[] args) {

		int rday = (int) (Math.random()*7)+1; // 1-7

		switch (rday) {
		case 1:
		case 2:
		case 4:
		case 5:
			System.out.println("16:30");
			break;
		case 3:
			System.out.println("12:30");
			break;
		case 6:
		case 7:
			System.out.println("holiday");
			break;

			default:
				System.out.println(rday + "is not a day");
		
			
		}

	}

}
