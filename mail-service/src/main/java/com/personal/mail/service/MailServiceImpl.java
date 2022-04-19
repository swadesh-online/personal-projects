package com.personal.mail.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

	public ResponseEntity<String> send() {  
		Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("swadesbehera@gmail.com", "?????");
		      }
		   });
		   Message msg = new MimeMessage(session);
		try {
		   msg.setFrom(new InternetAddress("swadesbehera@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("swadeshbehera@gmail.com"));
		   msg.setSubject("My email");
		   msg.setContent("Content email", "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("cool email", "text/html");

		  		   Transport.send(msg);   

		}catch(MessagingException me) {
		
			return new ResponseEntity<String>(me.getMessage(), HttpStatus.BAD_REQUEST);
		
		}
		
		return new ResponseEntity<>("The message is sent!", HttpStatus.OK);
		}
}
