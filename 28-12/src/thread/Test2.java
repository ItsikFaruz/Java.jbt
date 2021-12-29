package thread;

public class Test2  {

	public static void main(String[] args) {

		MyRunAble r = new MyRunAble();
		
		Thread t1 = new Thread(r ,"t1"); 
		Thread t2 = new Thread(r ,"t2"); 
		
		t1.start();
		t2.start();
		
	}

}
