package com.siml.shop.Conn;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class MailSenderTest {
	private static final Logger logger = LoggerFactory.getLogger(MailSenderTest.class);
	
    @Inject
    protected JavaMailSender mailSender;

    @Test
    public void SendId() {
        MimeMessage msg = mailSender.createMimeMessage();
        String subject = "테스트";
        String text = "테스트";
        String email = "swh1182@naver.com";
        try {
            msg.setSubject(subject);
            msg.setText(text);
            msg.setRecipient(RecipientType.TO, new InternetAddress(email));
            mailSender.send(msg);
            logger.info("MailSender Success");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
