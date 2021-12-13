package a;

public class ConcatDemo3 {

	public static void main(String[] args) {
		System.out.println(Math.random()); // 0 - 0.9999
		System.out.println(Math.random() * 11); // 0 - 10.999
		System.out.println((int) (Math.random() * 11)); // 0 - 10
		System.out.println((int) (Math.random() * 101)); // 0 - 100

		System.out.println("================");

		// x,y 0 - 100 inclusive 
		int x = (int) (Math.random() * 101);
		int y = (int) (Math.random() * 101);
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println(x + " + " + y + " = " + (x + y));
		System.out.println(x + " - " + y + " = " + (x - y));
		System.out.println(x + " * " + y + " = " + (x * y));
		System.out.println(x + " / " + y + " = " + (x / y));
		System.out.println(x + " / " + y + " = " + ((x+0D) / y));
	}

}
