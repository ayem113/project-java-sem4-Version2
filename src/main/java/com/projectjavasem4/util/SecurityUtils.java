package com.projectjavasem4.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.projectjavasem4.dto.MyUser;



public class SecurityUtils {
	
	public static MyUser getPrincipal() {
		
		MyUser m = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (m==null) {
			return null;
		}
		else 
		{
		return (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		}
    }
	
	@SuppressWarnings("unchecked")
	public static List<String> getPermission() {   
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
		return results;
	}
}
