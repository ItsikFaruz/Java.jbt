package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true";
	private String user = "root";
	private String password = "1234";

	public void save(Product product) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password);) {
			String sql = "insert into product values(?, ? , ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setString(2, product.getName());
			pstmt.setFloat(3, product.getPrice());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("save product failed", e);
		}

	}

	public void delete(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from product where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("delete producr: " + id + " failsed - not found");
			}

		} catch (SQLException e) {
			throw new RuntimeException("delete: " + id + "faild " + e);

		}

	}

	public void print() {

		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select *from product;";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				System.out.println("id: " + id + "\tname: " + name + "\tprice: " + price);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
