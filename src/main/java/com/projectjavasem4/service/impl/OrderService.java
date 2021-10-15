package com.projectjavasem4.service.impl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectjavasem4.dto.OrderDTO;
import com.projectjavasem4.entities.OrderEntity;
import com.projectjavasem4.repository.OrderRepository;
import com.projectjavasem4.service.IOrderService;
@Service
public class OrderService implements IOrderService {

	@Autowired private OrderRepository orderRep;
	@Override
	public boolean add(OrderDTO dto) {
		try {
			//user=null ,orderDetails=[]
			OrderEntity order= new OrderEntity();
			BeanUtils.copyProperties(dto, order);
			order.setCode(RandomStringUtils.randomNumeric(6));	
			order.setDelivery_status("Đang vận chuyển");
			order.setStt("1");
			//OrderEntity order2=order;
			orderRep.save(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
		}
		return false;
	}
}
