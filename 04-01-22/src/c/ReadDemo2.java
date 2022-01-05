package c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ReadDemo2 {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/db1";
		String user = "root";
		String password = "1234";

		try {
			Connection con = DriverManager.getConnection(dbUrl, user, password);
			String sql = "select *from book";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

			int id = rs.getInt(1);

			int author_id = rs.getInt(2);
			String title = rs.getString(3);
			Date publication = rs.getDate(4);
			Double price = rs.getDouble(5);

			System.out.println("id: " + id + "\nauthor: " + author_id + "\ntitle: " + title + "\npublication: " + publication
					+ "\nprice " + price);
			System.out.println("============");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
