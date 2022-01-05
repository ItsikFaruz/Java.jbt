package waitAndNotify;

public class Consumer extends Thread {

	private Stack stack;

	public Consumer(String name ,Stack stack) {
		super(name);
		this.stack = stack;
	}
	
	 
	@Override
	public void run() {
			for (int i = 0; i < 20; i++) {
				
				int r = (int)(Math.random()*101);
				stack.pop();
				
				try {
					Thread.sleep(100);
					System.out.println("\t" + getName() + " popped: "+ r);
				
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					
			}
		}	
	
	
	
	
}
