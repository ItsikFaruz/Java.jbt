package lab_5;

public class ex_3 {

	public static void main(String[] args) {
		
		int num = (int)(Math.random()*10001);
		
		System.out.println(num);
		
		while (num>9) {
		num/=10;	
		}
	
		System.out.println("the left digit is: " +num );
	
						
	
	
	}

}
