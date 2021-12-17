package b.shapes;

public class Rectangle extends Shape {
	
		private  double width;
		private  double length;
		
		public Rectangle() {
			super(); // super not must
		}
		
		public Rectangle(String color ,double width, double length) {
			super(color);  // invoke from Shape 
			this.width = width;
			this.length = length;
		}
		
		
		// send to CTOR above
		public Rectangle(double width, double length) {
			this("black" , width , length );
					
			
		}
		
	
}
