package com.radiantshub.mail;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.radiantshub.exceptions.RadiantsHubException;
import com.radiantshub.util.FileUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class MailHelper.
 */
public class MailHelper{

	public static void sendMail(String[] to, String[] bcc,
			String[] cc, File[] attachments, JavaMailSenderImpl mailSender, MailContent mailContent) throws RadiantsHubException{
		String body = new String();
		try{
			String subject = mailContent.getSubject();

			ExecutorService emailExecutor = Executors.newFixedThreadPool(5);
			for(String toSend : to){
				body = FileUtil.getBodyContent(mailContent.getFileName(), 
						mailContent.getReplacingContent());
				Runnable worker = new MailSender(mailSender, toSend, subject, bcc, cc, body, attachments);
				emailExecutor.execute(worker);
			}
			
			emailExecutor.shutdown();
		}
		catch(Exception e){
			throw new RadiantsHubException(e);
		}
	}
}
