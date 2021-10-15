package com.projectjavasem4.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class MyUser extends User {

	private static final long serialVersionUID = 1L;
	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,boolean credentialsNonExpired, boolean accountNonLocked,Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}	
	private String fullName;
	private Long id;
	private String role;
	private String address;
	private String  payments;
	private String sdt;
	private String email;
}
