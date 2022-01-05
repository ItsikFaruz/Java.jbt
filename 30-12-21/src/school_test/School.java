package school_test;

public class School {

	ClassRoom[] classrom = new ClassRoom[5];

	public School() {
	}

	public School(ClassRoom[] classrom) {
		super();
		this.classrom = classrom;
	}

	public ClassRoom[] getClassrom() {
		return classrom;
	}

	public void setClassrom(ClassRoom[] classrom) {
		this.classrom = classrom;
	}

}
