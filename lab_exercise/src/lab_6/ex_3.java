package lab_6;

public class ex_3 {

	
	public static void main(String[] args) {

		int fbRand = (int)(Math.random()*41)+10;
		
		System.out.println(fbRand);
		
		int[] arr = new int[fbRand];
		arr[0] = 1;
		arr[1] = 1;
		

		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			System.out.println(arr[i]);
		}
		
	
		
			
	}
}