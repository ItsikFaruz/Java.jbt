package lab_8;

public class ex_4 {

	public static void main(String[] args) {
		
		int[] arr = new int [10];
		int avg = 0;
		int sum = 0 ;
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*101); 
			System.out.println(arr[i] + ",");
			sum +=arr[i];
			avg++;
			
		}
		System.out.println("the avg in arr is: "+sum/avg);	

	}

}
