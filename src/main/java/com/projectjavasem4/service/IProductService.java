package com.projectjavasem4.service;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.entities.ProductEntity;
public interface IProductService {
	List<ProductDTO> findAll(Pageable pageable);
	List<ProductEntity> findAll2(Pageable pageable);	
	List<ProductDTO> getAll();
	List<ProductEntity> getAllHirbernate();
	List<ProductEntity> findBySpecical(int type);
	int getTotalItem();
	ProductDTO findById(long id);
	//List<ProductEntity> findByIds(long ids);
	List<ProductDTO> findByIds(long ids);
	List<ProductEntity> findByNames(List<String >names);
	List<ProductEntity> findByidnene(List<String> names);
	List<ProductEntity> findByidnene2(String[] names);
	List<ProductEntity> findByIdsListString(List<String> supplierNames);
	ProductDTO findByName(String name);
	ProductDTO findBySlug(String slug);
	boolean save(ProductDTO dto);
	boolean delete(long[] ids);
	boolean deleteById(long id);	
}
