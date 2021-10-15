package com.projectjavasem4.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.dto.OrderDTO;
import com.projectjavasem4.dto.UserDTO;
import com.projectjavasem4.entities.DistrictEntity;
import com.projectjavasem4.entities.OrderDetailEntity;
import com.projectjavasem4.entities.OrderEntity;
import com.projectjavasem4.entities.ProductDetailEntity;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.entities.ProvinceEntity;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.entities.WardEntity;
import com.projectjavasem4.repository.CategoryRepository;
import com.projectjavasem4.repository.DistricRepositoty;
import com.projectjavasem4.repository.OrderDetailRepository;
import com.projectjavasem4.repository.OrderRepository;
import com.projectjavasem4.repository.ProductDetailRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.repository.ProvinceRepository;
import com.projectjavasem4.repository.RoleRepository;
import com.projectjavasem4.repository.UserRepository;
import com.projectjavasem4.repository.WardRepository;
import com.projectjavasem4.service.CartService2;
import com.projectjavasem4.service.IMailService;
import com.projectjavasem4.service.IOrderService;
import com.projectjavasem4.service.IProductService;
import com.projectjavasem4.service.IUserService;
import com.projectjavasem4.service.WishlistService;
import com.projectjavasem4.util.SecurityUtils;
import com.projectjavasem4.util.Tag;


@Controller(value = "homeControllerOfWeb")
public class HomeController {
			
	@Autowired  private IUserService IUserService2;
	@Autowired  private IProductService iPro;
	@Autowired  private WishlistService wishlistService;
	@Autowired	private CartService2 cartService;
	@Autowired  private IOrderService iOrderSer;
	@Autowired  private IMailService iMailSer;
	@Autowired  public JavaMailSender emailSender;
	
	
	@Autowired  private CategoryRepository CateRep;
	@Autowired	private OrderRepository orderRep;
	@Autowired	private OrderDetailRepository orderDetailRep;
	@Autowired	private UserRepository userRep; 
	@Autowired	private ProductRepository proRep; 
	@Autowired	private WardRepository wardRep; 
	@Autowired	private DistricRepositoty districRep; 
	@Autowired	private ProvinceRepository provinceRep; 
	@Autowired	private ProductDetailRepository proDetailRep; 
	@Autowired  private RoleRepository roleRep;

	
	/*
	 * public boolean isLogin() { return SecurityUtils.getPermission().size() > 1; }
	 * 
	 * public boolean isLogin2() { return
	 * SecurityUtils.getPermission().get(0).toString() != "ROLE_ANONYMOUS"; }
	 */

	/*phan trang binh thuong
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView home1(@RequestParam(name = "isLogin", required = false) String isLogin,
			@RequestParam("page") int page,@RequestParam(name="danh-muc", required = false) String cateCode, @RequestParam("limit") int limit, HttpServletRequest request ,HttpSession session) {
		ModelAndView mav = new ModelAndView("web/homeNomal");
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

		
		
		 if (isLogin != null) { mav.addObject("isLogin", isLogin); } else {
		 mav.addObject("isLogin", "false"); }
		 
		return mav.addObject("model", model);
	} */

	/* phân trang thường sử dụng Entity
	@RequestMapping(value = "/trang-chu2", method = RequestMethod.GET)
	public ModelAndView home2(@RequestParam(name = "isLogin", required = false) String isLogin,@RequestParam("page") int page,@RequestParam(name="danh-muc", required = false) String cateCode, @RequestParam("limit") int limit, HttpServletRequest request ,HttpSession session) {
		ModelAndView mav = new ModelAndView("web/homeEntity");
        mav.addObject("page", page);
		mav.addObject("limit", limit); 
		if(cateCode == null || cateCode == "")
		{  //phan trang tat ca sp
			Pageable pageable = new PageRequest(page - 1, limit);
			List<ProductEntity> findAll2 = iPro.findAll2(pageable);
			for (ProductEntity productEntity : findAll2) {
				List<ProductDetailEntity> colorGroup = proColorRep.colorGroup(productEntity.getId());
				List<ProductDetailEntity> sizeGroup = proColorRep.sizeGroup(productEntity.getId());
				productEntity.setProduct_detailGroupByColor(colorGroup);
				productEntity.setProduct_detailGroupBySize(sizeGroup);
			}
			 mav.addObject("model", findAll2);
			 mav.addObject("listProEntity", findAll2);
			 mav.addObject("totalItem", iPro.getTotalItem());
			 int totalPage=(int) Math.ceil((double) iPro.getTotalItem() / limit);
			 mav.addObject("totalPage", totalPage);
		} else { //phan trang theo danh muc
			mav.addObject("cateCode", cateCode);
			CategoryEntity cate = CateRep.findByCode(cateCode);
			Long cateId=cate.getId();
			List<ProductEntity> lstResult = ProRep.findByIdCate(cateId, Long.parseLong((limit*(page-1))+""), Long.parseLong(limit+""));
			for (ProductEntity productEntity : lstResult) {
				List<ProductDetailEntity> colorGroup = proColorRep.colorGroup(productEntity.getId());
				List<ProductDetailEntity> sizeGroup = proColorRep.sizeGroup(productEntity.getId());
				productEntity.setProduct_detailGroupByColor(colorGroup);
				productEntity.setProduct_detailGroupBySize(sizeGroup);
			}
			//mav.addObject("catecode",cateCode);
			 mav.addObject("listProEntity", lstResult);
			 mav.addObject("model", lstResult);
			 int totalItem=ProRep.findByIds(cateId).size();
			 mav.addObject("totalItem", totalItem);
			 int totalPage=(int) Math.ceil((double) totalItem / limit);
			 mav.addObject("totalPage", totalPage);
		}
		return mav;
	}	
	
	/* phân trang thường sử dung DTO
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(name = "isLogin", required = false) String isLogin,@RequestParam("page") int page,@RequestParam(name="danh-muc", required = false) String cateCode, @RequestParam("limit") int limit, HttpServletRequest request ,HttpSession session) {
		ModelAndView mav = new ModelAndView("web/homeNomal");
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
		return mav.addObject("model", model);
	} */
	
	
	private void setColorAndSizeForList(List<ProductEntity> lst) {
		for (ProductEntity productEntity : lst) {
			List<ProductDetailEntity> colorGroup = proDetailRep.colorGroup(productEntity.getId());
			List<ProductDetailEntity> sizeGroup = proDetailRep.sizeGroup(productEntity.getId());
			productEntity.setProduct_detailGroupByColor(colorGroup);
			productEntity.setProduct_detailGroupBySize(sizeGroup);
		}
	}
 	
	@ResponseBody
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homeAjax(HttpSession session ) {
		ModelAndView mav = new ModelAndView("web/homeAjax");
		session.setAttribute("listCategory2", CateRep.findAll());
				
		 List<ProductEntity> listProEntity = proRep.findAll().stream().skip(0).limit(5).collect(Collectors.toList());
		 proRep.getListBestSelling();
		
		 
		 
		 setColorAndSizeForList(listProEntity);
 
		 mav.addObject("listProEntity", listProEntity);
		 //mav.addObject("listBestSale",listBestSale );
		 //mav.addObject("listBestSelling",listBestSelling );
		 //mav.addObject("listInterested",listInterested );
		 //mav.addObject("listNewArrival",listNewArrival );
		  
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getDataSearchAutocomplete", method = RequestMethod.GET)
	public List<Tag> getDataSearchAutocomplete(HttpSession session ) { 
		List<Tag> result= proRep.findAll().stream().map(p->new Tag(p.getSlug(),p.getName() ,String.valueOf(p.getPrice()) ,p.getImg())).collect(Collectors.toList());

		
		//List<ProductEntity> allHirbernate = iPro.getAllHirbernate();
		//List<ProductEntity> findBySpecical = iPro.findBySpecical(2);
		return result; //findBySpecical;  
		
		
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/ajax/getLstProduct", method = RequestMethod.GET)
	public void getProAjaxLoadMore( @RequestParam("page") int page, @RequestParam(name="cate", required = false) String cateCode,@RequestParam(name="typePrice", required = false) String typePrice, @RequestParam(name="orderBy", required = false) String orderBy,@RequestParam(name="search", required = false) String search,@RequestParam("limit") int limit, HttpServletRequest request ,HttpServletResponse response, HttpSession session) throws IOException {
		String html = "";
		List<ProductEntity> lstResult;
		List<ProductEntity> finalList = proRep.findAll().stream().collect(Collectors.toList()) ;
		if(cateCode == null || cateCode == "")
		{ 
			
			new PageRequest(page - 1, limit);
			
		    lstResult=proRep.findAll().stream().skip(limit*(page-1)).limit(limit).collect(Collectors.toList());
			//newList = new ArrayList<>(lstResult);

			/*
			 * if (search != null ) {
			 * lstResult=lstResult.stream().filter(x->x.getName().contains(search)).collect(
			 * Collectors.toList()) ; }
			 */
			if( typePrice != null)
			{ 
				
				
				if (typePrice!="") {
					
					lstResult=finalList;
					if (typePrice.equals("Asc")) {			 
						lstResult.sort(  ( x,  y) ->   ((int) (x.getPrice() - y.getPrice()))  );						
						//lstResult=lstResult.stream().sorted(Comparator.comparing(ProductEntity::getPrice).reversed()).collect(Collectors.toList());
						//get one :	ProductEntity getFirtElement = newList.stream().filter(customer -> "James".equals(customer.getName())).findAny().orElse(null);		
						//newList.sort(Comparator.comparing(ProductEntity::getPrice));
						//sort mutiple fied newList.sort(Comparator.comparing(ProductEntity::getId).thenComparing(ProductEntity::getName).thenComparing(ProductEntity::getDiscount));
					}
					
					else { //Desc
						lstResult.sort(  ( x,  y) ->   ((int) (y.getPrice() - x.getPrice()))  );
					}
					lstResult=lstResult.stream().skip(limit*(page-1)).limit(limit).collect(Collectors.toList());
				}
				
			}
			else
			//1 mới nhất 2 phổ biến 3 bán chạy 
			if ( orderBy != null) {
				
				if (orderBy!="") {
					lstResult=finalList;
					
					
					if (orderBy.equals("1")) {  
						lstResult.sort( (a, b) -> a.getCreatedDate().compareTo(b.getCreatedDate()));
					}
					else if(orderBy.equals("1")) {
						//
					}else {
						//
					}
					lstResult=lstResult.stream().skip(limit*(page-1)).limit(limit).collect(Collectors.toList());
									
				}				
			}
							
				for (ProductEntity productEntity : lstResult) {
					List<ProductDetailEntity> colorGroup = proDetailRep.colorGroup(productEntity.getId());
					List<ProductDetailEntity> sizeGroup = proDetailRep.sizeGroup(productEntity.getId());
					productEntity.setProduct_detailGroupByColor(colorGroup);
					productEntity.setProduct_detailGroupBySize(sizeGroup);
					
					html += "<div\n"
							+ "		class=\"product-item best-selling style-04 rows-space-30 col-bg-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-ts-6 post-25 product type-product status-publish has-post-thumbnail product_cat-light product_cat-chair product_cat-specials product_tag-light product_tag-sock first instock sale featured shipping-taxable purchasable product-type-simple\">\n"
							+ "		<div class=\"product-inner tooltip-top tooltip-all-top\">\n"
							+ "			<div class=\"product-thumb\">\n"
							+ "				<a class=\"thumb-link\" href=\"#\">"
							+ "    <img class=\"img-responsive\"src=\"/images/"+productEntity.getImg()+"\"alt=\"Office Chair\" width=\"270\" height=\"350\">\n"
							+ "				</a>\n"
							+ "				<div class=\"flash\">\n"
							+ "					<span class=\"onsale\"><span class=\"number\">"+ productEntity.getDiscount() +"%</span></span>\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "					<span class=\"onnew\"><span class=\"text\">New</span></span>\n"
							+ "				</div>\n"
							+ "\n"
							+ "\n"
							+ "				<div class=\"variations_form cart\">\n"
							+ "					<table class=\"variations\">\n"
							+ "						<tbody>\n"
							+ "							<tr>\n"
							+ "								<td class=\"value\"><select title=\"box_style\"\n"
							+ "									data-attributetype=\"box_style\" data-id=\"pa_color\"\n"
							+ "									class=\"attribute-select \" data-show_option_none=\"yes\">\n"
							+ "										<option data-type=\"\" data-pa_color=\"\" value=\"\">Choose\n"
							+ "											an option</option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#ff63cb\" value=\"pink\" class=\"\"></option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#a825ea\" value=\"purple\"\n"
							+ "											class=\"attached enabled\">Purple</option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#db2b00\" value=\"red\" class=\"attached enabled\">Red\n"
							+ "										</option>\n"
							+ "								</select>\n"
							+ "									<div class=\"data-val attribute-pa_color\"\n"
							+ "										data-attributetype=\"box_style\">\n";
						for (ProductDetailEntity productDetailEntity : productEntity.getProduct_detailGroupByColor()) {
							html += "	<a class=\"change-value color\" href=\"#\" data-value=\"red\"\n"
									+ "style=\"background: "+productDetailEntity.getColor().getCode() +"\"> </a>\n";
						}
							
							html+= " <a class=\"reset_variations\" href=\"#\"\n"
							+ "									style=\"visibility: hidden;\">Clear</a></div></td>\n"
							+ "							</tr>\n"
							+ "						</tbody>\n"
							+ "					</table>\n"
							+ "				</div>\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "				<div class=\"variations_form2 cart\">\n"
							+ "					<table class=\"variations\">\n"
							+ "						<tbody>\n"
							+ "							<tr>\n"
							+ "								<td class=\"value\"><select title=\"box_style\"\n"
							+ "									data-attributetype=\"box_style\" data-id=\"pa_color\"\n"
							+ "									class=\"attribute-select \" data-show_option_none=\"yes\">\n"
							+ "										<option data-type=\"\" data-pa_color=\"\" value=\"\">Choose\n"
							+ "											an option</option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#000000\" value=\"black\"\n"
							+ "											class=\"attached enabled\">Black</option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#db2b00\" value=\"red\" class=\"attached enabled\">Red\n"
							+ "										</option>\n"
							+ "								</select>\n"
							+ "\n"
							+ "\n"
							+ "									<div class=\"data-val attribute-pa_color\"\n"
							+ "										data-attributetype=\"box_style\">\n";
							for (ProductDetailEntity productDetailEntity : productEntity.getProduct_detailGroupBySize()) {
								html += "	<a class=\"change-value color\" href=\"#\" data-value=\"red\">\n"
										+ productDetailEntity.getSize().getName() +" </a>\n";
							}
							
							
							html+= "									</div> <a class=\"reset_variations\" href=\"#\"\n"
							+ "									style=\"visibility: hidden;\">Clear</a></td>\n"
							+ "							</tr>\n"
							+ "						</tbody>\n"
							+ "					</table>\n"
							+ "				</div>\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "				<div class=\"group-button\">\n"
							+ "					<div class=\"add-to-cart\">\n"
							+ "						<a data-id='${item.id}'\n"
							+ "							class=\" btnAddToCart button product_type_simple add_to_cart_button ajax_add_to_cart\">Add\n"
							+ "							to cart</a>\n"
							+ "					</div>\n"
							+ "					<a href=\"#\" class=\"button yith-wcqv-button\">Quick View</a>\n"
							+ "					<div class=\"furgan product compare-button\">\n"
							+ "						<a href=\"#\" class=\"compare button\">Compare</a>\n"
							+ "					</div>\n"
							+ "					<div class=\"yith-wcwl-add-to-wishlist\">\n"
							+ "						<div class=\"yith-wcwl-add-button show\">\n"
							+ "							<a data-id='${item.id}' class=\"btnAddToWishlist add_to_wishlist\">Add\n"
							+ "								to Wishlist</a>\n"
							+ "						</div>\n"
							+ "					</div>\n"
							+ "				</div>\n"
							+ "			</div>\n"
							+ "			<div class=\"product-info\">\n"
							+ "\n"
							+ "				<h3 class=\"product-name product_title\">\n"
							+ "\n"
							+ "					<a href=\"/san-pham/\" + item.getSlug() + \"\">"+ productEntity.getName() +"</a>\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "				</h3>\n"
							+ "				<span class=\"price\"><del>\n"
							+ "						<span class=\"furgan-Price-amount amount\"> <f:formatNumber value=\""+productEntity.getPrice()+"\"   pattern=\"###,###\" />&nbsp;₫ </span>\n"
							+ "					</del> <ins>\n"
							+ "						<span class=\"furgan-Price-amount amount\"> <f:formatNumber value=\""+productEntity.getPrice()+"\"   pattern=\"###,###\" /> &nbsp;₫  ----- "+   new DecimalFormat("###.###").format(productEntity.getPrice())  + "</span>\n"
							+ "					</ins></span>\n"
							+ "				<div class=\"rating-wapper nostar\">\n"
							+ "					<div class=\"star-rating\">\n"
							+ "						<span style=\"width: 0%\">Rated <strong class=\"rating\">0</strong>\n"
							+ "							out of 5\n"
							+ "						</span>\n"
							+ "					</div>\n"
							+ "					<span class=\"review\">(0)</span>\n"
							+ "				</div>\n"
							+ "			</div>\n"
							+ "		</div>\n"
							+ "	</div>";
				}

		
		}else {
			
			 lstResult=proRep.findAll().stream().filter(x->x.getCategory().getCode().equals(cateCode)).skip(limit*(page-1)).limit(limit).collect(Collectors.toList());
			// newList = new ArrayList<>(lstResult);
			
			
			/*//mav.addObject("cateCode", cateCode);
			CategoryEntity cate = CateRep.findByCode(cateCode);
			Long cateId=cate.getId();
			lstResult = ProRep.findByIdCate(cateId, Long.parseLong((limit*(page-1))+""), Long.parseLong(limit+""));
			
			*/
			
			/*
			 * if (search != null ) {
			 * newList=newList.stream().filter(x->x.getName().contains(search)).collect(
			 * Collectors.toList()) ; }
			 */
			if(typePrice != null )
			{ 
				
				lstResult=finalList;
				if (typePrice.equals("Asc")) {			 
					lstResult.sort(  ( x,  y) ->   ((int) (x.getPrice() - y.getPrice()))  );						
				}
				
				else {
					lstResult.sort(  ( x,  y) ->   ((int) (y.getPrice() - x.getPrice()))  );
				}
				lstResult=lstResult.stream().skip(limit*(page-1)).limit(limit).collect(Collectors.toList());
			}
			else
			//1 mới nhất 2 phổ biến 3 bán chạy 
			if (orderBy != null ) {
				
				if (orderBy!="") {
					lstResult=finalList;
					
					
					if (orderBy.equals("1")) {  
						lstResult.sort( (a, b) -> a.getCreatedDate().compareTo(b.getCreatedDate()));
					}
					else if(orderBy.equals("1")) {
						//
					}else {
						//
					}
					lstResult=lstResult.stream().skip(limit*(page-1)).limit(limit).collect(Collectors.toList());
									
				}		
			}

				
				for (ProductEntity productEntity : lstResult) {
					List<ProductDetailEntity> colorGroup = proDetailRep.colorGroup(productEntity.getId());
					List<ProductDetailEntity> sizeGroup = proDetailRep.sizeGroup(productEntity.getId());
					productEntity.setProduct_detailGroupByColor(colorGroup);
					productEntity.setProduct_detailGroupBySize(sizeGroup);
					
					
					
					html += "<div\n"
							+ "		class=\"product-item best-selling style-04 rows-space-30 col-bg-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-ts-6 post-25 product type-product status-publish has-post-thumbnail product_cat-light product_cat-chair product_cat-specials product_tag-light product_tag-sock first instock sale featured shipping-taxable purchasable product-type-simple\">\n"
							+ "		<div class=\"product-inner tooltip-top tooltip-all-top\">\n"
							+ "			<div class=\"product-thumb\">\n"
							+ "				<a class=\"thumb-link\" href=\"#\"> <img class=\"img-responsive\"\n"
							+ "					src=\"/images/"+productEntity.getImg()+"\"\n"
							+ "					alt=\"Office Chair\" width=\"270\" height=\"350\">\n"
							+ "				</a>\n"
							+ "				<div class=\"flash\">\n"
							+ "					<span class=\"onsale\"><span class=\"number\">"+ productEntity.getDiscount() +"%</span></span>\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "					<span class=\"onnew\"><span class=\"text\">New</span></span>\n"
							+ "				</div>\n"
							+ "\n"
							+ "\n"
							+ "				<div class=\"variations_form cart\">\n"
							+ "					<table class=\"variations\">\n"
							+ "						<tbody>\n"
							+ "							<tr>\n"
							+ "								<td class=\"value\"><select title=\"box_style\"\n"
							+ "									data-attributetype=\"box_style\" data-id=\"pa_color\"\n"
							+ "									class=\"attribute-select \" data-show_option_none=\"yes\">\n"
							+ "										<option data-type=\"\" data-pa_color=\"\" value=\"\">Choose\n"
							+ "											an option</option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#ff63cb\" value=\"pink\" class=\"\"></option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#a825ea\" value=\"purple\"\n"
							+ "											class=\"attached enabled\">Purple</option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#db2b00\" value=\"red\" class=\"attached enabled\">Red\n"
							+ "										</option>\n"
							+ "								</select>\n"
							+ "									<div class=\"data-val attribute-pa_color\"\n"
							+ "										data-attributetype=\"box_style\">\n";
						for (ProductDetailEntity productDetailEntity : productEntity.getProduct_detailGroupByColor()) {
							html += "	<a class=\"change-value color\" href=\"#\" data-value=\"red\"\n"
									+ "style=\"background: "+productDetailEntity.getColor().getCode() +"\"> </a>\n";
						}
							
							html+= " <a class=\"reset_variations\" href=\"#\"\n"
							+ "									style=\"visibility: hidden;\">Clear</a></div></td>\n"
							+ "							</tr>\n"
							+ "						</tbody>\n"
							+ "					</table>\n"
							+ "				</div>\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "				<div class=\"variations_form2 cart\">\n"
							+ "					<table class=\"variations\">\n"
							+ "						<tbody>\n"
							+ "							<tr>\n"
							+ "								<td class=\"value\"><select title=\"box_style\"\n"
							+ "									data-attributetype=\"box_style\" data-id=\"pa_color\"\n"
							+ "									class=\"attribute-select \" data-show_option_none=\"yes\">\n"
							+ "										<option data-type=\"\" data-pa_color=\"\" value=\"\">Choose\n"
							+ "											an option</option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#000000\" value=\"black\"\n"
							+ "											class=\"attached enabled\">Black</option>\n"
							+ "										<option data-width=\"30\" data-height=\"30\" data-type=\"color\"\n"
							+ "											data-pa_color=\"#db2b00\" value=\"red\" class=\"attached enabled\">Red\n"
							+ "										</option>\n"
							+ "								</select>\n"
							+ "\n"
							+ "\n"
							+ "									<div class=\"data-val attribute-pa_color\"\n"
							+ "										data-attributetype=\"box_style\">\n";
							for (ProductDetailEntity productDetailEntity : productEntity.getProduct_detailGroupBySize()) {
								html += "	<a class=\"change-value color\" href=\"#\" data-value=\"red\">\n"
										+ productDetailEntity.getSize().getName() +" </a>\n";
							}
							
							
							html+= "									</div> <a class=\"reset_variations\" href=\"#\"\n"
							+ "									style=\"visibility: hidden;\">Clear</a></td>\n"
							+ "							</tr>\n"
							+ "						</tbody>\n"
							+ "					</table>\n"
							+ "				</div>\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "				<div class=\"group-button\">\n"
							+ "					<div class=\"add-to-cart\">\n"
							+ "						<a data-id='${item.id}'\n"
							+ "							class=\" btnAddToCart button product_type_simple add_to_cart_button ajax_add_to_cart\">Add\n"
							+ "							to cart</a>\n"
							+ "					</div>\n"
							+ "					<a href=\"#\" class=\"button yith-wcqv-button\">Quick View</a>\n"
							+ "					<div class=\"furgan product compare-button\">\n"
							+ "						<a href=\"#\" class=\"compare button\">Compare</a>\n"
							+ "					</div>\n"
							+ "					<div class=\"yith-wcwl-add-to-wishlist\">\n"
							+ "						<div class=\"yith-wcwl-add-button show\">\n"
							+ "							<a data-id='${item.id}' class=\"btnAddToWishlist add_to_wishlist\">Add\n"
							+ "								to Wishlist</a>\n"
							+ "						</div>\n"
							+ "					</div>\n"
							+ "				</div>\n"
							+ "			</div>\n"
							+ "			<div class=\"product-info\">\n"
							+ "\n"
							+ "				<h3 class=\"product-name product_title\">\n"
							+ "\n"
							+ "					<a href=\"/san-pham/\" + item.getSlug() + \"\">"+ productEntity.getName() +"</a>\n"
							+ "\n"
							+ "\n"
							+ "\n"
							+ "				</h3>\n"
							+ "				<span class=\"price\"><del>\n"
							+ "						<span class=\"furgan-Price-amount amount\"><span\n"
							+ "							class=\"furgan-Price-currencySymbol\">$</span>89.00</span>\n"
							+ "					</del> <ins>\n"
							+ "						<span class=\"furgan-Price-amount amount\"><span\n"
							+ "							class=\"furgan-Price-currencySymbol\">$</span>" + new DecimalFormat("###.###").format(productEntity.getPrice())  + "</span>\n"
							+ "					</ins></span>\n"
							+ "				<div class=\"rating-wapper nostar\">\n"
							+ "					<div class=\"star-rating\">\n"
							+ "						<span style=\"width: 0%\">Rated <strong class=\"rating\">0</strong>\n"
							+ "							out of 5\n"
							+ "						</span>\n"
							+ "					</div>\n"
							+ "					<span class=\"review\">(0)</span>\n"
							+ "				</div>\n"
							+ "			</div>\n"
							+ "		</div>\n"
							+ "	</div>";
				}
			
			
			
			
			
			/*
			 * mav.addObject("listProEntity", lstResult); mav.addObject("model", lstResult);
			 * int totalItem=ProRep.findByIds(cateId).size(); mav.addObject("totalItem",
			 * totalItem); int totalPage=(int) Math.ceil((double) totalItem / limit);
			 * mav.addObject("totalPage", totalPage);
			 */
		}
		
		PrintWriter out = response.getWriter();
		out.println(html);
		
		 
	}
	
	/*detail kiểu DTO
	@RequestMapping(value = "/san-pham/*", method = RequestMethod.GET)
	public ModelAndView detailProduct1(HttpServletRequest request) {
		ProductDTO productDetail = new ProductDTO();
		String req5uestURI = request.getServletPath();
		String name = req5uestURI.substring(10);
		productDetail = iPro.findBySlug(name);
		ModelAndView mav = new ModelAndView("web/productDetailDTO");
		Cookie read = wishlistService.read("Wishlist");	
		if (read!=null) {		
			String listIdCooki = read.getValue();   // danh sach id da luu trong cooki 
			String[] ids = listIdCooki.split(",");
			List<ProductEntity> l=iPro.findByidnene2(ids);
			mav.addObject("listWishlist", l);
		}
		mav.addObject("productDetail", productDetail);
		return mav;
	}*/
	
	@RequestMapping(value = "/san-pham/*", method = RequestMethod.GET)
	public ModelAndView detailProduct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/productDetail");
		String req5uestURI = request.getServletPath();
		String name = req5uestURI.substring(10);
		ProductEntity p = proRep.findBySlug(name);
		p.setViewCount(p.getViewCount()+1);
		proRep.save(p);
		
		List<ProductEntity> result = new ArrayList<ProductEntity>();
		p.setProduct_detailGroupByColor(proDetailRep.colorGroup(p.getId()));
		p.setProduct_detailGroupBySize(proDetailRep.sizeGroup(p.getId()));
		result.add(p);
		mav.addObject("lstResult", result);
		
		Cookie read = wishlistService.read("Wishlist");	
		if (read!=null) {		
			String listIdCooki = read.getValue();  
			String[] ids = listIdCooki.split(",");
			List<ProductEntity> l=iPro.findByidnene2(ids);
			mav.addObject("listWishlist", l);
		}
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getQuantityBySizeAndColor", method = RequestMethod.GET)
	public String getQuantityBySizeAndColor( @RequestParam String idSize, @RequestParam String idColor,@RequestParam String idProduct) {	
		ProductDetailEntity pro = proDetailRep.findProIdsizeAndIdColor(Long.parseLong(idSize), Long.parseLong(idColor),Long.parseLong(idProduct));
		return (pro!=null) ?  String.valueOf(pro.getQuantity()) : "0" ;
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
		mav.addObject("s", new UserEntity());
		return mav;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/isExistUserName/{name}", method = RequestMethod.GET)
	public String isExistUserName(@PathVariable String name) {
		return (userRep.findOneByUsername(name)) == null ? "true" : "false";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/xu-ly-dang-ky", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest request,@ModelAttribute("s") UserEntity user /* BindingResult bindingResult */) throws NoSuchAlgorithmException {

		/*
		 * if (bindingResult.hasErrors()) { // form validation error
		 * 
		 * } else { // form input is OK }
		 */

		user.setStt(1);
		user.setRole(roleRep.findByName("User"));
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()).toString());
		
		return (userRep.save(user)) != null ? "true" : "false";

	}
		
	@ResponseBody
	@RequestMapping(value = "/sendMailResetPass/*", method = RequestMethod.GET)
	public String sendMailResetPass(HttpSession session, HttpServletRequest request, HttpServletResponse response) {		
		String requestURI = request.getServletPath();
		String emailAddress = requestURI.substring(19);
		UserEntity u = userRep.findOneByEmail(emailAddress);
		if (u==null) {
			return "false";
		}
		else {
 		    
			String otp=RandomStringUtils.randomNumeric(6);
			
			if (iMailSer.sendMailResetPass(emailAddress,otp)) {
				
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
	public String checkCodeResetPass2( @RequestParam String email, @RequestParam String code) {

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
	public String changePass(@RequestParam String email, @RequestParam String pass  ) {
		try {
			UserEntity u = userRep.findOneByEmail(email);
			u.setPassword(new BCryptPasswordEncoder().encode(pass));
			IUserService2.clearOTP(u);
			return "true";
		} catch (Exception e) {
			return"false";
		}		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllDisstrictById/{id}", method = RequestMethod.GET)
	public List<DistrictEntity> getAllDisstrictById(@PathVariable long id) {
		return districRep.findAllById(id);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllWardById/{id}", method = RequestMethod.GET)
	public List<WardEntity> getAllWardtById(@PathVariable long id) {
		return wardRep.findAllById(id);	
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav =new ModelAndView("web/checkout");
		mav.addObject("model", new OrderDTO());	
		List<ProvinceEntity> findAll = provinceRep.findAll();
		mav.addObject("province", findAll);		
		mav.addObject("p", proRep.findAll());	
		return mav;
	}
	
	@RequestMapping(value = "/xu-ly-thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment2(HttpServletRequest request, HttpServletResponse response) {
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (SecurityUtils.getPermission().size() < 1) { 

			return new ModelAndView("redirect:/dang-nhap?returnUrl=thanh-toan");

		} else {
			// xử lý code thanh toán ở đây
			return new ModelAndView("redirect:/trang-chu?isCheckout=true");
		}

	}
		
	@ResponseBody
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpSession session,HttpServletRequest request ,  @ModelAttribute("model")  OrderDTO order) {
		session.getAttribute("scopedTarget.cartService2");
		Collection<ProductDetailEntity> cart1 = cartService.getAll();
		
		try {
			if (iOrderSer.add(order)) {
				
				//Long lastInsertId = orderRep.getLastInsertId();
				
				OrderEntity lastOder = orderRep.getLastInsertId2();
				
				lastOder.getId();
				for ( ProductDetailEntity pro :  cart1) {
					
					OrderDetailEntity o = new OrderDetailEntity();		
					o.setOrder(lastOder);
					o.setProduct_detail(pro);
					o.setPrice(pro.getQuantity_order()*pro.getProduct().getPrice()*(100-pro.getProduct().getDiscount())/100);
					o.setQuantity(pro.getQuantity_order());
					o.setSale(pro.getProduct().getDiscount());
					orderDetailRep.save(o);
					 
					/*OrderDetaiDTO  o2= new OrderDetaiDTO();
					o2.setId_order(id);
					o2.setId_productDetail(pro.getId());
					o2.setPrice(pro.getQuantity_order()*pro.getProduct().getPrice()*(100-pro.getProduct().getDiscount())/100);
					o2.setQuantity(pro.getQuantity_order());
					o2.setSale(pro.getProduct().getDiscount());
					iOrderDetailSer.add(o2);
					*/
				}
				
				iMailSer.sendMailAfterOrder( session,lastOder.getEmail(), lastOder.getCustomer_name(),lastOder.getCode(),cartService.getTotalPrice(),cart1);
				cartService.clear();
				return "true";	
			}
		} catch (Exception e) {
			return "false";
		}
		return null;
	} 
}