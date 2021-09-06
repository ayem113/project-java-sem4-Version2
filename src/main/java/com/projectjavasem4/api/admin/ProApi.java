package com.projectjavasem4.api.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectjavasem4.dto.AbstractDTO;
import com.projectjavasem4.entities.ProductEntity;


@RestController(value = "ProductAPIOfAdmin2")


@RequestMapping("/api/product2")

public class ProApi  extends BaseApi<ProductEntity,  AbstractDTO<ProductEntity> >{
	
	
}
