package car_exercise;

public class MainCars {


	public static void main(String[] args) {

		Country country = new Country();
		
		country.getHighWay()[0] = new HighWay("ayalon", fillCars());
		country.getHighWay()[1] = new HighWay("bikha", fillCars());
		country.getHighWay()[2] = new HighWay("arava", fillCars());
		country.getHighWay()[3] = new HighWay("begin", fillCars());
		country.getHighWay()[4] = new HighWay("mispar 1", fillCars());

		printAllcarsInCountry(country);
		System.out.println(" numbers car in country is: " + getCarsInCountry(country));
		getCarsInHighWay(country);
		System.out.println("the avg speed in country is: " + avgSpeedInCountry(country));
		maxSpeedInCountry(country);
		busyRoadInCountry(country);
		maxAvgSpeedInHighway(country);

	}

	private static void maxAvgSpeedInHighway(Country country) {
		int max = 0;
		int totalSpeed = 0;
		String road = null;
		for (int i = 0; i < country.getHighWay().length; i++) {
			for (int j = 0; j < country.getHighWay()[i].getCar().length; j++) {

				totalSpeed += country.getHighWay()[i].getCar()[j].getSpeed();
			}
			if (max < totalSpeed / country.getHighWay()[i].getCar().length) {
				max = (totalSpeed / country.getHighWay()[i].getCar().length);
				road = country.getHighWay()[i].getName();
			}
			totalSpeed = 0;
		}

		System.out.println("the max avg road is: " + road + " and avg speed is: " + max);
	}

	private static void busyRoadInCountry(Country country) {
		int max = 0;
		String road = null;
		for (int i = 0; i < country.getHighWay().length; i++) {
			if (max < country.getHighWay()[i].getCar().length) {
				max = country.getHighWay()[i].getCar().length;
				road = country.getHighWay()[i].getName();
			}

		}
		System.out.println("the busy road in country is: " + road + "and cars number is: " + max);
	}

	private static void maxSpeedInCountry(Country country) {
		int maxSpeed = 0;
		for (int i = 0; i < country.getHighWay().length; i++) {
			for (int j = 0; j < country.getHighWay()[i].getCar().length; j++) {
				if (maxSpeed < country.getHighWay()[i].getCar()[j].getSpeed()) {
					maxSpeed = country.getHighWay()[i].getCar()[j].getSpeed();
				}
			}
		}

		System.out.println("the max speed in country is: " + maxSpeed);
	}

	private static int avgSpeedInCountry(Country country) {
		int avgSpeed = 0;

		for (int i = 0; i < country.getHighWay().length; i++) {
			for (int j = 0; j < country.getHighWay()[i].getCar().length; j++) {
				avgSpeed += country.getHighWay()[i].getCar()[j].getSpeed();
			}

		}
		return avgSpeed / getCarsInCountry(country);
	}

	private static void getCarsInHighWay(Country country) {
		for (int i = 0; i < country.getHighWay().length; i++) {
			int numsHigh = 0;
			for (int j = 0; j < country.getHighWay()[i].getCar().length; j++) {
				numsHigh++;
			}
			System.out.println("the number of cars in " + country.getHighWay()[i].getName() + " is: " + numsHigh);
		}

	}

	private static int getCarsInCountry(Country country) {
		int numsHigh = 0;
		for (int i = 0; i < country.getHighWay().length; i++) {
			for (int j = 0; j < country.getHighWay()[i].getCar().length; j++) {
				numsHigh++;
			}
		}

		return numsHigh;

	}

	public static Car[] fillCars() {
		int numberOfCar = (int) (Math.random() * HighWay.numberCars)+1;
		Car[] cars = new Car[numberOfCar];
		for (int i = 0; i < numberOfCar; i++) {
			cars[i] = getRandomCar();
		}

		return cars;
	}

	public static Car getRandomCar() {
		int number = (int) (Math.random() * 9999999) + 1000000;
		int speed = (int) (Math.random() * Car.MAX_SPEED+1);
		if (Math.random() > 0.5) {

			return new FamilyCar(number, speed);
		} else {
			return new SportCar(number, speed);
		}
	}

	public static void printAllcarsInCountry(Country country) {
		for (HighWay highway : country.getHighWay()) {
			System.out.println(highway);
		}

	}

}
