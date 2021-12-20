package lab_9;

public class ex_3 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		int sum = 0 ;
		for (int i = 0 ; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*101);
			System.out.print(arr[i] + ",");
		}
		
		System.out.println();
		System.out.print("enen numbers: ");
		for (int i = 0 ; i<arr.length; i++) {
			sum+=arr[i];	
			if (arr[i] % 2 == 0)
				System.out.print(arr[i] + ",");
		}
		
		System.out.println("\n" + "sum: " + sum);
	}

}