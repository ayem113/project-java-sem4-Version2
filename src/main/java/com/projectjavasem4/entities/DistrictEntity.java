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
@Table(name = "district")
@Data
public class DistrictEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy = "district")
	private List<WardEntity> wards = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_province",nullable=false)
	private ProvinceEntity province;

	
}
