package food;

public class Tomato extends Vegetable {


	public Tomato() {
	}

	public Tomato(int weight, Taste taste) {
		super(weight, taste);
	}

	@Override
	public String toString() {
		return "Tomato [getWeight=" + getWeight() + ", getTaste=" + getTaste() + "]";
	}

	
	
	
}
