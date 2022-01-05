package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public  class CreateTableSchool {



		public static void createTable() {
		String dbUrl = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true";
		String user = "root";
		String password ="1234";
		
		String sql = "create table school (id int primary key auto_increment , name varchar(25), address varchar(25));";
		
		try(Connection con = DriverManager.getConnection(dbUrl, user, password);) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("table created");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("ended");
		
		
	}

}
