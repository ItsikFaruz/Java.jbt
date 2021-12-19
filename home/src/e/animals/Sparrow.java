package e.animals;

public class Sparrow extends Mammal implements Flyer{

	@Override
	public void speak() {
		System.out.println("sparrowww");
		
	}

	@Override
	public void fly() {
		System.out.println("sparrow fly");
		
	}

	
}
