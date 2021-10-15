package com.projectjavasem4.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.projectjavasem4.entities.ColorEntity;
import com.projectjavasem4.entities.ProductDetailEntity;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.entities.SizeEntity;
import com.projectjavasem4.repository.ColorRepository;
import com.projectjavasem4.repository.ProductDetailRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.repository.SizeRepository;

@SessionScope  // name= scopedTarget.cartService
@Service
public class CartService {

	@Autowired
	ProductRepository rep;
	@Autowired
	ProductDetailRepository proDetailRep;
	@Autowired
	ColorRepository colorRep;
	@Autowired
	SizeRepository sizeRep;
	@Autowired
	ProductRepository proRep;

	Map<Long, ProductDetailEntity> map = new HashMap<>();

	public boolean add(int quantity,Long idSize,Long idColor,Long idProduct) {
		ColorEntity findColor = colorRep.findOne(idColor);
		SizeEntity findSize = sizeRep.findOne(idSize);
		ProductEntity findPro=proRep.findOne(idProduct);
		
		ProductDetailEntity ProDetailCheck= proDetailRep.findProIdsizeAndIdColor(findSize.getId(), findColor.getId(), findPro.getId());
		
		Long idProDetailCheck=ProDetailCheck.getId();
		
		ProductDetailEntity p = map.get(idProDetailCheck);
		
		if (p == null) { //nếu chưa có trong giỏ
			p=proDetailRep.findOne(idProDetailCheck);
			p.setQuantity_order(quantity);
			map.put(p.getId(), p);
			return true;
		} else {  //đã có trong giỏ
			//  nếu k muốn check sp đã tồn tại trong giỏ hàng chưa thì update số lượng
			//p.setQuantity_order(p.getQuantity_order()+quantity);
			return false;
		}
	}

	public void editQuantity(long id, int quantity) {
		ProductDetailEntity p = map.get(id);
		p.setQuantity_order(quantity);
	}
	
	public void editSizeOrColor(long id,long idSize,long idColor) {
		ProductDetailEntity p = map.get(id);
		p.setSize(sizeRep.findOne(idSize));
		p.setColor(colorRep.findOne(idColor));
	}

	public void remove(long id) {
    	map.remove(id);
	}

	public Collection<ProductDetailEntity> getAll() {
		return map.values();
	}

	public int getTotalItems() {
		return map.size();
	}

	public Double getTotalPrice() {
		Collection<ProductDetailEntity> l = this.getAll();
		double count = 0;
		for (@SuppressWarnings("unused") ProductDetailEntity p : l) {
			// count+=p.getPrice()*p.getQuantity() - ( (p.getPrice()* p.getDiscount()/100)
			// *p.getQuantity()) ;
			//count += (p.getPrice() * p.getQuantity() * ((100 - p.getDiscount()))) / 100;
		}
		return count;
	}

	public void clear() {
		map.clear();
	}
}
