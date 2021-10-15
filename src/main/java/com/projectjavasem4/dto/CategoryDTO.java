package com.projectjavasem4.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends AbstractDTO<CategoryDTO> {

	private Long id_parent;
	private String name;
	private String img;
	private String list_img;
	private Boolean stt;

}
