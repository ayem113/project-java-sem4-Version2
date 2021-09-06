package com.projectjavasem4.dto;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;

@Data
public class ProductDTO extends AbstractDTO<ProductDTO> {
	
	

	private String name;
	private String slug;
	
	private Byte sale;

	private Float price;

	private Integer quantity;

	private String img;
	
	private CommonsMultipartFile fileUpload;
	
	private MultipartFile fileUpload2;

	private String list_img;

	private Boolean stt;

	private String description;

	
	private Long id_category;
	
	private String categoryCode;
	private  Long id_orderDetails ;
	
	private Long id_comments;

	
	
	
	
}
