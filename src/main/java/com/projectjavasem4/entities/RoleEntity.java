package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class RoleEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "role")
	private List<UserEntity> users = new ArrayList<>();

	@OneToMany(mappedBy = "role")
	private List<PermissionDetailEntity> permissionDetails = new ArrayList<>();



}
