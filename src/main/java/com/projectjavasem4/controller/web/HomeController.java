package com.projectjavasem4.controller.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.entities.CategoryEntity;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.repository.CategoryRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.service.ICategoryService;
import com.projectjavasem4.service.IProductService;
import com.projectjavasem4.service.IRoleService;
import com.projectjavasem4.service.IUserService2;
import com.projectjavasem4.service.WishlistService;
import com.projectjavasem4.util.CaptchaUtil;
import com.projectjavasem4.util.SecurityUtils;




@Controller(value = "homeControllerOfWeb")

public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	public static final String FILE_TYPE = "jpeg";
	@Autowired
	IRoleService rr;
	@Autowired
	IUserService2 IUserService2;
	@Autowired
	IProductService iPro;
	@Autowired
	ICategoryService iCate;
	@Autowired 
	WishlistService wishlistService;
	
	@Autowired
	CategoryRepository CateRep;
	
	@Autowired
	ProductRepository ProRep;
	public boolean isLogin() {
        
		return SecurityUtils.getPermission().size() > 1;

	}

	public boolean isLogin2() {

		return SecurityUtils.getPermission().get(0).toString() != "ROLE_ANONYMOUS";

	}
	
	
	

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam(name = "isLogin", required = false) String isLogin,
			@RequestParam("page") int page,@RequestParam(name="danh-muc", required = false) String cateCode, @RequestParam("limit") int limit, HttpServletRequest request ,HttpSession session) {
		ModelAndView mav = new ModelAndView("web/home");
        session.setAttribute("listCategory2", CateRep.findAll());
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
		
		if(cateCode == null || cateCode == "")
		{  //phan trang tat ca sp
			
			Pageable pageable = new PageRequest(page - 1, limit);
			model.setListResult(iPro.findAll(pageable));
			model.setTotalItem(iPro.getTotalItem());
			
		} else { //phan trang theo danh muc
			model.setCateCode(cateCode);
			CategoryEntity cate = CateRep.findByCode(cateCode);
			Long cateId=cate.getId();
			List<ProductEntity> lstResult = ProRep.findByIdCate(cateId, Long.parseLong((limit*(page-1))+""), Long.parseLong(limit+""));
			List<ProductDTO> models = new ArrayList<>();
			for (ProductEntity item : lstResult) {
				ProductDTO p = new ModelMapper().map(item, ProductDTO.class);
				models.add(p);
			}
			//mav.addObject("catecode",cateCode);
			
			model.setListResult(models);
			model.setTotalItem(ProRep.findByIds(cateId).size());
		}
		
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

		
		/*
		 * if (isLogin != null) { mav.addObject("isLogin", isLogin); } else {
		 * mav.addObject("isLogin", "false"); }
		 */
		return mav.addObject("model", model);
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request,
			@RequestParam(name = "returnUrl", required = false) String returnUrl) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("returnUrl", request.getParameter("returnUrl"));
		// c2 mav.addObject("returnUrl", returnUrl);

		// để tb ban da dang nhap roi nếu họ đăng nhập tiep

		// String role=SecurityUtils.getPrincipal().getFullName();
		// String role2=SecurityUtils.getPrincipal().getRole();

		if (isLogin2()) {
			return new ModelAndView("redirect:/trang-chu?isLogin=true");
		}

		/*
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication(); if (
		 * authentication.getPrincipal()!="anonymousUser" ||
		 * authentication.getAuthorities().size()<1 || authentication instanceof
		 * AnonymousAuthenticationToken ) {
		 * 
		 * return new ModelAndView("redirect:/trang-chu?isLogin=true"); }
		 */

		return mav;

	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}

	@RequestMapping(value = "/xu-ly-thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) {
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (isLogin() == false) {

			return new ModelAndView("redirect:/dang-nhap?returnUrl=thanh-toan");

		} else {
			// xử lý code thanh toán ở đây
			return new ModelAndView("redirect:/trang-chu?isCheckout=true");
		}

	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment2(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("web/checkout");
	}
	@RequestMapping(value = "/test-capcha", method = RequestMethod.GET)
	public ModelAndView tesstCapcha(Model model,HttpServletRequest request, HttpServletResponse response) {
		UserEntity login= new UserEntity();
		model.addAttribute("login", login);
		return new ModelAndView("web/capcha");
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/xxcapcha", method = RequestMethod.GET)
	public void xxx(HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Max-Age", 0);
		response.setContentType("image/jpeg");

		String captchaStr="";

		System.out.println("------------------In captcha---------------");

		captchaStr = CaptchaUtil.generateCaptchaTextMethod2(6);


		try {
			int width=100;     	
			int height=40;

			Color bg = new Color(0,255,255);
			Color fg = new Color(0,100,0);

			Font font = new Font("Arial", Font.BOLD, 20);
			BufferedImage cpimg =new BufferedImage(width,height,BufferedImage.OPAQUE);
			Graphics g = cpimg.createGraphics();

			g.setFont(font);
			g.setColor(bg);
			g.fillRect(0, 0, width, height);
			g.setColor(fg);
			g.drawString(captchaStr,10,25);   

			HttpSession session = request.getSession(true);
			session.setAttribute("CAPTCHA", captchaStr);

			OutputStream outputStream = response.getOutputStream();

			ImageIO.write(cpimg, FILE_TYPE, outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value = "/loginCapcha", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") UserEntity login,BindingResult result,Model model,HttpSession session) {
		LOGGER.debug("--- In Login method ----");
		
		/*
		 * if (login.getUsername() == null || login.getUsername().equals("")){
		 * login.setCaptcha(""); mav.addObject("message", "User Id is required"); return
		 * mav; }
		 * 
		 * 
		 * if (login.getPassword() == null || login.getPassword().equals("")){
		 * login.setCaptcha(""); mav.addObject("message", "Password is required");
		 * return mav; }
		 * 
		 * if(login.getUsername().equals("test") &&
		 * login.getPassword().equals("test123")){
		 * System.out.println("user id and password matches"); mav.addObject("loginId",
		 * login.getUsername()); return mav; } else{ login.setCaptcha("");
		 * mav.addObject("message","User ID or Password Incorrect"); return mav; }
		 */

		String captcha = (String) session.getAttribute("CAPTCHA");
		if(captcha == null || (captcha != null && !captcha.equals(login.getCaptcha()))){
			/*
			 * login.setCaptcha(""); mav.addObject("message", "Captcha does not match");
			 * return mav;
			 */
			
			
			ModelAndView mm= new ModelAndView("web/capcha");
			mm.addObject("error","Captcha false");
			//return "account/index";
			return mm;
			
		}else {
			
			
			ModelAndView mm= new ModelAndView("web/capcha");
			mm.addObject("error","Captcha ok");
			//return "account/index";
			return mm;
		}
		
		
		
	}
	
	

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("register");
		mav.addObject("alert", request.getParameter("alert"));
		// mav.addObject("s", new UserEntity());
		return mav;
	}

	@RequestMapping(value = "/xu-ly-dang-ky", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest request,
			@ModelAttribute("s") UserEntity user /* BindingResult bindingResult */) throws NoSuchAlgorithmException {

		/*
		 * if (bindingResult.hasErrors()) { // form validation error
		 * 
		 * } else { // form input is OK }
		 */

		user.setStt(1);
		user.setRole(rr.getByName("User"));
		user.setPassword(new BCryptPasswordEncoder().encode(request.getParameter("password").toString()));

		if (IUserService2.save(user)) {

			return "redirect:/dang-ky?alert=true";
		} else {
			return "redirect:/dang-ky?alert=false";
		}

	}
	
	

	

	@RequestMapping(value = "/san-pham/*", method = RequestMethod.GET)
	public ModelAndView detailPro2(HttpServletRequest request) {
		ProductDTO productDetail = new ProductDTO();

		
		String req5uestURI = request.getServletPath();
		String name = req5uestURI.substring(10);

		productDetail = iPro.findBySlug(name);

		ModelAndView mav = new ModelAndView("web/productDetail");
		
		Cookie read = wishlistService.read("Wishlist");
		
		if (read!=null) {
			
			String ids = read.getValue();  // danh sahc id da luu
			//List<ProductEntity> ls=iPro.findByIds(ids);
			
			String[] words = ids.split(",");
			
			List<String> supplierNames = Arrays.asList("158","177","65","44");
			List<String> immutableList = List.of(words);
			
			
			
			List<String> Name1 = Arrays.asList(words);
			
			
			
			List<ProductEntity> ls4=iPro.findByidnene2(words);
			mav.addObject("listWishlist", ls4);
		}
		
		
		mav.addObject("productDetail", productDetail);
		return mav;
	}

}