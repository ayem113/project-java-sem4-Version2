package com.projectjavasem4.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDetaiDTO extends AbstractDTO<OrderDetaiDTO> {

	private Integer quantity;
	private Float price;
	private int sale;
	private Long id_order;
	private Long id_productDetail;
	
}
