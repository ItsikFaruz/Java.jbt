package thread;

public class myThreadTest {

	public static void main(String[] args) {

	MyThread t1 = new MyThread("thread-1");
	System.out.println(" is t1 alive? " + t1.isAlive()  );
	System.out.println(t1.getState());
	t1.start();
	System.out.println(" is t1 alive? " + t1.isAlive()  );
	System.out.println(" is t1 interrupted? " + t1.isInterrupted()	);
	System.out.println(t1.getState());
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	System.out.println(t1.getState());
	t1.interrupt();
	
	
	try {
		t1.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println(t1.getState());
	System.out.println(" is t1 alive? " + t1.isAlive()  );
	
	
	}

}
