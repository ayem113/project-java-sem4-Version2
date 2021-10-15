package com.projectjavasem4.dto;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDTO extends AbstractDTO<ProductDTO> {

	private String name;
	private String slug;
	private Float price;
	private Integer discount;
	private Integer quantity;
	private String img;
	private CommonsMultipartFile fileUpload;
	private MultipartFile fileUpload2;
	private String stt;
	private String description;
	private String name_category;
	private Long id_category;
	private String categoryCode;
	private  Long id_orderDetails ;	
	private Long id_comments;
	
}
