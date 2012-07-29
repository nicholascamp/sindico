/**
 * 
 */
package com.sindico.service.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import com.sindico.service.EmailService;
import com.sindico.utils.EmailAuthenticator;

/**
 * @author Lucas
 * 
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {

	/** The protocol. */
	@Autowired
	@Qualifier("protocol")
	private String		protocol;

	/** The starttls. */
	@Autowired
	@Qualifier("starttls")
	private String		starttls;

	/** The host. */
	@Autowired
	@Qualifier("host")
	private String		host;

	/** The port. */
	@Autowired
	@Qualifier("port")
	private String		port;

	/** The auth. */
	@Autowired
	@Qualifier("auth")
	private String		auth;

	/** The email. */
	@Autowired
	@Qualifier("user")
	private String		email;

	/** The password. */
	@Autowired
	@Qualifier("password")
	private String		password;

	private Properties	properties;

	private Session		session;

	private MimeMessage	message;

	private void initialize() {
		properties = new Properties();

		properties.setProperty("mail.transport.protocol", protocol);
		properties.setProperty("mail.smtp.starttls.enable", starttls);
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", port);
		properties.setProperty("mail.smtp.auth", auth);
		properties.setProperty("mail.smtp.user", email);

		session = Session.getDefaultInstance(properties,
				new EmailAuthenticator(email, password));

		message = new MimeMessage(session);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.org.sesc.portal.service.EmailService#enviarEmail(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void emailCadastro(final String mensagem, final String destinatario) {
		enviarEmail(mensagem, "Bem-vindo ao Sindico.com", destinatario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.EmailService#emailPedidoCotacao(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void emailPedidoCotacao(final String mensagem,
			final String destinatario) {

		enviarEmail(
				mensagem,
				"Pedido de cotação - Sindico.com "
						+ new DateFormatter("dd/mm/yyyy").print(new Date(),
								LocaleContextHolder.getLocale()), destinatario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.EmailService#emailRespostaCotacao(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void emailRespostaCotacao(final String mensagem,
			final String destinatario) {

		enviarEmail(
				mensagem,
				"Resposta de cotação - Sindico.com "
						+ new DateFormatter("dd/mm/yyyy").print(new Date(),
								LocaleContextHolder.getLocale()), destinatario);

	}

	private void enviarEmail(final String mensagem, final String titulo,
			final String destinatario) {
		initialize();

		try {
			message.setFrom(new InternetAddress(email));

			// Destinatário
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					destinatario));

			message.setSubject(titulo);
			message.setText(mensagem);

			Transport t = session.getTransport(protocol);
			t.connect(email, password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
