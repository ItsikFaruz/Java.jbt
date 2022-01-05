package thread;

import java.util.Date;

public class Thread_1 extends Thread{

	@Override
	public void run() {
		
		for (int i = 0; i < 100 ; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
				
				
			} catch (InterruptedException e) {
				System.out.println(new Date());
				return;
			}
		}
		
	}
	
}
