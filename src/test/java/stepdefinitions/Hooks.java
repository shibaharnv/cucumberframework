package stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void startup() {
		System.out.println("Test execution started");
	}

	@Before
	public void teardown() {
		System.out.println("Email sent with execution report");
	}

	// @After
	public void Emailgenration() throws IOException {
		// TODO Will fail when password is changed or if it expires
		final String username = "myusername";
		final String password = "encryptpassword";

		Properties props = new Properties();
		String host = "test.com";
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.ssl.trust", "test");
		props.put("mail.smtp.port", "123");
		props.put("mail.smtp.starttls.required", "true");

		try {

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress("emailid@gmail.com"));

			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("emailid@gmail.com"));
			msg.setSubject("Cucumber API automation results");

			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("This is message body");

			// 4) create new MimeBodyPart object and set DataHandler object to this object
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			String filename = new StringBuilder(System.getProperty("user.dir")).append("\\").append("target")
					.append("\\").append("cucumber-html-reports").append("\\").append("overview-features.html")
					.toString();

			System.out.println("filename" + filename);

			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

			// 5) create Multipart object and add MimeBodyPart objects to this object
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);

			// 6) set the multiplart object to the message object
			msg.setContent(multipart);

			Transport.send(msg);

			System.out.println("Email sent with report");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}

	}

}
