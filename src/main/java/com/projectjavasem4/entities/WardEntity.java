package com.projectjavasem4.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
@Entity
@Table(name = "ward")
@Data
public class WardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "_name")
	private String _name;
	@Column(name = "_id2")
	private String _id2;
	@Column(name = "_prefix")
	private String _prefix;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_district_id",nullable=false)
	@JsonIgnore
	private DistrictEntity district;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_province_id",nullable=false)
	@JsonIgnore
	private ProvinceEntity province;

}
