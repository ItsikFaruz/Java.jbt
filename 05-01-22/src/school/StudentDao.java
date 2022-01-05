package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

	String dbUrl = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true";
	String user = "root";
	String password = "1234";

	public void addStudent(Student student) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password);) {
			String sql = "insert into student values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setInt(2, student.getSchool_id());
			stmt.setString(3, student.getName());
			stmt.setString(4, student.getEmail());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("add student failed", e);
		}

	}

	/*public void printStudent(int i) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password);) {
			String sql = "select *from school join student on student.school_id = school.id";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, i);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int school_id = rs.getInt(2);
				String name = rs.getString(3);
				String email = rs.getString(4);

				System.out.println("id: " + id + "\tschool_id: " + school_id + "\tname: " + name + "\temail: " + email);
			}

		} catch (Exception e) {

		}

	}
*/
}
