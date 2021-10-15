package com.projectjavasem4.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectjavasem4.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	ProductEntity findByName(String name);

	ProductEntity findBySlug(String slug);

	ProductEntity findById(Long id);

	@Query(nativeQuery = true, value = "SELECT t2.name , count(t1.id_category)  FROM product t1\n"
			+ "INNER JOIN category t2 ON t1.id_category = t2.id\n" + "group by id_category ")
	List<Object[]> getListRateOfProductsByCategory();

	@Query(nativeQuery = true, value = "SELECT * FROM product as e WHERE e.id_category = :id") 
	List<ProductEntity> findByIds(@Param("id") Long id);

	@Query(nativeQuery = true, value = "SELECT * FROM product as e WHERE e.id_category = :id") 
	List<ProductEntity> getalll222222(@Param("id") Long id);

	@Query(nativeQuery = true, value = "SELECT * FROM product WHERE id_category = :id LIMIT :skipCount, :takeCount") 
	List<ProductEntity> findByIdCate(@Param("id") Long id, @Param("skipCount") Long skipCount,
	@Param("takeCount") Long takeCount);

	List<ProductEntity> findByIdIn(List<String> ids);

	@Query(nativeQuery = true, value = "SELECT * FROM product as e WHERE e.id IN :names") 
																							
	List<ProductEntity> findByNames(@Param("names") List<String> names);

	@Query(nativeQuery = true, value = "SELECT * FROM product as e WHERE e.id IN :names") 
																							
	List<ProductEntity> findByNames222(@Param("names") String names);

	@Query(nativeQuery = true, value = "SELECT * FROM product u WHERE u.id IN :ids") 
																						
	List<ProductEntity> findUserByids2(@Param("ids") Collection<String> ids);

	@Query(nativeQuery = true, value = "SELECT * FROM product u WHERE u.id IN :ids") 
																						
	List<ProductEntity> findUserByids22(@Param("ids") String[] ids);

	@Query(nativeQuery = true, value = "SELECT * FROM product t1 right JOIN product_detail t2 ON t1.id = t2.id_product right JOIN orderdetail t3 ON t2.id = t3.id_productDetail group by t1.name order by count(t3.id_productDetail) desc")
	List<ProductEntity> getListBestSelling();

	@Query(nativeQuery = true, value = "SELECT t1.name, count(t3.id_productDetail) FROM product t1 right JOIN product_detail t2 ON t1.id = t2.id_product right JOIN orderdetail t3 ON t2.id = t3.id_productDetail group by t1.name order by count(t3.id_productDetail) desc")
	List<Object[]> getListBestSellingForChair();

	@Query(nativeQuery = true, value = "SELECT * FROM  product order by createddate DESC  limit 1")
	ProductEntity getLastInsertId();

}
