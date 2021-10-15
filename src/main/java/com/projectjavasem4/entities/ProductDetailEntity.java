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
import lombok.EqualsAndHashCode;
@Entity
@Table(name = "product_detail")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDetailEntity extends BaseEntity {

	public ProductDetailEntity() {
		super();
	}
	public ProductDetailEntity(ProductEntity product, ColorEntity color, SizeEntity size) {
		super();
		this.product = product;
		this.color = color;
		this.size = size;
	}
	
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product",nullable=false)
	//@JsonIgnore
	private ProductEntity product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_color",nullable=false)
	//@JsonIgnore
	private ColorEntity color;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_size",nullable=false)
	//@JsonIgnore
	private SizeEntity size;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "quantityOrder" )
	private int quantity_order;
	
	@OneToMany(mappedBy = "product_detail") 
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();
	@OneToMany(mappedBy = "product_detail") 
	private List<ProductImageEntity> productImages = new ArrayList<>();

	
}
