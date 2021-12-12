package a;

public class PoinTest {

 public static void main(String[] args) {
		
		Point point1; // variable declaration: type + identifier
		point1 = new Point(); // variable initialization 
		
		Point point2 = new Point();
		

		point1.x = 1;
		point1.y = 1;
		point2.x = 1;
		point2.y = 1;
		point1.print();
		point2.print();
		point1.moveup();
		point2.moveup();
		point1.moveright();
		point2.moveright();
		point1.print();
		point2.print();
		point1.reset();
		point2.reset();
		point1.print();
		point2.print();
	}

}
