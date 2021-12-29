package car_exercise;

public  class Car {

	private int number;
	private int speed;
	public static final int MAX_SPEED = 110;



	public Car() {
	}
	
	
	public Car(int number, int speed) {
		this.number = number;
		this.speed = speed;
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"= [number=" + number + ", speed=" + speed + "]";
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		if (speed > 0  && speed < MAX_SPEED)
		this.speed = speed;
	}
	
	
	
	
}
