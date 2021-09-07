package com.projectjavasem4.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectjavasem4.dto.OrderDetaiDTO;
import com.projectjavasem4.entities.OrderDetailEntity;
import com.projectjavasem4.repository.OrderDetailRepository;
import com.projectjavasem4.repository.OrderRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.service.IOrderDetailService;
@Service
public class OrderDetailService  implements IOrderDetailService{

	@Autowired OrderDetailRepository orderRep;
	@Autowired OrderRepository orRep;
	@Autowired ProductRepository proRep;
	
	@Override
	public boolean add(OrderDetaiDTO dto) {
		try {
			OrderDetailEntity order= new OrderDetailEntity();
			
			order.setOrder(orRep.findOne(dto.getId_order()));
			order.setProduct((proRep.findOne(dto.getId_product())));
			order.setQuantity(dto.getQuantity());
			order.setPrice(dto.getPrice());
			
			//BeanUtils.copyProperties(dto, order);
			
			//OrderDetailEntity orde2r=order;
			
			  orderRep.save(order);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
