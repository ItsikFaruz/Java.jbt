package lab_10;

public class ex_1 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,2,3,3,2,1,9,5,1,1,9} ;
		int num3=0;
		int num1= 0;
			
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 3) {
				num3++;
			}
			if (arr[i] == 1) {
				num1++;
			}
				
		}
		System.out.println("3 shows:" + num3+ " times ");
		System.out.println("1 shows:" + num1+ " times ");
	}

}
