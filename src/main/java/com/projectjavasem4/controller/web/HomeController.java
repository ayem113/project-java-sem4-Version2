package com.projectjavasem4.controller.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

import com.projectjavasem4.constant.MyConstants;
import com.projectjavasem4.dto.OrderDTO;
import com.projectjavasem4.dto.OrderDetaiDTO;
import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.dto.UserDTO;
import com.projectjavasem4.entities.CategoryEntity;
import com.projectjavasem4.entities.OrderEntity;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.repository.CategoryRepository;
import com.projectjavasem4.repository.OrderDetailRepository;
import com.projectjavasem4.repository.OrderRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.repository.UserRepository;
import com.projectjavasem4.service.CartService;
import com.projectjavasem4.service.ICategoryService;
import com.projectjavasem4.service.IMailService;
import com.projectjavasem4.service.IOrderDetailService;
import com.projectjavasem4.service.IOrderService;
import com.projectjavasem4.service.IProductService;
import com.projectjavasem4.service.IRoleService;
import com.projectjavasem4.service.IUserService;
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
	IUserService IUserService2;
	@Autowired
	IProductService iPro;
	@Autowired
	ICategoryService iCate;
	@Autowired 
	WishlistService wishlistService;
	@Autowired
	CategoryRepository CateRep;
	@Autowired
	IOrderService iOrderSer;
	@Autowired
	IOrderDetailService iOrderDetailSer;
	@Autowired
	IMailService iMailSer;
	@Autowired
	ProductRepository ProRep;
	@Autowired
	CartService cartService;
	@Autowired
	OrderRepository orderRep;
	@Autowired
	OrderDetailRepository orderDetailRep;
	@Autowired
	UserRepository userRep;
	@Autowired public JavaMailSender emailSender;
	 

	 
	 
	public boolean isLogin() {
	 return SecurityUtils.getPermission().size() > 1;
	}

	public boolean isLogin2() {
       return SecurityUtils.getPermission().get(0).toString() != "ROLE_ANONYMOUS";
	}

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(name = "isLogin", required = false) String isLogin,
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

	@RequestMapping(value = "/san-pham/*", method = RequestMethod.GET)
	public ModelAndView detailProduct(HttpServletRequest request) {
		ProductDTO productDetail = new ProductDTO();
		String req5uestURI = request.getServletPath();
		String name = req5uestURI.substring(10);

		productDetail = iPro.findBySlug(name);

		ModelAndView mav = new ModelAndView("web/productDetail");
		
		Cookie read = wishlistService.read("Wishlist");
		
		if (read!=null) {
			
			String listIdCooki = read.getValue();  // danh sach id da luu trong cooki 
			String[] ids = listIdCooki.split(",");

			List<ProductEntity> l=iPro.findByidnene2(ids);
			mav.addObject("listWishlist", l);
		}
		
		
		mav.addObject("productDetail", productDetail);
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			@RequestParam(name = "returnUrl", required = false) String returnUrl) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("returnUrl", request.getParameter("returnUrl"));
		// c2 mav.addObject("returnUrl", returnUrl);

		// để tb ban da dang nhap roi nếu họ đăng nhập tiep

		// String role=SecurityUtils.getPrincipal().getFullName();
		// String role2=SecurityUtils.getPrincipal().getRole();

		/*
		 * if (isLogin2()) { return new
		 * ModelAndView("redirect:/trang-chu?isLogin=true"); }
		 */
		/*
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication(); if (
		 * authentication.getPrincipal()!="anonymousUser" ||
		 * authentication.getAuthorities().size()<1 || authentication instanceof
		 * AnonymousAuthenticationToken ) {
		 * 
		 * return new ModelAndView("redirect:/trang-chu?isLogin=true"); }
		 */
		mav.addObject("model", new UserDTO());
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
	
	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.GET)
	public ModelAndView forgetPass(HttpServletRequest request, HttpServletResponse response) {
		 return new ModelAndView("web/forgetPass");		 
	}
		
	@ResponseBody
	@RequestMapping(value = "/sendMailResetPass/*", method = RequestMethod.GET)
	public String sendMailResetPass( HttpServletRequest request, HttpServletResponse response) {
		
		String requestURI = request.getServletPath();
		String emailAddress = requestURI.substring(19);
		
		String otp=RandomStringUtils.randomNumeric(6);
		
		//String fullname = userRep.findOneByEmail(emailAddress).getFullname();
		
		UserEntity u = userRep.findOneByEmail(emailAddress);
		
		if (u==null) {
			return "false";
		}
		else {
			
			if (iMailSer.sendMailResetPass(emailAddress, otp)) {
				
				/*c1
				 * Long idUser = userRep.findOneByEmail(emailAddress).getId();
				 * userRep.updateCodeCheckPass(codeRamdom, idUser);
				 */
				//c2
				
				u.setOtp(otp);
				u.setOtpRequestedTime(new Date());
				userRep.save(u);
				return "true";
			}else {
				return"false";	
			}	
		}
	}
	
	//c1 dùng phương thức get và sử lý url (cách củ chuối)
	@ResponseBody
	@RequestMapping(value = "/checkCodeResetPass/*", method = RequestMethod.GET)
	public String checkCodeResetPass( HttpServletRequest request, HttpServletResponse response) {
		
		String requestURI = request.getServletPath();
		String url = requestURI.substring(20);
		String code=url.substring(0,6);
				
				int index=url.indexOf("&");
				String email=url.substring(index+1);
		
				UserEntity user = userRep.findOneByEmail(email);
				return(user.getOtp().equals(code)) ?"true":"false";
				
				
				/*
				 * UserEntity check = userRep.checkCodeResetPass(code, email);
				 * return(check!=null) ?"true":"false";
				 */
		
		
	}
	
	//c2 dùng phương thức post (aajax truyền biến lên controller nhận về )
	@ResponseBody
	@RequestMapping(value = "/checkCodeResetPass2", method = RequestMethod.POST)
	public String checkCodeResetPass( @RequestParam String email, @RequestParam String code) {

		UserEntity user = userRep.findOneByEmail(email);
		if (user==null|| code==null) {
			return "false";
		}
		else 
		{
			String otp=user.getOtp();
			if (otp==null) {
				return "false";
			}
			else 
			{
				if (otp.equals(code)) 
				{
					if (!user.isOTPRequired()) 
					{
						return "expires";
					}
					else 
					{
						return "true";
					}
				}
				else 
				{
				  return "false";
				}
			}	
		}	
	
	}
		
	@ResponseBody
	@RequestMapping(value = "/changePass", method = RequestMethod.POST)
	public String changePass(@ModelAttribute("model")  UserDTO user  ) {//@PathVariable String email,
		
		String email=user.getEmail();
		try {
			UserEntity u = userRep.findOneByEmail(email);
			u.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			IUserService2.clearOTP(u);
			return "true";
		} catch (Exception e) {
			return"false";
		}		
	}
	
	@ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
         
        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
	
	@ResponseBody
    @RequestMapping("/sendAttachmentEmail")
    public String sendAttachmentEmail() throws MessagingException {
 
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
 
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);
 
        helper.setTo(MyConstants.FRIEND_EMAIL);
        helper.setSubject("Test email with attachments");
         
        helper.setText("Hello, Im testing email with attachments!");
         
        String path1 = "D:\\Downloads\\JD-TECH-SUPPORT.docx";
        String path2 = "D:\\Downloads\\file_download_20210906204210.xlsx";
 
        // Attachment 1
        FileSystemResource file1 = new FileSystemResource(new File(path1));
        helper.addAttachment("Txt file", file1);
 
        // Attachment 2
        FileSystemResource file2 = new FileSystemResource(new File(path2));
        helper.addAttachment("Readme", file2);
 
        emailSender.send(message);
 
        return "Email Sent!";
    }
	
	@ResponseBody
	@RequestMapping("/sendHtmlEmail")
	public String sendHtmlEmail() throws MessagingException {
	 
	        MimeMessage message = emailSender.createMimeMessage();
	 
	        boolean multipart = true;
	         
	        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
	         
	        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
	                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
	         
	        message.setContent(htmlMsg, "text/html");
	         
	        helper.setTo(MyConstants.FRIEND_EMAIL);
	         
	        helper.setSubject("Test send HTML email");
	         
	     
	        this.emailSender.send(message);
	 
	        return "Email Sent!";
	    }
	 
    public String doSendEmail() {
	        // takes input from e-mail form
	   
	         
	        // creates a simple e-mail object
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo("vohuyhieu.qb@gmail.com");
	        email.setSubject("hehe");
	        email.setText("gui mail bang been config ");
	         
	        // sends the e-mail
	        emailSender.send(email);
	         
	        // forwards to the view named "Result"
	        return "Result";
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
	public ModelAndView loginCapcha(@ModelAttribute("login") UserEntity login,BindingResult result,Model model,HttpSession session) {
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
		
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav =new ModelAndView("web/checkout");
		mav.addObject("model", new OrderDTO());			
		return mav;
	}
	
	@RequestMapping(value = "/xu-ly-thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment2(HttpServletRequest request, HttpServletResponse response) {
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (isLogin() == false) {

			return new ModelAndView("redirect:/dang-nhap?returnUrl=thanh-toan");

		} else {
			// xử lý code thanh toán ở đây
			return new ModelAndView("redirect:/trang-chu?isCheckout=true");
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpServletRequest request ,  @ModelAttribute("model")  OrderDTO order,HttpSession session) {

		
		@SuppressWarnings("unused")
		Object cart = session.getAttribute("scopedTarget.cartService");
		Collection<ProductEntity> cart1 = cartService.getAll();
		
		try {
			if (iOrderSer.add(order)) {
				
				//Long lastInsertId = orderRep.getLastInsertId();
				
				OrderEntity lastInsertId2 = orderRep.getLastInsertId2();
				
				Long id = lastInsertId2.getId();
				for ( ProductEntity pro :  cart1) {
					
					OrderDetaiDTO o = new OrderDetaiDTO();
					
					o.setId_order(id);
					o.setId_product(pro.getId());
					o.setPrice(pro.getPrice());
					o.setQuantity(pro.getQuantity());
					//o.setSale(pro.getSale());
	
					iOrderDetailSer.add(o);
				}
				
				return "thanh toan thanh cong";
				
			}
		} catch (Exception e) {
			return "thanh toan khong thanh cong";
		}
		return null;
		
	}
	

	 
}