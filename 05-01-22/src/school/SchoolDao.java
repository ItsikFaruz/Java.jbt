package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolDao {
	
		
		String dbUrl = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true";
		String user = "root";
		String password = "1234";
		
		
		public void addSchool(School school) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password);){
			String sql = "insert into school values (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2, school.getName());
			stmt.setString(3, school.getAddress());
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("add student failed", e);
		}


		}
		
		public void printSchool() {
			try (Connection con = DriverManager.getConnection(dbUrl, user, password);) {
				String sql = "select *from school join student on student.school_id = school.id" ;
				PreparedStatement stmt = con.prepareStatement(sql);
				//stmt.setInt(1, i);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					int id = rs.getInt(1);	
					String name = rs.getString(2);
					String address = rs.getString(3);
				
					int student_id = rs.getInt(4);	
					String school_id = rs.getString(5);
					String student_name = rs.getString(6);
					String email = rs.getString(7);
					

					System.out.println("school id: " + id + "\tname: " + name + "\taddress: " + address +
							"\tstudent id: " +student_id + "\tscool id: " + school_id + "\tstudent name: "+student_name + "\temail: " + email);
					System.out.println("======================================================");
				}

			} catch (Exception e) {

			}

		}

		
		
		
	}
