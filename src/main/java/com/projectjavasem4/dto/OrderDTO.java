package com.projectjavasem4.dto;

import lombok.Data;

@Data
public class OrderDTO  extends AbstractDTO<OrderDTO>{

	
	private String address;
	
	private String name;
	
	private String sdt;
	
	private Boolean stt;
	
	private Byte sale;
	
	private Long id_user;
}
