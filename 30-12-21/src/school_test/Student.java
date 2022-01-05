package school_test;

import java.util.Arrays;

public class Student extends Person {
	
	private Grade[] grades = new Grade[6];

	
	
	public Student() {
	}

	



	public Student(names name, int age, Grade[] grades) {
		super(name, age);
		this.grades = grades;
	}


	public Grade[] getGrades() {
		return grades;
	}

	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}





	@Override
	public String toString() {
		return super.toString() + "," + Arrays.toString(grades) + "\n";
	}
	
	
	
	
	

}
