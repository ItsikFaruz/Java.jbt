package coupon.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coupon.core.beans.Coupon;
import coupon.core.beans.Customer;
import coupon.core.beans.Coupon.Category;
import coupon.core.exception.CouponSystemException;

public class CustomerDaoDb implements CustomerDao {

	@Override
	public boolean isCustomerExists(String email, String password) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from customer where email=? and password=? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExists faild", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public int addCustomer(Customer customer) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "insert into customer values (0,?,?,?,?) ";
		try (PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());

			pstmt.executeUpdate();

			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int id = rsId.getInt(1);
			customer.setId(id);
			return id;

		} catch (SQLException e) {
			throw new CouponSystemException("addCustomer faild", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws CouponSystemException {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "update customer set first_name = ? , last_name=?, email = ? , password=? where id = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.setInt(5, customer.getId());

			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("updateCustomer failed - customer" + customer.getId() + " not found:");
			}

		} catch (SQLException e) {
			throw new CouponSystemException("updateCustomer faild", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public void deleteCustomer(int customerId) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from customer where id=? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == false) {
				throw new CouponSystemException("ERROR: the customer:" + customerId + " Id not exist");
			}
			String sql2 = "delete from customer where id = ? ";
			try (PreparedStatement pstmt2 = con.prepareStatement(sql2);) {
				pstmt2.setInt(1, customerId);
				pstmt2.executeUpdate();

			}
		} catch (SQLException e) {
			throw new CouponSystemException("delete company faild", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public Customer getOneCustomer(int customerId) throws CouponSystemException {

		Customer customer = new Customer();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from customer where id =?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("first_name"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
			//customer.setCoupons(getAllCouponOfCustomer(rs.getInt(1)));
				
				return customer;
			} else {
				throw new CouponSystemException("the customer: " + customerId + " is not exist");
			}
		} catch (SQLException e) {

			throw new CouponSystemException("getOneCompany faild", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public List<Customer> getAllCustomer() throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from customer";

		List<Customer> customers = new ArrayList<>();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("first_name"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setCoupons(getAllCouponOfCustomer(rs.getInt(1)));
				customers.add(customer);
			}

			return customers;

		} catch (SQLException e) {
			throw new CouponSystemException("getAllCustomer faild", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	public boolean isEmailCustomerExists(String email) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from customer where email=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			throw new CouponSystemException("isEmailCustomerExists faild", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	public boolean isCustomerIdChanged(int customerId) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from customer where id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExists faild", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	/**
	 * returns all coupons of customer by his name
	 *
	 */
	public List<Coupon> getAllCouponOfCustomer(int customerId) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from coupon where id in (select coupon_id from customer_coupon where customer_id = ?)";

		List<Coupon> coupons = new ArrayList<>();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setCompanyId(rs.getInt("company_id"));
				coupon.setCategory(Category.valueOf(rs.getString("category")));
				coupon.setTitle(rs.getString("title"));
				coupon.setDescription(rs.getString("description"));
				coupon.setStartDate(rs.getDate("start_date").toLocalDate());
				coupon.setEndDate(rs.getDate("end_date").toLocalDate());
				coupon.setAmount(rs.getInt("amount"));
				coupon.setPrice(rs.getDouble("price"));
				coupon.setImage(rs.getString("image"));
				coupons.add(coupon);

			}

			return coupons;

		} catch (SQLException e) {
			throw new CouponSystemException("getAllCoupon faild", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	public boolean checksCoupnPurchased(int customerId, int couponId) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from customer_coupuon where customer_id=? and coupon_id =? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExists faild", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}
	
	public boolean checkCouponPurchased(int customerId ,Coupon coupon) throws CouponSystemException {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select coupon_id from customer_coupon where customer_id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, customerId);	
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("coupon_id") == (coupon.getId())) {
				return true;
				}
			}	
				return false;
			
		} catch (SQLException e) {

			throw new CouponSystemException("checkCouponPurchased faild", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}
	
	public int getCustomerId(String email, String password) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select id from customer where email=? and password=? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			return id;

		} catch (SQLException e) {
			throw new CouponSystemException("getIdCustomer faild", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}
	
	public List<Coupon> getAllCouponOfCustomer(int customerId,  Category category ) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from coupon where category = ? and id in (select coupon_id from customer_coupon where customer_id = ?);";

		List<Coupon> coupons = new ArrayList<>();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, category.toString());
			pstmt.setInt(2, customerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setCompanyId(rs.getInt("company_id"));
				coupon.setCategory(Category.valueOf(rs.getString("category")));
				coupon.setTitle(rs.getString("title"));
				coupon.setDescription(rs.getString("description"));
				coupon.setStartDate(rs.getDate("start_date").toLocalDate());
				coupon.setEndDate(rs.getDate("end_date").toLocalDate());
				coupon.setAmount(rs.getInt("amount"));
				coupon.setPrice(rs.getDouble("price"));
				coupon.setImage(rs.getString("image"));
				coupons.add(coupon);

			}

			return coupons;

		} catch (SQLException e) {
			throw new CouponSystemException("getAllCoupon faild", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}
	
	public List<Coupon> getAllCouponOfCustomerBelwoMaxPrice(int customerId,  Double maxPrice ) throws CouponSystemException {

		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select *from coupon where price < ? and id in (select coupon_id from customer_coupon where customer_id = ?);";

		List<Coupon> coupons = new ArrayList<>();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setDouble(1, maxPrice);
			pstmt.setInt(2, customerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setCompanyId(rs.getInt("company_id"));
				coupon.setCategory(Category.valueOf(rs.getString("category")));
				coupon.setTitle(rs.getString("title"));
				coupon.setDescription(rs.getString("description"));
				coupon.setStartDate(rs.getDate("start_date").toLocalDate());
				coupon.setEndDate(rs.getDate("end_date").toLocalDate());
				coupon.setAmount(rs.getInt("amount"));
				coupon.setPrice(rs.getDouble("price"));
				coupon.setImage(rs.getString("image"));
				coupons.add(coupon);

			}

			return coupons;

		} catch (SQLException e) {
			throw new CouponSystemException("getAllCoupon faild", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}
	
	
	

	
}
