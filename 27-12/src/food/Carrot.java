package food;

public class Carrot extends Vegetable{

	
	public Carrot() {
	}

	public Carrot(int weight, Taste taste) {
		super(weight, taste);
	}

	@Override
	public String toString() {
		return "Carrot [getWeight=" + getWeight() + ", getTaste=" + getTaste() + "]";
	}
	
	



	
	
}
