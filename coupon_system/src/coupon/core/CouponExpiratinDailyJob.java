package coupon.core;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import coupon.core.beans.Coupon;
import coupon.core.dao.CouponDao;
import coupon.core.dao.CouponDaoDb;
import coupon.core.exception.CouponSystemException;

public class CouponExpiratinDailyJob implements Runnable {

	private CouponDao couponDao = new CouponDaoDb();
	private boolean quit;
	private Thread thread = new Thread(this, "CouponExpiratinDailyJob");
	

	public Thread getThread() {
		return thread;
	}


	public boolean isQuit() {
		return quit;
	}


	public void setQuit(boolean quit) {
		this.quit = quit;
	}


	@Override
	public void run() {
		while (!quit) {
			try {
				for (Coupon coupon : this.couponDao.getAllCoupon()) {
					if (coupon.getEndDate().isBefore(LocalDate.now())) {
						couponDao.deleteCouponPurchases(coupon.getId());
						couponDao.deleteCoupon(coupon.getId());
					}
				}
				TimeUnit.DAYS.sleep(1);
			
			} catch (CouponSystemException e) {
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}	
		}
	}

	
	public void startDailyJob() {
		this.quit = false;
		this.thread.start();
		System.out.println("daily job started");
		
	}
	public void stopDailyJob() {
		this.quit = true;
		this.thread.interrupt();
		System.out.println("daily stoped");
	}
	
	
}