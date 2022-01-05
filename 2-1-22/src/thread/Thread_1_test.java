package thread;

public class Thread_1_test {

	public static void main(String[] args) {

		
		Thread_1 t1 = new Thread_1();
		t1.start();
		
		try {
			Thread.sleep(6000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.interrupt();
		
	}

}
