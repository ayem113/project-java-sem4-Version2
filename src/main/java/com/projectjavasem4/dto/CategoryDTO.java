package com.projectjavasem4.dto;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	
	

	private Long id_parent;

	private String name;

	private String img;

	private String list_img;

	private Boolean stt;

	public Long getId_parent() {
		return id_parent;
	}

	public void setId_parent(Long id_parent) {
		this.id_parent = id_parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getList_img() {
		return list_img;
	}

	public void setList_img(String list_img) {
		this.list_img = list_img;
	}

	public Boolean getStt() {
		return stt;
	}

	public void setStt(Boolean stt) {
		this.stt = stt;
	}
	
	
	
	
}
