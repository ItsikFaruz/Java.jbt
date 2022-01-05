package school;

public class Test {

	public static void main(String[] args) {

		CreateTableSchool.createTable();
		createStudentTable.createTable();

		StudentDao studentDao = new StudentDao();
		SchoolDao schoolDao = new SchoolDao();

		try {

			for (int i = 1; i <= 3; i++) {
				School school = new School(i, "school-" + i, "city " + i);
				schoolDao.addSchool(school);

				for (int j = 1; j <= 10; j++) {
					Student student = new Student(i, "student-" + j, "@-" + j);
					studentDao.addStudent(student);
				}
			}

			} catch (Exception e) {
		}

	}

}
