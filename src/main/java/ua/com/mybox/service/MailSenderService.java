package ua.com.mybox.service;

public interface MailSenderService {

	void sendMail(String context, String email, String mailBody);
	
}
