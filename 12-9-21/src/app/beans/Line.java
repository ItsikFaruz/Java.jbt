package app.beans;

public class Line {
	
	private int length ;

	public Line() {}
	
	
	public Line(int length) {
		this.length = length;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}
	
	public void draw(int length) {
		for (int i = 1; i <= length ; i++) {
			System.out.print("*");
		}
		System.out.println("\n" +length);
	}

}
