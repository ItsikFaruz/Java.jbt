package lab_4;

public class ex_3 {

	public static void main(String[] args) {
		
		int num = (int)(Math.random()*30);
		
		System.out.println(num);
		System.out.println("=====");
		
		for (int i = 1 ; i <= num ; i++)
			System.out.print(i + " ");
		
	}

}
