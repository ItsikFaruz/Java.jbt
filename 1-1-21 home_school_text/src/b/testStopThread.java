package b;

public class testStopThread {

	public static void main(String[] args) throws InterruptedException {

		StopThread s1 = new StopThread();
		s1.start();
		Thread.sleep(5000);
		
		s1.interrupt();
		
	}

}
