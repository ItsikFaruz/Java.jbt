package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTableProduct {

	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true";
		String user = "root";
		String password = "1234";
		
		String sql = "create table product (id int primary key auto_increment , name varchar(25) ,price float)";
		
		try (Connection con = DriverManager.getConnection(dbUrl,user,password);){
			System.out.println("connection");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("disconected");
		
	}

}

