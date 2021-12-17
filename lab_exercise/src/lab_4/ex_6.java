package lab_4;

public class ex_6 {

	public static void main(String[] args) {
		int max = (int)(Math.random()*101);
		int den = (int)(Math.random()*101);
	
	
		
			System.out.println(max + ", "+ den);
			
			System.out.println("=======");
		
			for (int i = 0 ; i <= max ; i++) {
				if(i % den == 0 )
			System.out.println(i + " ");
			}
		
	}

}
