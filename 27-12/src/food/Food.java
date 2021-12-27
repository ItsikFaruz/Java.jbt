package food;

public abstract class Food {

	
		private double weight;
		private String taste;
		
		@Override
		public String toString() {
			return "Food [weight=" + weight + ", taste=" + taste + "]";
		}

		public Food() {
		}
		
		public Food(double weight, String taste) {
			super();
			this.weight = weight;
			this.taste = taste;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public String getTaste() {
			return taste;
		}

		public void setTaste(String taste) {
			this.taste = taste;
		}
		
		
		
}
