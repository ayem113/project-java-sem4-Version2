package com.projectjavasem4.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ward")
@Data
public class WardEntity extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_district",nullable=false)
	private DistrictEntity district;

}
