package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "province")
@Data
public class ProvinceEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy = "province")
	private List<DistrictEntity> districts = new ArrayList<>();

	
}
