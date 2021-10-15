package com.projectjavasem4.dto;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDTO  extends AbstractDTO<OrderDTO>{	
	private String customer_name;
	private String id_user;
	private String sdt;
	private String email;
	private String general_address;
	private String detail_address;
	private String  payment_methods;	
	private String code_sale;
	private String total_price;
}
