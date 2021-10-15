package com.projectjavasem4.api.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.entities.ProductDetailEntity;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.entities.ProductImageEntity;
import com.projectjavasem4.repository.ProductDetailRepository;
import com.projectjavasem4.repository.ProductImageRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.service.IProductService;
import com.projectjavasem4.util.ProDetail;

@RestController(value = "ProductAPIOfAdmin")

@RequestMapping("/api/product")
public class ProductAPI {
	
	 private static final Logger logger = Logger.getLogger(ProductAPI.class.getName());
	 private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	
	
	@Autowired  private IProductService proService;	
	@Autowired	private ProductRepository proRep; 
	@Autowired	private ProductDetailRepository proDetailRep; 
	@Autowired	private ProductImageRepository proImgRep; 
	
	@GetMapping("")
	private List<ProductDTO> getAll() {
		List<ProductDTO> all = proService.getAll();
		return all;
	}

	@GetMapping("/{id}")
	private ProductDTO getBId(@PathVariable long id) {
		return proService.findById(id);
	}

	@PostMapping("/addDetailAndImg")
	private String addDetailAndImg(@RequestBody List<ProDetail> list) {
		ProductEntity pro = proRep.getLastInsertId();
		try {
			for (ProDetail p : list) {
				proDetailRep.insertProductDetail(p.getIdSize(),p.getIdColor(),pro.getId(),p.getSoluong());
			}
			for (ProDetail p : list) {
				insertProductImageDetail(p.getIdSize(),p.getIdColor(),p.getListImgs());	
				System.out.println("vô");
			}
		} catch (Exception e) {	
			System.out.println(e.getMessage().toString());
			return "false";
		}
		return "true";
	}

	private void insertProductImageDetail(long idSize, long idColor, String listImgs) {
		
		listImgs = listImgs.substring(0, listImgs.length()-1); //bỏ dấu phẩy cuối chuỗi
		ProductDetailEntity product_detail = proDetailRep.findByIdColorAndIdSize(idSize, idColor);
		String[] img = listImgs.split(",");
		try {
			for (String string : img) {
				ProductImageEntity proImg= new ProductImageEntity();
				proImg.setProduct_detail(product_detail);
				proImg.setImg(string);	
				proImgRep.save(proImg);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}	
	}
	
	@PostMapping("")
	private String inserOrUpdate(@ModelAttribute("model") ProductDTO pro, HttpSession session) { 
		if (pro.getFileUpload2()!=null) {
			MultipartFile fileUpload2 = pro.getFileUpload2();
			upload(session, fileUpload2);
			pro.setImg(fileUpload2.getOriginalFilename());		
		}
		return (proService.save(pro)) ? "true" : "false";
	}
	
	  @PostMapping("/uploadFileTam") 
    private String uploadFileTam(@RequestParam("file[]") MultipartFile[] files,HttpSession session) throws IOException { 
		  
		  String fileNames="";
		  
			  for (MultipartFile f : files) {
				  fileNames += uploadTam(session,f)+",";
			  }
			  logger.info("text logger: " );
			  
		  return fileNames;
	  }
	  
    private String uploadTam(HttpSession session, MultipartFile myFile) {
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  String fileNameSub = "";
		  String stringTimestamp = format.format(timestamp);// 2021-10-14-13-41-29
		  //String stringTimestamp = String.valueOf(timestamp.getTime());// 1616574866666

			ServletContext context = session.getServletContext();
			String path = context.getRealPath("/imagesTam");

			try {
				MultipartFile multipartFile = myFile;
				String fileName = multipartFile.getOriginalFilename(); //abc.jpg
				
				fileNameSub=fileName.substring(0,fileName.indexOf("."))+"-"+stringTimestamp+fileName.substring(fileName.indexOf("."));//abc-2021-10-14-13-41-29.jpg 
				System.out.println(fileNameSub);
				File file = new File(path, fileNameSub);
				multipartFile.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return fileNameSub;
		} 

    private void upload(HttpSession session, MultipartFile myFile) {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("/images");
		try {
			MultipartFile multipartFile = myFile;
			String fileName = multipartFile.getOriginalFilename();
			File file = new File(path, fileName);
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DeleteMapping("") 
    private String deleteNew(@RequestBody long[] ids) { 
		  return  (proService.delete(ids)) ? "true" :"false" ;
	}	
}
