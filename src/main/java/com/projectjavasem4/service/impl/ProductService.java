package com.projectjavasem4.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.slugify.Slugify;
import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.entities.CategoryEntity;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.repository.CategoryRepository;
import com.projectjavasem4.repository.GenericRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.service.IProductService;

@Service
public class ProductService implements IProductService {

	@SuppressWarnings("unused")
	@Autowired
	private GenericRepository<ProductEntity> genProRep;
	@Autowired
	private ProductRepository proRep;
	@Autowired
	private CategoryRepository CatRep;

	@Override
	public List<ProductDTO> findAll(Pageable pageable) {

		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = proRep.findAll(pageable).getContent();
		for (ProductEntity item : entities) {
			ProductDTO p = new ModelMapper().map(item, ProductDTO.class);
			models.add(p);
		}
		return models;

	}

	@Override
	public int getTotalItem() {
		return (int) proRep.count();
	}

	@Override
	public ProductDTO findById(long id) {

		ProductEntity pro = proRep.findOne(id);
		Long id2 = pro.getCategory().getId();
		
		
		ProductDTO dto= new ProductDTO();
		 
		BeanUtils.copyProperties(pro, dto);  //c1 dung BeanUtils
		// dto =new ModelMapper().map(pro, ProductDTO.class);  cach 2 dung ModelMapper
		dto.setId_category(id2);
		return dto; 
		

		// proRep.getOne(id);
	}
	
	
	
	
	  

	@Override
	public boolean save(ProductDTO dto) {

		try {
			
			
			
			CategoryEntity c = CatRep.findOne(dto.getId_category()); 
			
			  ProductEntity p = new ProductEntity(); 
			  p.setCategory(c);
			  
			  String slug=new Slugify().slugify(dto.getName());
			  
			  
			  
			  dto.setSlug(slug);
			
				/*
				 * CommonsMultipartFile myFile=dto.getFileUpload();
				 * p.setImg(myFile.getOriginalFilename());
				 */
			  
			  
			  BeanUtils.copyProperties(dto, p);
			  proRep.save(p);
			   //new ModelMapper().map(proRep.save(p), ProductDTO.class);
			 
			return true;
		} catch (Exception e) {
			return false;
		}

		/*
		 * ProductEntity pro = new ModelMapper().map(dto, ProductEntity.class);
		 * CategoryEntity c = CatRep.findOne(dto.getId_category()); pro.setCategory(c);
		 * ProductEntity t = proRep.save(pro); ProductDTO p = new ModelMapper().map(t,
		 * ProductDTO.class); p.setId_category(c.getId());
		 */

//		try {
//			ProductEntity e = new ProductEntity();
//			e.setCategory(c);
//			for (Field f : dto.getClass().getDeclaredFields()) {
//				for (Field f1 : ProductEntity.class.getDeclaredFields()) {
//					if(f.getName().equals(f1.getName()) && f.getType() == f1.getType()) {
//						if(f1.getType() == int.class) {
//							e.getClass().getField(f1.getName()).setInt(e, dto.getClass().getField(f.getName()).getInt(dto));
//						}
//					}
//				}
//			}
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			return null;
//		}

	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			proRep.delete(id);
		}
	}

	@Override
	public List<ProductDTO> getAll() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = proRep.findAll();
		for (ProductEntity item : entities) {
			ProductDTO p = new ModelMapper().map(item, ProductDTO.class);
			p.setId_category(item.getCategory().getId());
			models.add(p);
		}
		return models;
	}

	@Override
	public void deleteById(long id) {
		proRep.delete(id);

	}

	@Override
	public ProductDTO findByName(String name) {
		// TODO Auto-generated method stub
		return new ModelMapper().map(proRep.findByName(name), ProductDTO.class) ;
	}

	@Override
	public ProductDTO findBySlug(String slug) {
		// TODO Auto-generated method stub
		 return new ModelMapper().map(proRep.findBySlug(slug), ProductDTO.class) ;
	}

	
	@Override
	public List<ProductEntity> findByIdsListString(List<String> ids) {
		/*
		 * List<ProductEntity> findByIds = proRep.findByIdIn(ids); return findByIds;
		 */
		return null;
	}

	@Override
	public List<ProductEntity> findByidnene(List<String> name) {
		 return proRep.findUserByids2(name); 
		 
	}

	@Override
	public List<ProductEntity> findByNames(List<String> names) {
		  return	proRep.findByNames(names);
	}

	@Override
	public List<ProductEntity> findByidnene2(String[] names) {
		return proRep.findUserByids22(names); 
	}

	@Override
	public List<ProductDTO> findByIds(long ids) {
		
			//return null;
			
			  
			
			   
			   List<ProductDTO> models = new ArrayList<>();
				List<ProductEntity> entities = proRep.findByIds(ids);
				for (ProductEntity item : entities) {
					ProductDTO p = new ModelMapper().map(item, ProductDTO.class);
					p.setId_category(item.getCategory().getId());
					models.add(p);
				}
				return models;
			 
		

		//return null;
	}

}
