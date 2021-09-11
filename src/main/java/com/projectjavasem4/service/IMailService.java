package com.projectjavasem4.service;

public interface IMailService {

	boolean sendMailResetPass(String emailAddress,String otp);
	boolean sendMailAfterOrder(String emailAddress,String subject,String content);
	
}
