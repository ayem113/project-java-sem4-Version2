package com.projectjavasem4.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.projectjavasem4.service.IMailService;

@Service
public class MailService implements IMailService {
	@Autowired
	public JavaMailSender emailSender;

	SimpleMailMessage message = new SimpleMailMessage();

	@Override

	public boolean sendMailResetPass(String emailAddress, String codeRamdom) {
		try {

			message.setTo(emailAddress);
			message.setSubject("MA XAC MINH");
			message.setText(codeRamdom);
			this.emailSender.send(message);

			return true;
		} catch (Exception e) {
			Logger.getLogger(e.getMessage());
			e.printStackTrace();
			System.out.println(e.getMessage().toString());

			return false;
		}
	}

	@Override
	public boolean sendMailAfterOrder(String emailAddress, String subject, String content) {
		try {

			return true;
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage().toString());

			return false;
		}
	}

}
