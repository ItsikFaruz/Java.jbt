package lab_7;

public class ex_1 {

	public static void main(String[] args) {
		
		int a = 0;
		int ac = 0;
			
		 char[] arr =  {'a','b','c','a','b','d','r','c'};
		 
		 for (int i = 0 ; i<arr.length; i++) {
			 if (arr[i] == 'a') {
				 a++;
			 }
			 
			 if (arr[i] == 'c' || arr[i]== 'a') {
				 ac++;
			 }
		 }
		 
		System.out.println("there is :" + a + " a in the arr and:" + ac + " a/c in the arr");	 
		 

	}

}
