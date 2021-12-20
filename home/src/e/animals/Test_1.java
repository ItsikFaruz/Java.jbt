package e.animals;

public class Test_1 {

	public static void main(String[] args) {
		
		Animal[] animals = new Animal[5];
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Bat();
		animals[3] = new Cat();
		animals[4] = new Bird();
		
		for (int i = 0; i < animals.length; i++) {
			Animal animal = animals[i];
			if(animal!=null) {
				animal.speak();
				//System.out.println("========");
				if (animal instanceof Flyer) {
					((Flyer) animal).fly();
					System.out.println("========");
					continue;
				}
			}	System.out.println("========");
		
		}
	
		
		
	}

}
