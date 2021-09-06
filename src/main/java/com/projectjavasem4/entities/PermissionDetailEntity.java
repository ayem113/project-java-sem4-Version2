package com.projectjavasem4.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "permissionDetail")
@Data
public class PermissionDetailEntity extends BaseEntity{

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permission",nullable=false)
	private PermissionEntity permission;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role",nullable=false)
	private RoleEntity role;
	
}
