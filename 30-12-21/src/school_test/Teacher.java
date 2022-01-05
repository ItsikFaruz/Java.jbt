package school_test;

public class Teacher extends Person {

	private profession profession;

	public Teacher() {
	}

	public Teacher(names name, int age, profession profession) {
		super(name, age);
		this.profession = profession;
	}

	public profession getProfession() {
		return profession;
	}

	public void setProfession(profession profession) {
		this.profession = profession;
	}

	public enum profession {
		MATH, CHEMISTRY, GEOGRAPHY, LITERATURE, PHYSICS, SPORTS;

	}

	@Override
	public String toString() {
		return "[profession=" + profession + ", " + super.toString() + "]";
	}

}
