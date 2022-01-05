package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createStudentTable {

	public static void createTable() {

		String dbUrl = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true ";
		String user = "root"; 
		String paswword = "1234";
		
		String sql = "create table student(id int primary key auto_increment , school_id int , foreign key (school_id) references school(id),name varchar(25),email varchar(25));";                      
		try (Connection con = DriverManager.getConnection(dbUrl, user, paswword);){
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("table created");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("ended");
	}

}
