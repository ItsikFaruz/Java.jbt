package food;

public class Apple extends Fruit {



	public Apple() {
	}

	public Apple(int weight, Taste taste) {
		super(weight, taste);
	}

	@Override
	public String toString() {
		return "Apple [getWeight=" + getWeight() + ", getTaste=" + getTaste() + "]";
	}
	
	
	
	
	
}
