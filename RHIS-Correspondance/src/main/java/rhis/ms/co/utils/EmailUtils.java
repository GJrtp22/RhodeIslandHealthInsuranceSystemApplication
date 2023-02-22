package rhis.ms.co.utils;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String email, String subject, String body, File file) throws Exception {
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		 
		helper.setSubject(subject);
		helper.setFrom("govardhan.jrtp@gmail.com");
		helper.setTo(email);
		 
		helper.setText(body, true);
		 
		
		helper.addAttachment("EligibilityDetails.pdf", file);
		 
		mailSender.send(message);

	}

}
