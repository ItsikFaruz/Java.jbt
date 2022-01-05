package school_test;

public class Person {

	private names name;
	private int age = MIN_AGE;

	public static final int MIN_AGE = 20;
	public static final int MAX_AGE = 120;

	public Person() {
	}

	public Person(names name, int age) {
		super();
		this.name = name;
		setAge(age);
	}

	public names getName() {
		return name;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + " ";
	}

	public void setName(names name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < MAX_AGE && age > MIN_AGE)
			this.age = age;
	}

	public enum names {
		MOSHE, ELDAR, AVI, OHAD, DANA, NAVA, ORIT, NAOMI, RIVKA, ESTER;
	}
}
