package com.projectjavasem4.api.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.service.IProductService;

@RestController(value = "ProductAPIOfAdmin")

@RequestMapping("/api/product")
public class ProductAPI {

	@Autowired
	private IProductService proService;

	@GetMapping("")
	public List<ProductDTO> getAll() {
		List<ProductDTO> all = proService.getAll();
		return all;
	}

	@GetMapping("/{id}")
	public ProductDTO getBId(@PathVariable long id) {
		return proService.findById(id);
	}
	
	@PostMapping("")
	public String inserOrUpdate(@RequestBody  ProductDTO pro) {   //@RequestBody
		return  (proService.save(pro)) ? "true" :"false" ;
	}
	
	
	//@ResponseBody
	@PostMapping("/a")
	public String inserOrUpdate2(   @ModelAttribute("model")  ProductDTO pro,HttpSession session)  {   //@RequestBody
		
		MultipartFile fileUpload2 = pro.getFileUpload2();
		System.out.println(fileUpload2.getOriginalFilename());
		
		upload(session,fileUpload2);
		
		pro.setImg(fileUpload2.getOriginalFilename());
		return  (proService.save(pro)) ? "true" :"false" ;
	}

	
	  void upload(HttpSession session,MultipartFile myFile) {
	 
	  ServletContext context = session.getServletContext(); String path =
	  context.getRealPath("/images");
	  
	  
	  try { MultipartFile multipartFile = myFile; String fileName =
	  multipartFile.getOriginalFilename(); File file = new File(path, fileName);
	  multipartFile.transferTo(file); } catch (Exception e) { e.printStackTrace();
	  }
	  
	  
	  }
	 
	
	
	
	/*
	 * @PostMapping("") public String inserOrUpdate(@RequestParam(name =
	 * "fileUpload") MultipartFile file,@ModelAttribute(name = "model") ProductDTO
	 * pro,HttpSession session) { String nam=file.getOriginalFilename();
	 * 
	 * System.out.println(nam);
	 * 
	 * String originalFilename = pro.getFileUpload().getOriginalFilename();
	 * System.out.println(originalFilename); //upload(session,pro.getFileUpload());
	 * CommonsMultipartFile fileUpload = //pro.getFileUpload(); String
	 * a=fileUpload.getOriginalFilename(); return (proService.save(pro)) ? "true"
	 * :"false" ;
	 * 
	 * }
	 * 
	 */
	
	
	/*@PostMapping("")
	public String inserOrUpdate2(@ModelAttribute(name = "model") ProductDTO pro ,HttpSession session) {
		
		//upload(session,pro.getFileUpload());
		CommonsMultipartFile fileUpload = pro.getFileUpload();
		String a=fileUpload.getOriginalFilename();
		return  (proService.save(pro)) ? "true" :"false" ;
	}*/
	  
	  
	  
	/*
	 * @PostMapping("") public String inserOrUpdate2(@ModelAttribute("model")
	 * ProductDTO pro ,HttpSession session) {
	 * 
	 * //upload(session,pro.getFileUpload()); CommonsMultipartFile fileUpload =
	 * pro.getFileUpload(); String a=fileUpload.getOriginalFilename(); return
	 * (proService.save(pro)) ? "true" :"false" ; }
	 */
}
