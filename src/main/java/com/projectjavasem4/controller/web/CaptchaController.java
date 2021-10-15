package com.projectjavasem4.controller.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.util.CaptchaUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("captcha")
public class CaptchaController {
	public static final String FILE_TYPE = "jpeg";
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/getCapcha1",  method = RequestMethod.GET)
	public void getCapcha1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		int iTotalChars = 6;
		int iHeight = 40;
		int iWidth = 150;
		Font fntStyle1 = new Font("Arial", Font.BOLD, 30);
		Random randChars = new Random();
		String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);
		BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2dImage = (Graphics2D) biImage.getGraphics();
		int iCircle = 15;
		for (int i = 0; i < iCircle; i++) {
			g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
		}
		g2dImage.setFont(fntStyle1);
		for (int i = 0; i < iTotalChars; i++) {
			g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
			if (i % 2 == 0) {
				g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 24);
			} else {
				g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 35);
			}
		}
		OutputStream osImage = response.getOutputStream();
		ImageIO.write(biImage, "jpeg", osImage);
		g2dImage.dispose();
		HttpSession session = request.getSession();
		session.setAttribute("captcha_security", sImageCode);
	}
	
	
	
	@RequestMapping(value = "/getCapcha2",   method = RequestMethod.GET)
	public void getCapcha2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String captchaStr= CaptchaUtil.randomText1();
		try {
			int width=100;     	
			int height=40;

			BufferedImage cpimg =new BufferedImage(width,height,BufferedImage.OPAQUE);
			Graphics g = cpimg.createGraphics();
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.setColor(new Color(0,255,255));
			g.fillRect(0, 0, width, height);
			g.setColor(new Color(0,100,0));
			g.drawString(captchaStr,10,25);   

			request.getSession(true).setAttribute("CAPTCHA", captchaStr);
			OutputStream outputStream = response.getOutputStream();
			ImageIO.write(cpimg, FILE_TYPE, outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value = "/test-capcha", method = RequestMethod.GET)
	public ModelAndView tesstCapcha(Model model,HttpServletRequest request, HttpServletResponse response) {
		UserEntity login= new UserEntity();
		model.addAttribute("login", login);
		return new ModelAndView("web/capcha");
	}
	
	
	
	@RequestMapping(value = "/loginCapcha", method = RequestMethod.POST)
	public ModelAndView loginCapcha(@ModelAttribute("login") UserEntity login,BindingResult result,Model model,HttpSession session) {
		LOGGER.debug("--- In Login method ----");
		
		/*
		 * if (login.getUsername() == null || login.getUsername().equals("")){
		 * login.setCaptcha(""); mav.addObject("message", "User Id is required"); return
		 * mav; }
		 * 
		 * 
		 * if (login.getPassword() == null || login.getPassword().equals("")){
		 * login.setCaptcha(""); mav.addObject("message", "Password is required");
		 * return mav; }
		 * 
		 * if(login.getUsername().equals("test") &&
		 * login.getPassword().equals("test123")){
		 * System.out.println("user id and password matches"); mav.addObject("loginId",
		 * login.getUsername()); return mav; } else{ login.setCaptcha("");
		 * mav.addObject("message","User ID or Password Incorrect"); return mav; }
		 */

		String captcha = (String) session.getAttribute("CAPTCHA");
		if(captcha == null || (captcha != null && !captcha.equals(login.getCaptcha()))){
			/*
			 * login.setCaptcha(""); mav.addObject("message", "Captcha does not match");
			 * return mav;
			 */
			
			
			ModelAndView mm= new ModelAndView("web/capcha");
			mm.addObject("error","Captcha false");
			//return "account/index";
			return mm;
			
		}else {
			
			
			ModelAndView mm= new ModelAndView("web/capcha");
			mm.addObject("error","Captcha ok");
			//return "account/index";
			return mm;
		}
		
		
		
	}
	

}