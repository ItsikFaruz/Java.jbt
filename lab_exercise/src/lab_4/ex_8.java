package lab_4;

public class ex_8 {

	public static void main(String[] args) {
		int num1 = (int)(Math.random()*7)+1;
		int sum = 1 ;
		int temp ;
			System.out.println(num1 );
			System.out.println("======");
		
			for (int i = num1 ; i >= 1 ; i--) {
				sum*=i;
			}
			System.out.println(sum);
			System.out.println("===========");
			sum=1;
			temp = num1;
			while(temp>0) {
			
				sum*=temp;
				temp --;
			}
			System.out.println(sum);
			System.out.println("==========");
			sum=1;
			temp=1;
			while ( temp <= num1 ) {
				sum*=temp;
				temp ++ ;
			}
			
			System.out.println(sum);
			
	}
	
 public static void factorial(int num1) {
		int sum =1 ;
		for (int i = 2 ; i <= num1; i++) {
			sum *= i;
		}
		System.out.println(sum);
	 
 }
}