package com.projectjavasem4.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.service.IUserService;

@Controller(value = "UserControllerOfAdmin")
public class UserController {
	@Autowired
	private IUserService newService;
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/danh-sach", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("admin/user/listUser").addObject("List", newService.getAll());
	}
	
	
}
