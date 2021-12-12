package app.core;

public class rectangleTest {

	public static void main(String[] args) {
		
		Rectangle rec1 = new Rectangle();
		Rectangle rec2 = new Rectangle(10,5);
		
		
		rec1.setLength(11);
		System.out.println(rec1.getLength());
		
		rec1.print();
		System.out.println(rec1.getArea());
		System.out.println(rec1.getPerimeter());
		System.out.println("======");
		rec2.print();
		System.out.println(rec2.getArea());
		System.out.println(rec2.getPerimeter());

	}

}
