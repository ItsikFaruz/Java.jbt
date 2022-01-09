package food;

public class Store {

	Fruit[] fruits = new Fruit[100];
	Vegetable[] vegetables = new Vegetable[100];

	public boolean addFruit(Fruit fruit) {

		for (int i = 0; i < this.fruits.length; i++) {
			if (fruits[i] == null) {
				fruits[i] = fruit;
				return true;
			}
		}return false;

	}

	
	public boolean addVevetable(Vegetable vegetable) {

		for (int i = 0; i < vegetables.length; i++) {
			if (vegetables[i] == null) {
				vegetables[i] = vegetable;
				return true;
			}
		}return false;

	}

	public void showStock() {
		System.out.println("====stock int store====");
		System.out.println("...fruit...");
		for (Fruit fruit : fruits) {
			System.out.println(fruit);
		}
		System.out.println("\n...vegetables...");
		for (Vegetable veg : vegetables) {
			System.out.println(veg);
		}
	}
	
	public                                           
	
}
