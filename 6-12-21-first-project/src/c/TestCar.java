package c;

public class TestCar {

	public static void main(String[] args) {
		Car car1 = new Car();

		car1.number = 123456;
		car1.color = "black";
		car1.type = "BMW";
		car1.year = 2020;
		
		System.out.println(car1.number);
		System.out.println(car1.color);
		System.out.println(car1.type);
		System.out.println(car1.year);
	}

}
