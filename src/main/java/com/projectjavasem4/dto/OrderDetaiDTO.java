package com.projectjavasem4.dto;

import lombok.Data;
@Data
public class OrderDetaiDTO extends AbstractDTO<OrderDetaiDTO> {

	private Integer quantity;
	
	private Double price;
	
	private Byte sale;
	
	private Long id_order;
	
	private Long id_product;
	
}
