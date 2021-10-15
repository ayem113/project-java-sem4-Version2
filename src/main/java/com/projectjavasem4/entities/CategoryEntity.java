package com.projectjavasem4.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Table(name = "category")
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_parent")
	private Long id_parent;

	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;

	@Column(name = "img", columnDefinition = "TEXT")
	private String img;

	@Column(name = "list_img", columnDefinition = "TEXT")
	private String list_img;

	@Column(name = "stt")
	private Boolean stt;

	@OneToMany(mappedBy = "category")  //@JsonIgnore
	private List<ProductEntity> products = new ArrayList<>();

}
