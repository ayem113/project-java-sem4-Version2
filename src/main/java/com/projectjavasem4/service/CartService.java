package com.projectjavasem4.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.repository.ProductRepository;

@SessionScope  
// name= scopedTarget.cartService
@Service
public class CartService {

	@Autowired
	ProductRepository rep;
	Map<Long, ProductEntity> map = new HashMap<>();

	public void add(long id) {

		ProductEntity p = map.get(id);

		if (p == null) {

			p = rep.findOne(id);
			p.setQuantity(1);
			map.put(id, p);

		} else {

			p.setQuantity(p.getQuantity() + 1);
		}
	}
	
	public boolean add2(long id) {

		ProductEntity p = map.get(id);

		if (p == null) {

			p = rep.findOne(id);
			p.setQuantity(1);
			map.put(id, p);
			return true;

		} else {

			return false;
		}
	}

	public void eidt(long id, int quantity) {

		ProductEntity p = map.get(id);
		p.setQuantity(quantity);
	}

	public void remove(long id) {

		map.remove(id);

	}

	public Collection<ProductEntity> getAll() {
		return map.values();

	}

	public int getTotalItems() {
		/*
		 * Collection<ProductEntity> l = this.getAll(); int count=0; for(ProductEntity p
		 * : l){ count+=p.getQuantity(); };
		 */

		return map.size();

	}

	public Double getTotalPrice() {
		Collection<ProductEntity> l = this.getAll();
		double count = 0;
		for (ProductEntity p : l) {
			// count+=p.getPrice()*p.getQuantity() - ( (p.getPrice()* p.getDiscount()/100)
			// *p.getQuantity()) ;
			count += (p.getPrice() * p.getQuantity() * ((100 - p.getDiscount()))) / 100;
		}
		;

		return count;

	}

	public void clear() {

		map.clear();

	}

}
