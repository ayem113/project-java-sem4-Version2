package com.projectjavasem4.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.service.CartService;

@Controller
public class CartController {

	@Autowired CartService cartSer;
	
	@ResponseBody
	@RequestMapping(value = "/cart/getInfo", method = RequestMethod.GET)
	public Object[] getInfo() {
		
		
		Object[]  result= {cartSer.getTotalItems()  ,cartSer.getTotalPrice() };
		return result;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cart/add2/{id}", method = RequestMethod.GET)
	public String addCart2(@PathVariable long id) {
		
		return cartSer.add2(id) ? " " : "Sản phẩm đã tồn tại trong giỏ hàng";
		
		
	}
	
	
	@RequestMapping(value = "/gio-hang/danh-sach", method = RequestMethod.GET)
	public ModelAndView listCart() {
		return new ModelAndView("web/cart");
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cart/clear", method = RequestMethod.GET)
	public void clear() {

		cartSer.clear();
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cart/remove/{id}", method = RequestMethod.GET)
	public Object[] remove( @PathVariable("id") long id ) {

		cartSer.remove(id);
		Object[]  result= {cartSer.getTotalItems()  ,cartSer.getTotalPrice() };
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/cart/update/{id}/{quantity}", method = RequestMethod.GET)
	public Object[] update( @PathVariable("id") long id ,@PathVariable("quantity") int quantity ) {

		cartSer.eidt(id, quantity);
		
		Object[]  result= {cartSer.getTotalItems()  ,cartSer.getTotalPrice() };
		return result;
		
	}
	
	
}
