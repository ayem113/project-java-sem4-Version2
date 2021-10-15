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
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.service.IProductService;

@Service
public class ProductService implements IProductService {

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
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(pro, dto); // c1 dung BeanUtils
		// dto =new ModelMapper().map(pro, ProductDTO.class); cach 2 dung ModelMapper
		dto.setId_category(id2);
		return dto;
		// proRep.getOne(id);
	}

	@Override
	public boolean save(ProductDTO dto) {
		try {
			// CategoryEntity c = CatRep.findOne(dto.getId_category());
			CategoryEntity c = CatRep.findByCode(dto.getCategoryCode());
			ProductEntity p = new ProductEntity();
			p.setCategory(c);
			String slug = new Slugify().slugify(dto.getName());
			dto.setSlug(slug);
			/*
			 * CommonsMultipartFile myFile=dto.getFileUpload();
			 * p.setImg(myFile.getOriginalFilename());
			 */
			BeanUtils.copyProperties(dto, p);
			p.setStt("1");
			proRep.save(p);
			// new ModelMapper().map(proRep.save(p), ProductDTO.class);
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
	public boolean delete(long[] ids) {
		try {
			for (long id : ids) {
				proRep.delete(id);
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<ProductDTO> getAll() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = proRep.findAll();
		for (ProductEntity item : entities) {
			ProductDTO p = new ModelMapper().map(item, ProductDTO.class);
			p.setId_category(item.getCategory().getId());
			p.setName_category(item.getCategory().getName());
			if (item.getStt().equals("1")) {
				p.setStt("Hiển thị");
			} else {
				p.setStt("Ẩn");
			}
			models.add(p);
		}
		return models;
	}

	@Override
	public boolean deleteById(long id) {
		try {
			proRep.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ProductDTO findByName(String name) {
		return new ModelMapper().map(proRep.findByName(name), ProductDTO.class);
	}

	@Override
	public ProductDTO findBySlug(String slug) {
		return new ModelMapper().map(proRep.findBySlug(slug), ProductDTO.class);
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
		return proRep.findByNames(names);
	}

	@Override
	public List<ProductEntity> findByidnene2(String[] names) {
		return proRep.findUserByids22(names);
	}

	@Override
	public List<ProductDTO> findByIds(long ids) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = proRep.findByIds(ids);
		for (ProductEntity item : entities) {
			ProductDTO p = new ModelMapper().map(item, ProductDTO.class);
			p.setId_category(item.getCategory().getId());
			models.add(p);
		}
		return models;
	}

	@Override
	public List<ProductEntity> findAll2(Pageable pageable) {
		List<ProductEntity> entities = proRep.findAll(pageable).getContent();
		return entities;
	}

	@Override
	public List<ProductEntity> findBySpecical(int type) {
		return null;
		/*
		 * List<ProductEntity> lst= new ArrayList<ProductEntity>(); List<ProductEntity>
		 * lstResult =
		 * proRep.findAll().stream().skip(0).limit(5).collect(Collectors.toList());;
		 * //List<ProductEntity>
		 * lstResult=proRep.findAll().stream().sorted(Comparator.comparing(ProductEntity
		 * ::getCreatedDate).reversed()).collect(Collectors.toList());
		 * lstResult=lstResult.stream().limit(10).collect(Collectors.toList());
		 * ProductEntity p=new ProductEntity(); for (ProductEntity productEntity :
		 * lstResult) { List<ProductDetailEntity> colorGroup =
		 * proDetailRep.colorGroup(productEntity.getId()); List<ProductDetailEntity>
		 * sizeGroup = proDetailRep.sizeGroup(productEntity.getId());
		 * productEntity.setProduct_detailGroupByColor(null);
		 * productEntity.setProduct_detailGroupBySize(null);
		 * productEntity.setCategory(null); productEntity.setComments(null);
		 * lst.add(productEntity); p=productEntity; int c; } return lst;
		 */
	}

	@Override
	public List<ProductEntity> getAllHirbernate() {
		return null;
		/*
		 * List<ProductEntity> l= new ArrayList<ProductEntity>(); try { l=
		 * HibernateUtil.getSessionFactory().openSession().
		 * createQuery("from ProductEntity").list(); //product //List<Book>
		 * list=SessionFactory.getCurrentSession().createQuery("from Book").list(); }
		 * catch (Exception e) { e.printStackTrace();
		 * System.out.println(e.getMessage().toString()); } return l;
		 */
	}

}
