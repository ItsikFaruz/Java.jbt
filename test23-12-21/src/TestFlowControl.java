import java.util.Arrays;

public class TestFlowControl {

	public static void main(String[] args) {

		int[] nums1 = new int[15];
		int[] nums2 = new int[15];

		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = (int) (Math.random() * 10);
			nums2[i] = (int) (Math.random() * 10);
		}
		System.out.println("ex1 + ex2.___________________\n");
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println();
		System.out.println("ex3._____________________\n");
		
		int max1 = 0;
		int max2 = 0;			
		
		max1 = maxThreeNums(nums1);
		max2 = maxThreeNums(nums2);
		System.out.println(max1);
		System.out.println(max2);
		
		
		System.out.println("\nex4 +ex5._____________________\n");

		int[] distinct = new int [10];
		int cnt = 0 ;
		for (int i = 0; i < distinct.length; i++) {
			distinct[i] = -1;
		}
		
		for (int i = 0; i <= 9  ; i++) {
			if ((findDigit(nums1, i) == true 
					&& findDigit(nums2, i) == false) 
					|| (findDigit(nums1, i) == false 
					&& findDigit(nums2, i) == true) ) {
				distinct[cnt] = i;
				cnt++;
			}
		}
		
		
		System.out.println(Arrays.toString(distinct));
		
		System.out.println("\nex6._____________________\n");
		
		System.out.println(createNumber(distinct));
		
		
	}




	
		public static int  maxThreeNums( int[] arr) {
			int max = 0;
			
			for (int i= 0;  i < (arr.length-2)  ; i++) {
				if(((arr[i] *100) + (arr[i+1]*10) + arr[i+2]) > max )
					max = ((arr[i] *100) + (arr[i+1]*10) + arr[i+2]);
					
			}
			return max;	
		}
		
		public static boolean  findDigit ( int[] arr , int digit) {
		
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == digit) {
					return true;	
				}
				
			}return false;
			
		}
		
		
		public static int createNumber ( int distinct[]) {
			int num = 0 ;
			for (int i = 0; i < distinct.length; i++) {
				if (distinct[i] != -1) {
					num = num * 10 ;
					num = num + distinct[i] ;
				}
				
			}
			return num;
		}
		
}	