package com.projectjavasem4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Table(name = "productImage")
@Data
public class ProductImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "img", columnDefinition = "TEXT")
	private String img;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_productDetail",nullable=false)
	@JsonIgnore
	private ProductDetailEntity product_detail;
	
}
