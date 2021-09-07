package com.projectjavasem4.dto;

import lombok.Data;

@Data
public class UsertDTO2 extends AbstractDTO<UsertDTO2> {
	
	
	private String username;

	private String password;

	private String fullname;
	
	private String address;
	
	private String img;

	private Integer stt;

	public String getUsername() {
		return username;
	}


	
	
	
	
}
