/**
 * 
 */
package com.sindico.utils;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * @author Lucas
 * 
 */
public class StringUtils {

	public static String encodePassword(final String password, final String salt)
			throws Exception {

		ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
		shaPasswordEncoder.setIterations(1024);
		return shaPasswordEncoder.encodePassword(password, salt);
	}

}
