package com.radiantshub.configurations;

import java.util.Properties;

import org.springframework.config.java.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/*@Configuration
@ComponentScan(basePackages = "com.radiantshub.*")*/
public class MailConfiguration {

	/*@Bean
	public JavaMailSender getGmailSetting(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("smtp.gmail.com");
		Properties mailProperties = new Properties();
		mailProperties.put("mail.transport.protocol", "smtp");
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.debug", true);
		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setUsername("developer3@perennialsys.com");
		mailSender.setPassword("developer@321");
		mailSender.setPort(587);
		
		return mailSender;
	}*/
	
}
