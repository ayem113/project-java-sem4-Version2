package com.projectjavasem4.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Table(name = "orderDetail")
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDetailEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "sale")
	private int sale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order",nullable=true)
	private OrderEntity order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_productDetail",nullable=true)
	private ProductDetailEntity product_detail;

}
