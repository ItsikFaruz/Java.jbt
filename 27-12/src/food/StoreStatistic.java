package food;

import food.Food.Taste;

public class StoreStatistic {

	public static void main(String[] args) {

		Store store = new Store();

		fillStore(store);
		store.showStock();

	}

	
	
	
	
	
	public static void fillStore(Store store) {
		boolean notFull = true;
		while (notFull) {
			notFull = store.addFruit(getRandomFruit());

		}
		notFull = true;
		while (notFull) {
			notFull = store.addVevetable(getRandomVegetable());
		}

	}

	private static Vegetable getRandomVegetable() {
		Taste taste = Taste.values()[(int) (Math.random() * Taste.values().length)];
		int weight = (int) (Math.random() * 200) + 100;

		if (Math.random() > 0.5) {
			return new Carrot(weight, taste);
		} else
			return new Tomato(weight, taste);

	}

	public static Fruit getRandomFruit() {
		Taste taste = Taste.values()[(int) (Math.random() * Taste.values().length)];
		int weight = (int) (Math.random() * 200) + 100;

		if (Math.random() > 0.5) {
			return new Apple(weight, taste);
		} else
			return new Strawbery(weight, taste);

	}

}
