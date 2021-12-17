package lab_6;

public class ex_2 {

	public static void main(String[] args) {
		int[] arr = new int[39];
		arr[0] = 1;
		arr[1] = 1;
		
		int fbRand = (int)(Math.random()*41);
		
		

		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
	
		}
		
		System.out.println(fbRand);
		System.out.println(arr[fbRand]);
			
	
	}	

}
