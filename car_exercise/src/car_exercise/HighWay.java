package car_exercise;

import java.util.Arrays;

public class HighWay {

	
	public static final int numberCars = 5;
	
	private String name;

	private Car[] car = new Car[numberCars];

	

	@Override
	public String toString() {
		return "HighWay [name=" + name + ", car=" + Arrays.toString(car) + "]";
	}

	
	
	public HighWay() {
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Car[] getCar() {
		return car;
	}



	public void setCar(Car[] car) {
		this.car = car;
	}



	public HighWay(String name, Car[] car) {
		this.name = name;
		this.car = car;
	}


	
}
