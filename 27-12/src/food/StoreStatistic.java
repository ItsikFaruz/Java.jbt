package food;

public class StoreStatistic {

	public static void main(String[] args) {

		Store store = new Store();

		for (int i = 0; i < 100; i++) {
			int r = (int) (Math.random() * 101);
			if (r <= 50) {
				store.addFruits(new Apple(30, "sweet"));
			}
			if (r > 50) {
				store.addFruits(new Strawbery(25, "sour"));
			}
		}

		for (int i = 0; i < 100; i++) {
			int r = (int) (Math.random() * 101);
			if (r <= 50) {
				store.addVegetable(new Carrot(10, "salty"));
			}
			if (r > 50) {
				store.addVegetable(new Tomato(15, "sour"));
			}
		}
		
		
		
		
		

	}

}
