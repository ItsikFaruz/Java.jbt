package school_test;

import java.util.Arrays;

public class ClassRoom {

	private String name;
	private Teacher teacher;
	private Student[] students = new Student[15];

	public ClassRoom() {
	}

	public ClassRoom(String name, Teacher teacher, Student[] students) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.students = students;
	}

	@Override
	public String toString() {
		return "ClassRoom = " + name + ", teacher= " + teacher + "\nstudents = " + Arrays.toString(students);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

}
