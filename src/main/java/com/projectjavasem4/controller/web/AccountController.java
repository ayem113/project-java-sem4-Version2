package com.projectjavasem4.controller.web;

import com.projectjavasem4.entities.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("account")
public class AccountController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("account", new UserEntity());
		return "account/index";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("account") UserEntity account, HttpSession session, HttpServletRequest request,ModelMap modelMap) {	
		String captcha = session.getAttribute("captcha_security").toString();
		String verifyCaptcha = request.getParameter("captcha");
		if (captcha.equals(verifyCaptcha)) {
			ModelAndView mm= new ModelAndView("account/success");
			modelMap.put("account", account);
			//return "account/success";
			return mm;
		} else {
			ModelAndView mm= new ModelAndView("account/index");
			modelMap.put("error", "Captcha Invalid");
			mm.addObject("error2","Captcha Invalid2");
			//return "account/index";
			return mm;
		}
		
	}

}