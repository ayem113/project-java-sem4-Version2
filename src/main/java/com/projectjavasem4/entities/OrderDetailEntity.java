package com.projectjavasem4.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "orderDetail")
@Data
public class OrderDetailEntity extends BaseEntity{

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "sale")
	private Byte sale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order",nullable=false)
	private OrderEntity order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product",nullable=false)
	private ProductEntity product;

	
}
