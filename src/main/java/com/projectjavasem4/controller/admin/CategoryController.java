package com.projectjavasem4.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.service.ICategoryService;

@Controller(value = "CatControllerOfAdmin")
public class CategoryController {
	@Autowired
	private ICategoryService newService;
	
	@RequestMapping(value = "/quan-tri/danh-muc/danh-sach", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("admin/category/listCategory").addObject("List", newService.getAll());
	}
	
	
}
