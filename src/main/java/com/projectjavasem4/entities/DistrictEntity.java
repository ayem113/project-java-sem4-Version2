package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "district")
@Data
public class DistrictEntity   {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "_name")
	private String _name;
	
	@Column(name = "_id2")
	private int _id2;
	
	@Column(name = "_prefix")
	private String _prefix;
	
	@OneToMany(mappedBy = "district")
	private List<WardEntity> wards = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_province_id",nullable=false)
	@JsonIgnore
	private ProvinceEntity province;
	
}
