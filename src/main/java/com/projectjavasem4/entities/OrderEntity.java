package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity extends BaseEntity{

	@Column(name = "address", columnDefinition = "TEXT")
	private String address;
	
	@Column(name = "name", columnDefinition = "TEXT")
	private String name;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "stt")
	private Boolean stt;
	
	@Column(name = "sale")
	private Byte sale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private UserEntity user;
	
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();



	
	
}
