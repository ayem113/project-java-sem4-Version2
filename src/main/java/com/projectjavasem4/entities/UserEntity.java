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
@Table(name = "users")
@Data
public class UserEntity extends BaseEntity {

	
	@Column(name = "captcha")
	private String captcha;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "address",columnDefinition = "TEXT")
	private String address;
	
	@Column(name = "img",columnDefinition = "TEXT")
	private String img;

	@Column(name="stt")
	private Integer stt;
	
	@OneToMany(mappedBy = "user")
	private List<OrderEntity> orders = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<CommentEntity> comments = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role",nullable=false)
	
	
	private RoleEntity role;

	
	
	
	
	
	

}
