package com.projectjavasem4.service;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import com.projectjavasem4.entities.ProductDetailEntity;
public interface IMailService {

	boolean sendMailResetPass(String emailAddress,String otp);
	boolean sendMailAfterOrder(HttpSession session,String emailAddress,String nameUser,String code,String totalPrice,Collection<ProductDetailEntity> list);

}
