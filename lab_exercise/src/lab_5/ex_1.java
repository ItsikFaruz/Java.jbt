package lab_5;

public class ex_1 {

	public static void main(String[] args) {
		
		int num = (int)(Math.random()*10001);
		int cnt=0;
		System.out.println(num);
	
		
		while(num>0) {
			num /= 10;
		    cnt++;
						
		}
		System.out.println(cnt);
	}

}
