package b;

public class Car {
	
	private int speed;
	
	public int getspeed() {
		return speed;
	}
	
	public void setspeed(int newspeed) {
		if (newspeed >= 0 && newspeed <= 90) 
			speed = newspeed;
			

	}
		
}
