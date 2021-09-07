package com.projectjavasem4.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectjavasem4.dto.OrderDTO;
import com.projectjavasem4.entities.OrderEntity;
import com.projectjavasem4.repository.OrderRepository;
import com.projectjavasem4.service.IOrderService;
@Service
public class OrderService implements IOrderService {

	
	
	@Autowired OrderRepository orderRep;
	
	
	@Override
	public boolean add(OrderDTO dto) {
		try {
			OrderEntity order= new OrderEntity();
			BeanUtils.copyProperties(dto, order);
			  orderRep.save(order);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	

}
