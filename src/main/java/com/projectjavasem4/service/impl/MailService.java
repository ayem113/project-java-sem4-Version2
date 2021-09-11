package com.projectjavasem4.service.impl;

import java.util.logging.Logger;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.projectjavasem4.service.IMailService;

@Service
public class MailService implements IMailService {
	@Autowired
	public JavaMailSender emailSender;

	SimpleMailMessage message = new SimpleMailMessage();

	@Override

	public boolean sendMailResetPass(String emailAddress, String otp) {
		try {

			/*
			 * message.setTo(emailAddress); message.setSubject("MA XAC MINH");
			 * message.setText(codeRamdom); this.emailSender.send(message);
			 */

			MimeMessage message = emailSender.createMimeMessage();              
		    MimeMessageHelper helper = new MimeMessageHelper(message,  "utf-8");

		    helper.setTo(emailAddress);
		     
		    String subject = "Đây là mã dùng một lần (OTP) của bạn - Hết hạn sau 5 phút!";

		    String content = "<p> Xin chào </p>"
		    + "<p> Vì lý do bảo mật, bạn bắt buộc phải sử dụng phần sau"
		    + "Mật khẩu dùng một lần để đăng nhập: </p>"
		    + "<h4> <b>" + otp + "</b> </h4>"
		    + "<br>"
		    + "<p> Lưu ý: OTP này sẽ hết hạn sau 5 phút. </p>";
		     
		    helper.setSubject(subject);
		     
		    helper.setText(content, true);
		     
		    emailSender.send(message);      
			
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
