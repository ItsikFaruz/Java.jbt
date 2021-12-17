package lab_9;

public class ex_5 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		int evenSum = 0 ;
		int oddSum= 0;
		
		for (int i = 0 ; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*101);
			System.out.print(arr[i] + ",");
		}
		

		for (int i = 0 ; i<arr.length; i++) {
			if (arr[i] % 2 == 0) {
				evenSum+=arr[i];
			}else {
				oddSum += arr[i];
			}
		}
			
			System.out.println("\n" +"the sum of even is: " + evenSum);
			System.out.println("the sum of odd is: " + oddSum);
		
		if ( evenSum> oddSum ) {
			System.out.println("evens sum is greater");
		}else System.out.println("odds sum is greater");
		
	}

}