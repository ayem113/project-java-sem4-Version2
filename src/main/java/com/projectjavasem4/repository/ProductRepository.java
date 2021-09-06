package com.projectjavasem4.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.entities.ProductEntity;

//@Repository
//@Component
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity findByName(String name);

	ProductEntity findById(Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM product as e WHERE e.id_category = :id") // 3. Spring JPA In cause
	List<ProductEntity> findByIds(@Param("id") Long id);
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM product WHERE id_category = :id LIMIT :skipCount, :takeCount") // 3. Spring JPA In cause
	List<ProductEntity> findByIdCate(@Param("id") Long id,@Param("skipCount") Long skipCount,@Param("takeCount") Long takeCount);
	
	

	ProductEntity findBySlug(String slug);
	// List<ProductEntity> findByIdIn(String ids);

	List<ProductEntity> findByIdIn(List<String> ids);

	/*
	 * @Query("SELECT * FROM product  WHERE id IN (ids)") List<ProductEntity>
	 * xxx(String ids);
	 */

	/*
	 * @Query("SELECT e FROM product e WHERE e.name IN (:names)") // 2. Spring JPA
	 * In cause using @Query List<ProductEntity>
	 * findByName(@Param("names")List<String> names);
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM product as e WHERE e.id IN :names") // 3. Spring JPA In cause
																							// using native query
	List<ProductEntity> findByNames(@Param("names") List<String> names);

	@Query(nativeQuery = true, value = "SELECT * FROM product as e WHERE e.id IN :names") // 3. Spring JPA In cause
																							// using native query
	List<ProductEntity> findByNames222(@Param("names") String names);

	@Query(nativeQuery = true, value = "SELECT * FROM product u WHERE u.id IN :ids") // SELECT u FROM product u WHERE
																						// u.id IN :ids sqlserver
	List<ProductEntity> findUserByids2(@Param("ids") Collection<String> ids);

	@Query(nativeQuery = true, value = "SELECT * FROM product u WHERE u.id IN :ids") // SELECT u FROM product u WHERE
																						// u.id IN :ids sqlserver
	List<ProductEntity> findUserByids22(@Param("ids") String[] ids);

}
