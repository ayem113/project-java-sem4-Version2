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
@Table(name = "comment")
@Data
@EqualsAndHashCode(callSuper = true)
public class CommentEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "content",columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "stt")
	private Boolean stt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user",nullable=false)
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product",nullable=false)
	private ProductEntity product;

}
