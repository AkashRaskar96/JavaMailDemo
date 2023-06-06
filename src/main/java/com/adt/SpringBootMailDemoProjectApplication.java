package com.adt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.adt.utils.EmailUtils;

@SpringBootApplication
public class SpringBootMailDemoProjectApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootMailDemoProjectApplication.class, args);
//	}
	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBootMailDemoProjectApplication.class, args);
		
		EmailUtils emailUtils = ctxt.getBean(EmailUtils.class);
		
		String to="Aakashmr14343@gmail.com";
		String subject="Testing";
		String body="From Spring Boot App";
//		boolean isSent=emailUtils.sendEmail(to, subject, body);
//		System.out.println("Email Sent ? :: "+isSent);
		
		String[] too={"Aakashmr14343@gmail.com",
					  "AkashRaskar.adt@gmail.com",
					  "akashraskar.adt@gmail.com"};
		boolean isSent=emailUtils.sendEmailNew(too, subject, body);
		System.out.println("Email Sent for Multiple Peoples ? :: "+isSent);
		
		
	}

}
