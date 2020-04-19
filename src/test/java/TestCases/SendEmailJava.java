package TestCases;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmailJava {

		
		
	public static void SendEmail() throws EmailException {
		Email email = new SimpleEmail();
		
		email.setHostName("smtp.gmail.com"); //****Commons Email aims to provide a API for sending email. It is built on top of the Java Mail API, which it aims to simplify.
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("prabhjotsinghdhanjal@gmail.com", "jho5h9345"));
		email.setSSLOnConnect(true);
		email.setFrom("prabhjotsinghdhanjal@gmail.com");
		email.setSubject("SeleniumTestReport");
		email.setMsg("This is a test mail from Selenium ... :-)");
		email.addTo("gitikadhanjal@gmail.com");
		email.send();
	}

}
