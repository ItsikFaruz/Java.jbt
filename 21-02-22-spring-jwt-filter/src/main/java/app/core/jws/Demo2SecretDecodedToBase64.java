package app.core.jws;

import java.util.Arrays;
import java.util.Base64;

public class Demo2SecretDecodedToBase64 {

	public static void main(String[] args) {
		
		String secretKey = "aaaaaaaaa1aaaaaaaaa2aaaaaaaaa3aaaaaaaaa4aaa";
		byte[] secretKyeEncoded = secretKey.getBytes();
		
		System.out.println(Arrays.toString(secretKyeEncoded));
		
		// we need an array of bytes in base-64
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKyeEncoded);
		System.out.println(Arrays.toString(secretKeyDecoded));
		System.out.println(secretKeyDecoded.length);
	}

}
