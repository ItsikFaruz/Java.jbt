package e.animals;

public class Bat extends Mammal implements Flyer{

	@Override
	public void speak() {
		System.out.println("Sqeek");
		
	}

	@Override
	public void fly() {
		System.out.println("bat fly");
		
	}
	
	
}
