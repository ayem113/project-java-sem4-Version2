package com.projectjavasem4.service.impl;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.logging.Logger;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.projectjavasem4.entities.ProductDetailEntity;
import com.projectjavasem4.repository.ProductDetailRepository;
import com.projectjavasem4.service.CartService2;
import com.projectjavasem4.service.IMailService;

@Service
public class MailService implements IMailService {
	@Autowired public JavaMailSender emailSender;
	@Autowired static CartService2 cartService;
	@Autowired static ProductDetailRepository proDetailRep;
	SimpleMailMessage message = new SimpleMailMessage();
	static DecimalFormat decimalFormat = new DecimalFormat("###,###");
	
	@Override
	public boolean sendMailResetPass(String emailAddress, String otp) {
		try {
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
	public boolean sendMailAfterOrder(HttpSession session,String emailAddress, String nameUser, String code,String totalPrice,Collection<ProductDetailEntity> list) {
		try {
			MimeMessage message = emailSender.createMimeMessage();    
	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");  
	        String sms="<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n"
	        		+ "    <head>\r\n"
	        		+ "        <meta charset=\"utf-8\"> \r\n"	        		
	        		+ "        <meta name=\"viewport\" content=\"width=device-width\"> <!-- Forcing initial-scale shouldn't be necessary -->\r\n"
	        		+ "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <!-- Use the latest (edge) version of IE rendering engine -->\r\n"
	        		+ "        <meta name=\"x-apple-disable-message-reformatting\">  <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n"
	        		+ "        <title></title> <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n"
	        		+ "    \r\n"  
	        		+ "        <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700\" rel=\"stylesheet\">\r\n"
	        		+ "    \r\n"
	        		+ "        <!-- CSS Reset : BEGIN -->\r\n"	        		
					+ " <style> #t01 { border: 1px solid black;  border-collapse: collapse;width: 100%;     background-color: #f1f1c1;}</style>\r\n"	        		
	        		+ "     </head>\r\n"
	        		+ "    \r\n"
	        		+ "    <body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly;\">\r\n"
	        		+ "    <center style=\"width: 100%; \">\r\n"
	        		+ "        <div style=\"display: none; font-size: 1px;max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: sans-serif;\">\r\n"
	        		+ "            &zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;\r\n"
	        		+ "        </div>\r\n"
	        		+ "        <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n"
	        		+ "            <!-- BEGIN BODY -->\r\n"
	        		+ "            <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n"
	        		+ "                <tr>\r\n"
	        		+ "                    <td valign=\"top\" class=\"bg_white\" style=\"padding: 1em 2.5em 0 2.5em;\">\r\n"
	        		+ "                        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
	        		+ "                            <tr>\r\n"
	        		+ "                                <td class=\"logo\" style=\"text-align: center;\">\r\n"
	        		+ "                                    <h1>FURGANSHOP</h1>\r\n"
	        		+ "                                </td>\r\n"
	        		+ "                            </tr>\r\n"
	        		+ "                        </table>\r\n"
	        		+ "                    </td>\r\n"
	        		+ "                </tr><!-- end tr -->\r\n"
	        		+ "                <tr>\r\n"
	        		+ "                    <td valign=\"middle\" class=\"hero bg_white\" style=\"padding: 2em 0 4em 0;\">\r\n"
	        		+ "                        <table>\r\n"
	        		+ "                            <tr>\r\n"
	        		+ "                                <td>\r\n"
	        		+ "                                    <div class=\"text\" style=\"padding: 0 2.5em; text-align: center;\">\r\n"
	        		+ "                                        <h2> Xin chào  " + nameUser + " Cám ơn bạn đã mua hàng! </h2>\r\n"                                  
	        		+ "                                        <h3> Chúng tôi đã nhận được đặt hàng của bạn và đã sẵn sàng để vận chuyển. Chúng tôi sẽ thông báo cho bạn khi đơn hàng được gửi đi..</h3>\r\n"                                              
	        		+ "                                    </div>\r\n"
	        		+ "                                </td>\r\n"
	        		+ "                            </tr>\r\n"
	        		+ "                            <tr>\r\n"
	        		+ "                                <td>\r\n"
	        		+ "                                    <div class=\"text\" style=\"padding: 0 2.5em; text-align: center;\">\r\n"
	        		+ "                                        <h3>Bạn có thể xem lại đơn hàng của bạn tại đây  : <a href=\"http://localhost:8080/tai-khoan/don-hang/\"+code+\"\">Xem đơn hàng</a></h3>\r\n"
	        		+ "                                        \r\n"
	        		+ "                                        <h3>Hoặc đến cửa hàng của chúng tôi tại đây  : <a href=\"http://localhost:8080/trang-chu?page=1&limit=10\">Cửa hàng</a></h3>\r\n"	
	        		+ "                                    </div>\r\n"
	        		+ "                                </td>\r\n"	
	        		+ "                        </table>\r\n"
	        		+ "                    </td>\r\n"
	        		+ "                </tr><!-- end tr -->\r\n"
	        		+ "                <!-- 1 Column Text + Button : END -->\r\n"
	        		+ "            </table>\r\n"
	      		+ " <h2>Thông tin đơn hàng</h2>\r\n" 
						+ "<table id=\"t01\" >\r\n" + " "+ "<tr>\r\n" 		
						+ " <th>Tên</th>\r\n" 
						+ " <th>Số lượng</th>\r\n" 
						+ " <th>Giá</th>\r\n" 
						+ " </tr>\r\n" ; 
	        for (ProductDetailEntity entry : list) {   	
	        	sms=sms+"<tr align='center'>" 
	        + "<td>" + entry.getProduct().getName() + "</td>"
	        + "<td>" + entry.getQuantity_order()	+ "</td>" 
	        + "<td>" +   decimalFormat.format( (entry.getProduct().getPrice() * entry.getQuantity_order() * ((100 - entry.getProduct().getDiscount()))) / 100) 		+ " &nbsp;₫</td>";    }; 
	        sms=sms+ "</tr>" +"</table>" ;        
	        sms=sms+ "<h3 style=\"text-align: right \" > Tổng tiền "+ totalPrice +" VND </h3>\r\n" + " "       	        		
			+ " <div class=\"text\" style=\"padding: 0 2.5em; text-align: center;\">\r\n" + " "
					+ "<h3>Nếu bạn có bất cứ câu hỏi nào, đừng ngần ngại liên lạc với chúng tôi tại \" rey31192@gmail.com \"</h3>\r\n" + " "
					+ "<h3>Cản ơn bạn rất nhiều.. và mong sẽ sớm gặp lại bạn!! \"</h3> <br> \r\n" + " </div> <br>\r\n"        		
	        		+ "</center>\r\n" 
	        		+ " </body>\r\n" 
	        		+ " </html>";     
	        message.setContent(sms, "text/html; charset=UTF-8");   
	        helper.addInline("rightSideImage",new File("C:/images/java-logo.png"));  
	        helper.setTo(emailAddress);    
	        helper.setSubject("Thông báo xác nhận đơn hàng #"+code);
	        this.emailSender.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
			return false;
		}
	}
}
