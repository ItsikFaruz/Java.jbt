package lab_3;

public class ex_3 {

	public static void main(String[] args) {
		int year = (int) (Math.random() * 2022);

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("the year: "+ year + " is leap year");
		}else
		System.out.println("the year: " +year +" is  NOT leap year");
	}

}
