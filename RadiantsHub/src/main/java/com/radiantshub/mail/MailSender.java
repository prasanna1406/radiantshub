package com.radiantshub.mail;

import java.io.File;
import java.util.Arrays;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.radiantshub.logger.RadiantsLogger;
import com.radiantshub.util.StringUtil;

public class MailSender implements Runnable {

	
	private JavaMailSenderImpl mailSender;

	Logger logger = RadiantsLogger.getLogger(MailSender.class);

	/** The to. */
	private String to;

	 /** The subject. */
	private String subject;

	   /** The bcc. */
	private String[] bcc;

	    /** The cc. */
	private String[] cc;

	     /** The body. */
	private String body;

	      /** The attachments. */
	private File[] attachments;
	
	
	public MailSender(JavaMailSenderImpl mailSender, String to, String subject, String[] bcc, String[] cc, String body, File[] attachments) {
			super();
			this.to = to;
			this.subject = subject;
			this.bcc = bcc;
			this.cc = cc;
			this.body = body;
			this.attachments = attachments;
			this.mailSender = mailSender;
		}

	@Override
	public void run() {
		MimeMessage mime = this.mailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		
		try {
			helper = new MimeMessageHelper(mime, true);
			helper.setTo(to);
			helper.setFrom(mailSender.getUsername());
			helper.setSubject(subject);
			helper.setText(body,true);

			if(!StringUtil.isNull(cc)){
				helper.setCc(cc);
			}
			if(!StringUtil.isNull(bcc)){
				helper.setBcc(bcc);
			}

			if(!StringUtil.isNull(attachments)){
				for(File file : attachments){
					if(file==null){
						break;
					}
					FileSystemResource fileSystemResource = new FileSystemResource(file);
					helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
				}
			}
				
			mailSender.send(mime);		
		} catch (Exception e) {
			logger.debug("" + e);
		}
	}

	@Override
	public String toString() {
		return "MailSender [to=" + to + ", subject=" + subject + ", bcc=" + Arrays.toString(bcc) + ", cc="
				+ Arrays.toString(cc) + ", body=" + body + ", attachments=" + Arrays.toString(attachments) + "]";
	}
	
	
}
