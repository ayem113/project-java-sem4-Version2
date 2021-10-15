package com.projectjavasem4.entities;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Table(name = "permissionDetail")
@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionDetailEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permission",nullable=false)
	private PermissionEntity permission;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role",nullable=false)
	private RoleEntity role;
	
}
