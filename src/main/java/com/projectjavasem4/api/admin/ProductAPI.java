package com.projectjavasem4.api.admin;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.projectjavasem4.util.UploadUtil;

@RestController(value = "ProductAPIOfAdmin")

@RequestMapping("/api/product")
public class ProductAPI {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ProductAPI.class.getName());
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
				proImg.setImg((string));					
				proImgRep.save(proImg);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}	
	}
		
	@SuppressWarnings("unused")
	private static String returnImg(String s1) {
		return s1.substring(0,s1.indexOf(".")-20) + s1.substring(s1.indexOf(".")); //20 là trừ đi số kí tự date phía sau img
	}

	@PostMapping("")
	private String inserOrUpdate(@ModelAttribute("model") ProductDTO pro, HttpSession session) { 
		if (pro.getFileUpload2()!=null) {
			MultipartFile fileUpload = pro.getFileUpload2();
			new UploadUtil().upload(session, fileUpload);
			pro.setImg(fileUpload.getOriginalFilename());		
		}
		return (proService.save(pro)) ? "true" : "false";
	}

	@DeleteMapping("") 
    private String deleteNew(@RequestBody long[] ids) { 
		  return  (proService.delete(ids)) ? "true" :"false" ;
	}	
}
