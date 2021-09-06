package com.projectjavasem4.service;


import java.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

	@Autowired HttpServletResponse response ;
	@Autowired HttpServletRequest request;
	
	public Cookie create(String name, String value, int day) {
		String valueEncode= Base64.getEncoder().encodeToString(value.getBytes());
		Cookie c= new Cookie(name, valueEncode);
		c.setMaxAge(24*60*60*day);
		c.setPath("/");
		response.addCookie(c);
		
		return c;

	}
	public Cookie read(String name) {
		Cookie[] c=request.getCookies();
		if (c!=null) {
		    for (Cookie cookie : c) {
				if (cookie.getName().equals(name)){
					
					String valueDecode =new String( Base64.getDecoder().decode(cookie.getValue()));
					cookie.setValue(valueDecode);
					
					return cookie;
					
				}
			}
		}
		return null;

	}
	public void delete(String name) {
	
		 this.create(name, "", 0);

	}
}
