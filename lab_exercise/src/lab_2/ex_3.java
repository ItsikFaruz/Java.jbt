package lab_2;

public class ex_3 {

	public static void main(String[] args) {
			
		
		int salary = (int)(Math.random()*1001)+5000;
		
		System.out.println("the current salary is: "+ salary);
		
		if ((salary *1.1) < 6000) {
			salary*=1.1;
			System.out.println("the new salary + 10% is: " +salary );
			
		}else {
			salary*=1.05;
			System.out.println("the new salary + 5% is: " +salary );
		}
			
			
		
	}

}
