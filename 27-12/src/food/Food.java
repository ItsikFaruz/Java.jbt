package food;

public abstract class Food {

	
	private int weight ;
	private Taste taste;
	
	public enum Taste{
		SALTY,SWEET,SPICY,SOUR,BITTER;
	}

	public Food() {
	}
	
	public Food(int weight, Taste taste) {
		super();
		this.weight = weight;
		this.taste = taste;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Taste getTaste() {
		return taste;
	}

	public void setTaste(Taste taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return "Food [weight=" + weight + ", taste=" + taste + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
