package com.projectjavasem4.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.dto.ProductDetailDTO;
import com.projectjavasem4.repository.CategoryRepository;
import com.projectjavasem4.repository.ColorRepository;
import com.projectjavasem4.repository.SizeRepository;
import com.projectjavasem4.service.ICategoryService;
import com.projectjavasem4.service.IProductService;

@Controller(value = "ProControllerOfAdmin")
public class ProductController {
	@Autowired private IProductService proService;
	@Autowired private ICategoryService catService;
	@Autowired private CategoryRepository CateRep;
	@Autowired private SizeRepository sizeRep;
	@Autowired private ColorRepository colorRep;
	
	
	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
	public ModelAndView list(HttpSession session ) {
		ModelAndView m=new ModelAndView("admin/product/listPro");
		session.setAttribute("listCategory", CateRep.findAll());
		 m.addObject("listSize", sizeRep.findAll());
		 m.addObject("listColor", colorRep.findAll());
		 m.addObject("List", proService.getAll());
		 Map<String, String> findAll = catService.findAll();
		 m.addObject("categories", findAll);
		 m.addObject("model", new ProductDTO());
		 m.addObject("ProductDetaimodel", new ProductDetailDTO());
		 return m;
	}
}
