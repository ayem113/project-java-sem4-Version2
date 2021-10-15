package com.projectjavasem4.controller.admin;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.service.IProductService;

@Controller(value = "homeControllerOfAdmin")

@RequestMapping("/quan-tri")
public class HomeController {
	@Autowired private IProductService newService;
	@Autowired private ProductRepository proRep;
	@RequestMapping(value = "/chart/data", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductEntity> data() {
		List<ProductEntity> kq=new ArrayList<ProductEntity>();	
		for (ProductEntity x : proRep.findAll()) {
			x.setProduct_detail(null);
			x.setComments(null);
			x.setCategory(null);
			x.setProduct_detailGroupByColor(null);
			x.setProduct_detailGroupBySize(null);
			kq.add(x);
		}
		return kq.stream().skip(0).limit(5).collect(Collectors.toList()) ;
	}
	
	private float percent(Object entry,int total ){	
		Integer parseInt = ((BigInteger) entry).intValue();
		float percent = (parseInt * 100.0f) / total;
		//int percen2 = (int)((parseInt * 100.0f) / total);
		return  percent;
	}
	

	@RequestMapping(value = "/trangchu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView m=new ModelAndView("admin/home");
		 m.addObject("List", newService.getAll());
		 List<Object[]> listRateOfProductsByCategory = proRep.getListRateOfProductsByCategory();		 
		 List<Object[]> listBestSellingForChair = proRep.getListBestSellingForChair();
		 List<ProductEntity> listInterested=proRep.findAll().stream().sorted(Comparator.comparing(ProductEntity::getViewCount).reversed()).limit(10).collect(Collectors.toList());
		 Map<Object,Object> map = null;Map<Object,Object> map2 = null;
		 List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		 List<List<Map<Object,Object>>> list2 = new ArrayList<List<Map<Object,Object>>>();
		 List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		 List<Map<Object,Object>> dataPoints2 = new ArrayList<Map<Object,Object>>();
 
		 for (Object[] entry : listRateOfProductsByCategory) { 
			    float percentage = percent(entry[1],proRep.findAll().size());
			    map = new HashMap<Object,Object>(); 
				map.put("label", entry[0]);
				map.put("y", percentage);
				dataPoints1.add(map);
		}
		 
		for (Object[] entry : listBestSellingForChair) {				
			    map2 = new HashMap<Object,Object>(); 
				map2.put("label", entry[0]);
				map2.put("y", entry[1]);
				dataPoints2.add(map2);
		}
		 
		 list.add(dataPoints1); 
		 list2.add(dataPoints2);
		 
		 m.addObject("dataPointsList", list);
		 m.addObject("dataPointsList2", list2);
		 m.addObject("listInterested", listInterested);
		 
		 return m;
	}
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trangchu");
	}

}