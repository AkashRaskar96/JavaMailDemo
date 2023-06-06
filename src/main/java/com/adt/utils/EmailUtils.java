package com.adt.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String to, String subject, String body) {
		try{
			SimpleMailMessage msg=new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);
			
			javaMailSender.send(msg);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean sendEmailNew(String[] to, String subject, String body) {
		
		try{
			MimeMessage mimeMsg=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMsg);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);
			javaMailSender.send(mimeMsg);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
