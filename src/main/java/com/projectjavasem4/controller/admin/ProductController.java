package com.projectjavasem4.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.service.ICategoryService;
import com.projectjavasem4.service.IProductService;

@Controller(value = "ProControllerOfAdmin")
public class ProductController {
	@Autowired
	private IProductService proService;
	@Autowired
	private ICategoryService catService;
	
	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("admin/product/listPro").addObject("List", proService.getAll());
	}
	
	
	@RequestMapping(value = "/quan-tri/san-pham/them-hoac-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "Id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/product/addOrEdit");
		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = proService.findById(id);
		}
		
		Map<String, String> findAll = catService.findAll();
		mav.addObject("categories", findAll);
		mav.addObject("model", model);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "/quan-tri/san-pham/quan-tri/san-pham/testUpload", method = RequestMethod.POST)
	public ModelAndView editNew22(@ModelAttribute(name = "model") ProductDTO mo,  @RequestParam(value = "Id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/product/addOrEdit");
		
		CommonsMultipartFile fileUpload = mo.getFileUpload();
		String a=fileUpload.getOriginalFilename();
		return mav;
	}
	
	
	
	
	
}
