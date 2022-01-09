package coupon.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coupon.core.beans.Company;
import coupon.core.exception.CouponSystemException;

public class CompanyDaoDb implements CompanyDao {

	@Override
	public int addCompany(Company company) throws CouponSystemException {
		// 1. get a connection from pool
		Connection con = ConnectionPool.getInstance().getConnection();

		// 2. define the sql command as string with ? place holders
		String sql = " insert into company values(0,?,?,?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			// 4. set the ? to real values from the company parameter
			pstmt.setString(1, company.getName());
			pstmt.setString(1, company.getEmail());
			pstmt.setString(1, company.getPassword());

			// 5. execute
			pstmt.executeUpdate();

			// 6. get the generated id from the DB
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int id = rsId.getInt(1);
			company.setId(id);
			// 7. return the id
			return id;

			// handle any possible exception
		} catch (SQLException e) {
			throw new CouponSystemException("add company failed", e);
			//

		} finally {// finally block will run before the return above
			// 8. finally - return the connection pool
			ConnectionPool.getInstance().restoreConnection(con);

		}

	}

	@Override
	public boolean isCompanyExist(String email, String password) throws CouponSystemException {
		
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from company where email=? and password=? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, email);
			pstmt.setString(1, password);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			throw new CouponSystemException("isCompanyExist faild" , e );
		}finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		
		
	}

	@Override
	public void updateCompany(Company company) throws CouponSystemException {

		
	}

	@Override
	public void deleteCompany(int companyID) throws CouponSystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getOneCompany(int companyID) {
		// TODO Auto-generated method stub
		return null;
	}

}
