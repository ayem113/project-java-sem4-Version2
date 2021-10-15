package com.projectjavasem4.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import org.hibernate.annotations.Entity;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// @JsonIgnore
	@Column(name = "name")
	private String name;

	@Column(name = "slug")
	private String slug;
	
	@Column(name = "viewCount")
	private int viewCount;

	@Column(name = "discount")
	private Integer discount;

	@Column(name = "price")
	private Float price;

	@Column(name = "quantity")
	private Integer quantity; 

	@Column(name = "img", columnDefinition = "TEXT")
	private String img;

	@Column(name = "stt")
	private String stt;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", nullable = false)
	@JsonIgnore
	private CategoryEntity category;

	@OneToMany(mappedBy = "product")
	private List<ProductDetailEntity> product_detail = new ArrayList<>(); 

	@OneToMany(mappedBy = "product")
	List<ProductDetailEntity> product_detailGroupByColor = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	List<ProductDetailEntity> product_detailGroupBySize = new ArrayList<>();

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<CommentEntity> comments = new ArrayList<>();

}
