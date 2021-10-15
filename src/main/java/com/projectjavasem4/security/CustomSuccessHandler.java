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
import lombok.EqualsAndHashCode;
@Component
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler     { //xử lý authorization (ủy quyền) SimpleUrlAuthenticationSuccessHandler
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
			String targetUrl = determineTargetUrl(authentication);  
			String returnURl = request.getParameter("returnUrl");     
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
		@SuppressWarnings("unused")
		List<String> lstPer = SecurityUtils.getPermission();
		String role = SecurityUtils.getPrincipal().getRole();	
		if (role.equals("ADMIN")) {
			url = "/quan-tri/san-pham/danh-sach";		
		} else if (role.equals("USER")) {
			url = "/trang-chu";
		}
		return url;
	}
	
	
	@SuppressWarnings("unused")
	private boolean isAdd(List<String> per) {
		return per.contains("ADD");
	}
	
	@SuppressWarnings("unused")
	private boolean isEdit(List<String> per) {
		return per.contains("EDIT");
	}
}
