package lab_8;

public class ex_3 {

	public static void main(String[] args) {
		
		int[] arr = new int [10];
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*101); 
			sum +=arr[i];
			
			
		}
		System.out.println("the sum in arr is: "+sum);	

	}

}
