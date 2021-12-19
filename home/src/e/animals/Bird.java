package e.animals;

public class Bird extends Mammal implements Flyer{

	@Override
	public void speak() {
		System.out.println("Tzif Tzif");
		
	}

	@Override
	public void fly() {
		System.out.println("bird fly");
		
	}

	
}
