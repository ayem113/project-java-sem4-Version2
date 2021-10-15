package com.projectjavasem4.dto;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends AbstractDTO<UserDTO> {

	private String username;
	private String password;
	private String fullname;
	private String address;
	private String img;	
	private String  Payments;	
	private String sdt;
	private Integer stt;
	private String email;
	private String otp;
}
