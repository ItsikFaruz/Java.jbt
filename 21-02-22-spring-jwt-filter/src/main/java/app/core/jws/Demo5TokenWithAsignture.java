package app.core.jws;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo5TokenWithAsignture {

	public static void main(String[] args) {

		// 1. set the secret
		String secretKey = "aaaaaaaaa1aaaaaaaaa2aaaaaaaaa3aaaaaaaaa4aaa";
		// 2. decode the base-64
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKey.getBytes());
		// 3. choose algorithm
		String algotithm = SignatureAlgorithm.HS256.getJcaName();
		System.out.println(algotithm);
		// 4. create the kye
		Key key = new SecretKeySpec(secretKeyDecoded, algotithm);

		Instant now = Instant.now();
		Instant expiration = now.plus(5, ChronoUnit.MINUTES);

		Date d1 = Date.from(now);
		Date d2 = Date.from(expiration);

		System.out.println(d1);
		System.out.println(d2);

		String jws = Jwts.builder().setSubject("aaa@mail.com")
				
				.signWith(key)

				.setIssuedAt(Date.from(now))

				.setExpiration(Date.from(expiration))

				.claim("Client-type", "Company")

				.claim("address", "Jerusalem , Israel")

				.compact();
		System.out.println(jws);

	}

}
