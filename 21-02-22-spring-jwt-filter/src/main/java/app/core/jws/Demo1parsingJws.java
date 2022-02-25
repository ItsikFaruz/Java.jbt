package app.core.jws;



import java.security.Key;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo1parsingJws {

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
		
		//==========================
		//get a token
		String jws = "eyJhbGciOiJub25lIn0.eyJzdWIiOiJhYWFAbWFpbC5jb20iLCJpYXQiOjE2NDUxNzg0MDksImV4cCI6MTY0NTE3ODcwOSwiQ2xpZW50LXR5cGUiOiJDb21wYW55IiwiYWRkcmVzcyI6IkplcnVzYWxlbSAsIElzcmFlbCJ9.";
		// get a parser
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		// parse the token and get the parsed JWT
		Jws<Claims> jwt = jwtParser.parseClaimsJws(jws);
		
		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());
		System.out.println(jwt.getSignature());
		
		
		
	}

}
