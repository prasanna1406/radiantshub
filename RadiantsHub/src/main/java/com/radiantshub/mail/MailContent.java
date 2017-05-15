package com.radiantshub.mail;

import java.util.Map;

public class MailContent {

	private String subject;
	private String fileName;
	private Map<String, Object> replacingContent;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Map<String, Object> getReplacingContent() {
		return replacingContent;
	}
	public void setReplacingContent(Map<String, Object> replacingContent) {
		this.replacingContent = replacingContent;
	}
	@Override
	public String toString() {
		return "MailContent [subject=" + subject + ", fileName=" + fileName + ", replacingContent=" + replacingContent
				+ "]";
	}
	
	
	
}
