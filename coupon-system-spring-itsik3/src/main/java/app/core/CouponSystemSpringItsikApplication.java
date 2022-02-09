package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import app.core.exception.CouponSystemException;

@EnableScheduling
@SpringBootApplication
public class CouponSystemSpringItsikApplication {

	public static void main(String[] args) throws CouponSystemException {
    SpringApplication.run(CouponSystemSpringItsikApplication.class, args);

      
	}
}
