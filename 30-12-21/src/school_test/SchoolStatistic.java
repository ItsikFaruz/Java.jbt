package school_test;

import school_test.Grade.gradeProfession;
import school_test.Person.names;
import school_test.Teacher.profession;

public class SchoolStatistic {

	private static int classroomNumber = 1;

	public static void main(String[] args) {

		School school = getSchool();
		printSchool(school);

	}

	private static void printSchool(School school) {
		System.out.println(school.getClassrom()[0]);

	}

	private static School getSchool() {
		School school = new School();
		for (int i = 0; i < school.classrom.length; i++) {
			school.classrom[i] = getClassRoom();
		}
		return school;
	}

	private static ClassRoom getClassRoom() {
		ClassRoom classroom = new ClassRoom(setName(), setTeacher(), setStudents());

		return classroom;
	}

	private static Student[] setStudents() {

		Student[] students = new Student[15];
		for (int i = 0; i < students.length; i++) {
			names name = names.values()[(int) (Math.random() * names.values().length)];
			int age = (int) (Math.random() * (Person.MAX_AGE - Person.MIN_AGE + 1) + Person.MIN_AGE);
			students[i] = new Student(name, age, getRandomGrades());
		}

		return students;
	}

	private static Grade[] getRandomGrades() {
		Grade[] grades = new Grade[6];
		for (int i = 0; i < grades.length; i++) {
			int grade = (int) (Math.random() * (Grade.MAX_SCORE - Grade.MIN_SCORE + 1)) + Grade.MIN_SCORE;
			gradeProfession pro = gradeProfession.values()[i];
			grades[i] = new Grade(pro, grade);
		}

		return grades;
	}

	private static Teacher setTeacher() {
		profession pro = profession.values()[(int) (Math.random() * profession.values().length)];
		names name = names.values()[(int) (Math.random() * names.values().length)];
		int age = (int) (Math.random() * (Person.MAX_AGE - Person.MIN_AGE + 1) + Person.MIN_AGE);
		Teacher teacher = new Teacher(name, age, pro);

		return teacher;
	}

	private static String setName() {
		classroomNumber++;
		return ("grade " + classroomNumber);
	}

}
