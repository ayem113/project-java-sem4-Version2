package com.projectjavasem4.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "province")
@Data
public class ProvinceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "_name")
	private String _name;
	
	@Column(name = "_code")
	private String _code;
	
	@OneToMany(mappedBy = "province")
	private List<DistrictEntity> districts = new ArrayList<>();
	
}
