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
@Table(name = "role")
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "role")
	private List<UserEntity> users = new ArrayList<>();

	@OneToMany(mappedBy = "role")
	private List<PermissionDetailEntity> permissionDetails = new ArrayList<>();

}
