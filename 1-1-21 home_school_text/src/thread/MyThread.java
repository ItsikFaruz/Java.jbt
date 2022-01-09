package thread;

public class MyThread extends Thread {
	
	public MyThread() {
	}

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ": " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				System.out.println("===== I was interruped:" + getName());
				break;
			}
			
			
		}
		
		System.out.println("Thread ended:" + getName());
	}
	
	
	
	
	
	
}
