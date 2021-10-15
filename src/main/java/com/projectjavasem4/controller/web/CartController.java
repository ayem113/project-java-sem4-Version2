package com.projectjavasem4.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.service.CartService2;

@Controller
public class CartController {

	@Autowired CartService2 cartSer;
	
	@ResponseBody
	@RequestMapping(value = "/cart/getInfo", method = RequestMethod.GET)
	public Object[] getInfo() {
		Object[]  result= {cartSer.getTotalItems()  ,cartSer.getTotalPrice() };
		return result;	
	}
	
	@ResponseBody
	@RequestMapping(value = "/cart/add", method = RequestMethod.GET)
	public String addCart2(@RequestParam int quantity,@RequestParam long idSize, @RequestParam long idColor,@RequestParam long idProduct) {
		return cartSer.add(quantity,idSize,idColor,idProduct) ? "true" : "false";	
	}

		
	@ResponseBody
	@RequestMapping(value = "/cart/getPriceByCheckboxChecked", method = RequestMethod.POST)
	public Object[] getPriceByCheckboxChecked(@RequestBody long[] ids) {
		 Object[]  result ={cartSer.getTotalItems()  , String.valueOf(cartSer.getPriceByCheckboxChecked(ids)) };  
		return result;
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
	@RequestMapping(value = "/cart/updateQuantity/{idProDetail}/{quantity}", method = RequestMethod.GET)
	public Object[] updateQuantity( @PathVariable("idProDetail") long idProDetail ,@PathVariable("quantity") int quantity ) {
		cartSer.updateQuantity(idProDetail, quantity);
		Object[]  result= {cartSer.getTotalItems()  ,cartSer.getTotalPrice() };
		return result;
	}	
	
	@ResponseBody
	@RequestMapping(value = "/cart/updateAttribute", method = RequestMethod.GET)
	public Object[] updateAttribute(@RequestParam long idProDetail, @RequestParam long idSize, @RequestParam long idColor) {
		cartSer.updateAttribute(idProDetail, idSize,idColor);
		Object[]  result= {cartSer.getTotalItems()  ,cartSer.getTotalPrice() };
		return result;
	}	
	
	
}
