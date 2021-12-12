package a;

public class Point {

	int x;
	 int y;

	void print() {
		System.out.print("(");
		System.out.print(x);
		System.out.print(", ");
		System.out.print(y);
		System.out.println(")");
	}
	
	void moveright() {
		x++;
	}
	void moveleft() {
		x--;
	}
	void moveup() {
		y++;
	}
	void movedown() {
		y--;
	}
	void reset() {
		x = 0;
		y = 0;
	}
	

}
