package lab_5;

public class ex_6 {

	public static void main(String[] args) {

		int num = (int) (Math.random() * 10001);
		int copy = num;
		int temp = 0;
		System.out.println(num);
		
		
		
		while (num > 0) {
			temp *= 10;
			temp += num%10;
			num = ((int) num / 10);
		}
			num = copy;
			if (temp == num) {
				System.out.println("the  number " + num + " is palindrom");	
			}else 
				System.out.println("the  number " + num + " is NOT palindrom");
	}

}
