package coupon.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import coupon.core.beans.Coupon;
import coupon.core.exception.CouponSystemException;

public class CouponDaoDb implements CouponDao {

	@Override
	public int addCoupon(Coupon coupon) throws CouponSystemException {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "insert into coupon values (0 , 0 ,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, coupon.getCategory());
			pstmt.setString(2, coupon.getTitle());
			pstmt.setString(3, coupon.getDescription());
			pstmt.setDate(4, coupon.getStartDate.());
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
				
		
		
		return 0;
	}

	@Override
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCoupon(int couponId) throws CouponSystemException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Coupon> getAllCoupon() throws CouponSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getOneCoupon(int couponId) throws CouponSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCouponPurchase(int customerId, int couponId) throws CouponSystemException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException {
		// TODO Auto-generated method stub

	}

}
