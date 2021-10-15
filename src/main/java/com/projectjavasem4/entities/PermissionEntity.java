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
@Table(name = "permission")
@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "permission")
	private List<PermissionDetailEntity> permissionDetails = new ArrayList<>();

}
