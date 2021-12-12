package app.core;

public class Rectangle {

		private int length;
		private int width;
		
		
		public Rectangle() {}
		
		
		public Rectangle(int length, int widht) {
			super();
			this.length = length;
			this.width = widht;
		}


		public int getLength() {
			return length;
		}


		public void setLength(int length) {
					this.length = length;
		}

		public int getWidht() {
			return width;
		}

		
		public void setWidht(int widht) {
			this.width = widht;
		}
		
		public int getArea() {
	
			return length*width;
			
		}
		
		public int getPerimeter() {
			return 2*(length+width);
		
			 	
		}
		
	
	
		public void print() {
			System.out.print(length);
			System.out.print(",");
			System.out.println(width);
			
			
		}
}
