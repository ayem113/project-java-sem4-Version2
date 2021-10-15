package com.projectjavasem4.controller.web;
import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.projectjavasem4.service.WishlistService;
@Controller
public class WishlistController {
	@Autowired private WishlistService WlSer;	
	@ResponseBody
	@RequestMapping(value = "/wishlist/add/{id}", method = RequestMethod.GET)
	public String addToWishlist(@PathVariable long id) {
		try {
			String idReq=String.valueOf(id);
			Cookie c= WlSer.read("Wishlist");  //doc cooke
			String value=idReq;  //  gán value mac định = id
			if (c!=null) {  //nếu đẫ tồn tại cooki rồi	 
				value=c.getValue();  //get value ra
				if (!value.contains(idReq)) {//kiểm tra value của nó xem đã tồn tại chưa	
					value+=","+ idReq; //nếu tồn tại thì cộng đồn vô 
				}
				else {
					return "false";
				}
			}
			c=WlSer.create("Wishlist", value, 15);
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}
	
}
