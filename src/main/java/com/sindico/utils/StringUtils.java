/**
 * 
 */
package com.sindico.utils;

import java.security.MessageDigest;

/**
 * @author Lucas
 * 
 */
public class StringUtils {

	public static String encodePassword(final String password) throws Exception {

		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (Exception e) {
			System.err.println(e.toString());
			throw e;
		}
	}

}
