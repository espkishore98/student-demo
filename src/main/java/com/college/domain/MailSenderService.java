package com.college.domain;

public class MailSenderService {
	private String senderMailId;
	private String subject;
	private String message;
	public String getSenderMailId() {
		return senderMailId;
	}
	public void setSenderMailId(String senderMailId) {
		this.senderMailId = senderMailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MailSenderService(String senderMailId, String subject, String message) {
		super();
		this.senderMailId = senderMailId;
		this.subject = subject;
		this.message = message;
	}
	public MailSenderService() {
		super();
	}
	@Override
	public String toString() {
		return "MailSenderService [senderMailId=" + senderMailId + ", subject=" + subject + ", message=" + message
				+ "]";
	}

	
	
	
	

}
