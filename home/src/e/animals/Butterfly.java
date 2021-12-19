package e.animals;

public class Butterfly extends Mammal implements Flyer{

	@Override
	public void speak() {
		System.out.println("speaks like a Butterfly");
		
	}

	@Override
	public void fly() {
		System.out.println("butterfly fly");
		
	}

	
}
