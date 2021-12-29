package thread;

public class Test {

	public static void main(String[] args) {

		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		MyThread t3 = new MyThread("T3");
		MyThread t4 = new MyThread("T4");
		MyThread t5 = new MyThread("T5");
		
		Thread[]threads = {t1,t2,t3,t4,t5};
		for (Thread t : threads) {
			t.start();
		}
		
		// t.run(); running one after one      
		
		
		Thread currThread = Thread.currentThread();		
		
		for (int i = 0; i <= 100 ; i++) {
			System.out.println(currThread.getName() + ": " + i);
		}
		
	}

}
