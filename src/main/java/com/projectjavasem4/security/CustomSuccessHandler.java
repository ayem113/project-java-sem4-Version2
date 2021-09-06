package com.projectjavasem4.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.projectjavasem4.util.SecurityUtils;

import lombok.Data;



@Component
@Data
public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler     { //xử lý authorization (ủy quyền) SimpleUrlAuthenticationSuccessHandler
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		
			String targetUrl = determineTargetUrl(authentication);
		  
		    String returnURl = request.getParameter("returnUrl"); 
		    int l=returnURl.length();
		    if(returnURl.isEmpty()==false) 
		    { 
		    	targetUrl = returnURl; 
		    }
		
		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	
	
	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> lstPer = SecurityUtils.getPermission();
		
		String role = SecurityUtils.getPrincipal().getRole();
		
		if (role.equals("ADMIN")) {
			url = "/quan-tri/trangchu";
			
		} else if (role.equals("USER")) {
			url = "/trang-chu?page=1&limit=5";
		}
		return url;
	}
	
	
	private boolean isAdd(List<String> per) {
		if (per.contains("ADD")) {
			return true;
		}
		return false;
	}
	
	private boolean isEdit(List<String> per) {
		if (per.contains("EDIT")) {
			return true;
		}
		return false;
	}
}
