package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import app.core.dao.company.CompanyDao;
import app.core.dao.coupon.CouponDao;

public class App {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

			CompanyDao companyDao = ctx.getBean(CompanyDao.class);
			CouponDao couponDao = ctx.getBean(CouponDao.class);
			
			
			System.out.println(companyDao.getClass());
			System.out.println(couponDao.getClass());
			

			
			companyDao.addCompany(101, "COM");
			companyDao.sayHello();

			couponDao.addCoupon();
			couponDao.doWork();

			
		}
	}
}




