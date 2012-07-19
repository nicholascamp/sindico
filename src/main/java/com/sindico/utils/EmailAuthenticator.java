/**
 * 
 */
package com.sindico.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailAuthenticator.
 * 
 * @author Lucas
 */
public class EmailAuthenticator extends Authenticator {

	/** The user. */
	private final String	user;

	/** The pw. */
	private final String	pw;

	/**
	 * Instantiates a new email authenticator.
	 * 
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 */
	public EmailAuthenticator(final String username, final String password) {
		super();
		this.user = username;
		this.pw = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.mail.Authenticator#getPasswordAuthentication()
	 */
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pw);
	}
}
