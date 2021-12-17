package lab_1;

public class ex_4 {

	public static void main(String[] args) {
			
		int time = (int)(Math.random()*251)+100;
		
		System.out.println("the time of the movie in minutes is: " + time  );
		System.out.println("the time of the movie in hours and minutes is: " + 
							(int)(time/60) +" huors" + " and " +(time%60) + " minutes");
		
		
	}

}
