package app.core.jws;



import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import io.jsonwebtoken.Jwts;

public class Demo1 {

	public static void main(String[] args) {
	Instant now = Instant.now();
	Instant expiration = now.plus(5, ChronoUnit.MINUTES);
	
	Date d1 =Date.from(now);
	Date d2 =Date.from(expiration);
	
	System.out.println(d1);
	System.out.println(d2);
	
	
		String jws =  Jwts.builder()
				.setSubject("aaa@mail.com")
				
				.setIssuedAt(Date.from(now))
				
				.setExpiration(Date.from(expiration))
				
				.claim("Client-type", "Company")
				
				.claim("address", "Jerusalem , Israel")
			
				.compact();
		System.out.println(jws);
		
	}

}
