package app.core.dailyJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import app.core.servicies.AdminService;

@Component
public class CouponExpirationDailyJob {


	@Autowired
	AdminService adminService;

	
	
	/**
	 * The function checks every day at 12 at night which coupons have expired
	 *  and deletes them
	 */
	@Scheduled(cron = "1 0 0 * * * ")
	public void deleteExpiredCoupon() {
		System.out.println("daily job checks expirad coupon");
		adminService.deleteExpiredCoupon();
	}

}
