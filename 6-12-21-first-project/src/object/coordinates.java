package object;

public class coordinates {

	public static void main(String[] args) {

		Point p1 = new Point();

		p1.x = 0;
		p1.y = 0;
		p1.print();
		p1.moveright();
		p1.moveup();
		p1.print();
		p1.reset();
		p1.print();

	}

}
